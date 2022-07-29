### 后端部署手册

### 前置条件

1. JDK1.8
2. Maven
3. Redis
4. 阿里云OSS (非必要,配置为空项目也可启动,但上传文件相关接口不能使用)
4. XXL-JOB (非必要配置,项目可启动,接口调用次数同步数据库任务会受影响)

### 必要配置

1. 配置文件中, 修改application-dev.yml文件  目前从库数据源未用到,但需配置,配置于主库数据源相同即可

   ```yml
   spring:
     datasource:
       druid:
         # 主库数据源
         master:
           type: com.alibaba.druid.pool.DruidDataSource
           driverClassName: com.mysql.cj.jdbc.Driver
           url: #修改为自己的数据库的链接
           username: #修改为自己的数据库的用户名
           password: #修改为自己的数据库的密码
         # 从库数据源
         slave:
           type: com.alibaba.druid.pool.DruidDataSource
           driverClassName: com.mysql.cj.jdbc.Driver
           url: #修改为自己的数据库的链接
           username: #修改为自己的数据库的用户名
           password: #修改为自己的数据库的密码
     #集成redis
     redis:
       host: #修改为自己的redis地址
       port: #修改为自己的redis端口
       database: 0
       password:
       lettuce:
         pool:
           max-active: 8
           max-wait: -1
           max-idle: 8
           min-idle: 0
       connect-timeout: 30000
   
   #阿里云oss(非必要配置)
   aliyun:
     endpoint: #(示例: https://oss-cn-hangzhou.aliyuncs.com)
     accessKeyId:  # 填写自己的key
     accessKeySecret:  #填写自己的Secret
     bucketName: # 填写自己的bucketName
     bucketDirName: # 填写自己的bucketDirName(即bucket中文件夹的路径      
   ```

### 运行步骤

1. 拉取后端代码: https://github.com/wudskq/wc-manager-system.git

2. 此项目为maven构建,打开idea等待自动导入需要的jar包

3. 运行项目即可,如下图即为启动成功!

   ![image-20220729140510930](https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wudskq/data/20220729140516.png)

### 部署步骤

1. 使用maven进行打包

   ```bash
   $ mvn clean
   $ mvn package
   ```

   
