package cn.com.wudskq.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@TableName("t_sys_user")
public class TSysUser implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    @TableId
    //主键
    private String id;
    //用户名
    private String username;
    //密码
    private String password;
    //昵称
    private String nickName;
    //电话
    private String cellPhone;
    //邮件
    private String mail;
    //生日
    private Date birthday;
    //状态（0-正常，1-禁用，2-删除）
    private String status;
    //1系统账号 2客户账号
    private String accountType;
    //邀请码
    private String inviteCode;
    //性别：0男 1女
    private String sex;
    //地址
    private String address;
    //获赞总量
    private Integer upNum;
    //文章被阅读总量
    private Integer readNum;
    //签名
    private String sign;
    //用户头像
    private String pictureId;
    //创建人
    private String createUser;
    //创建时间
    private Date createDate;
}

