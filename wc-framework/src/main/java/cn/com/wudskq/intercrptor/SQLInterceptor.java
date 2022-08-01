package cn.com.wudskq.intercrptor;


import cn.com.wudskq.annotation.TenantInterceptor;
import cn.com.wudskq.model.SysUserDetails;
import cn.com.wudskq.utils.JWTTokenUtil;
import cn.com.wudskq.utils.ServletUtils;
import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.expr.SQLBinaryOpExpr;
import com.alibaba.druid.sql.ast.expr.SQLBinaryOperator;
import com.alibaba.druid.sql.ast.statement.SQLSelect;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.parser.SQLExprParser;
import com.alibaba.druid.sql.parser.SQLParserUtils;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import com.alibaba.druid.util.JdbcUtils;
import com.baomidou.mybatisplus.annotation.DbType;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.*;

import static org.apache.ibatis.reflection.SystemMetaObject.DEFAULT_OBJECT_FACTORY;
import static org.apache.ibatis.reflection.SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY;


/**
 * @author chenfangchao
 * @title: SQLInterceptor
 * @projectName wc-manager-system
 * @description: TODO mybatis拦截器
 * @date 2022/7/31 3:59 PM
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class}),
})
public class SQLInterceptor implements Interceptor{

    Logger logger = LoggerFactory.getLogger(getClass());

    private Properties properties = new Properties();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //负责处理Mybatis与JDBC之间Statement的交互
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();

        //MetaObject是Mybatis提供的一个用于方便、优雅访问对象属性的对象，通过它可以简化代码、不需要try/catch各种reflect异常，同时它支持对JavaBean、Collection、Map三种类型对象的操作。
        MetaObject metaObject = MetaObject
                .forObject(statementHandler, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY,
                        new DefaultReflectorFactory());

        //获取当前执行的SQLId
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");

        //获取类限定名
        String fullClassMethodName = "";
        if(mappedStatement.getId().contains("_"))
        {
             fullClassMethodName = mappedStatement.getId().substring(0, mappedStatement.getId().lastIndexOf("_"));
        }else{
            fullClassMethodName = mappedStatement.getId();
        }


        //获取当前绑定的SQL
        BoundSql boundSql = statementHandler.getBoundSql();
        //解析SQL语句
        SQLStatementParser sqlParser = SQLParserUtils.createSQLStatementParser(boundSql.getSql(), DbType.MYSQL.getDb());
        SQLStatement stmt = sqlParser.parseStatementList().get(0);

        //当当前执行器为SQL查询执行器时
        if (stmt instanceof SQLSelectStatement) {
            //反射获取对应类
            Class<?> mapperClass = Class.forName(getClassName(fullClassMethodName));
            //反射获取执行的类的方法
            Method  methodClass = getMethodByMethodName(getMethodName(fullClassMethodName), mapperClass.getMethods());
            //判断方法上有无注解
            TenantInterceptor annotation = methodClass.getAnnotation(TenantInterceptor.class);
            if(null == annotation){
                return invocation.proceed();
            }

            //特殊情况admin用户拥有最高权限,不用使用系统租户代码过滤数据
            SysUserDetails currentLoginUser = JWTTokenUtil.getCurrentLoginUser();
            if("admin".equals(currentLoginUser.getUsername()))
            {
                return invocation.proceed();
            }

            //拿到select执行器
            SQLSelectStatement selectStmt = (SQLSelectStatement) stmt;
            SQLSelect sqlselect = selectStmt.getSelect();

            //获取query锁
            SQLSelectQueryBlock query = (SQLSelectQueryBlock) sqlselect.getQuery();
            SQLExpr whereExpr = query.getWhere();


            //获取用户多租户权限代码
            String tenantCodePermission = ServletUtils.getTenantCodePermission();

            //生成需要在Where语句后面跟随的SQL
            String SQL = String.format("%s,'%s","find_in_set(tenant_code",tenantCodePermission+"'"+")");

            SQLExprParser constraintsParser = SQLParserUtils.createExprParser(SQL, JdbcUtils.MYSQL);
            SQLExpr constraintsExpr = constraintsParser.expr();

            // 修改where表达式
            if (whereExpr == null) {
                query.setWhere(constraintsExpr);
            } else {
                SQLBinaryOpExpr newWhereExpr = new SQLBinaryOpExpr(
                        whereExpr, SQLBinaryOperator.BooleanAnd, constraintsExpr);
                query.setWhere(newWhereExpr);
            }
            //重置query
            sqlselect.setQuery(query);
            String sql = sqlselect.toString();

            //通过反射修改sql语句
            Field field = boundSql.getClass().getDeclaredField("sql");
            field.setAccessible(true);
            field.set(boundSql, sql);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }


    /**
     * 获取类全限定名
     * @param fullMethodName
     * @return
     */
    private String getClassName(String fullMethodName){
        return fullMethodName.substring(0,fullMethodName.lastIndexOf("."));
    }

    /**
     * 通过全方法名(类.方法名)获取方法名
     * @param fullMethodName
     * @return
     */
    private static String getMethodName(String fullMethodName){
        return fullMethodName.substring(fullMethodName.lastIndexOf(".")+1);
    }


    private Method getMethodByMethodName(String methodName,Method[] methods) {
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                return method;
            }
        }
        return null;
    }
}

