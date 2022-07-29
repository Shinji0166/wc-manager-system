## 项目部署手册

### [前端部署手册](https://github.com/wudskq/wc-manager-ui.git)

<p align="center">
   <img src="https://img.shields.io/badge/Vue-2.2-green" alt="Build Status">
   <img src="https://img.shields.io/badge/ECharts-5.3.3-yellowgreen" alt="Build Status">
   <img src="https://img.shields.io/badge/Element%20UI-2.15.8-orange" alt="Build Status">
   <img src="https://img.shields.io/badge/Axios-3.4.1-blue" alt="Build Status">
</p>

#### 前置条件

1. node环境
2. yarn环境
3. nginx环境(部署时使用、运行环境下不需要)

#### 运行步骤(对应后端运行环境)

1. 拉取前端代码 https://github.com/wudskq/wc-manager-ui.git

2. 在项目当前目录打开命令行、执行以下命令即可

   ```bash
   # 安装依赖环境
   $ yarn install
   
   #启动项目
   $ yarn run dev
   ```

3. 注意此处端口需要改为后端服务端口号(默认不需要改)

   ![image-20220729160902298](https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wudskq/data/20220729160902.png)

#### 部署步骤(对应后端部署环境)

1. 使用以下命令进行项目打包

   ```bash
   # 进行项目打包
   $ yarn build
   ```

   ![image-20220729161447958](https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wudskq/data/20220729161448.png)

2. 打包成功后、在本地新建文件夹systemui、将dist目录中的所有文件拷贝到systemui文件夹中

3. 将systemui上传至服务器nginx中的html目录下、如下图

   ![image-20220729163128428](/Users/wudskq/Library/Application Support/typora-user-images/image-20220729163128428.png)

4. 修改nginx配置文件、配置前端项目地址及后端服务信息 

   ```bash
   #user  nobody;
   worker_processes  1;
   
   #error_log  logs/error.log;
   #error_log  logs/error.log  notice;
   #error_log  logs/error.log  info;
   
   #pid        logs/nginx.pid;
   
   events {
       worker_connections  1024;
   }
   
   
   http {
       include       mime.types;
       default_type  application/octet-stream;
   
       sendfile        on;
       keepalive_timeout  65;
   
       gzip  on;
       
       #reverse proxy 此处配置后端服务地址
       upstream server {
           server localhost:8099;
       }
   
       server {
           listen       80;
           server_name  localhost;
           
           # 修改为前端项目路径
           location / {
               root   html/systemui;
               index  index.html index.htm;
               try_files $uri $uri/ /index.html; 
           }
   
           # 所有与后端交互的url都携带api作为标志，因此可以监听api
           location /api {
               # 重写url，通过正则取url当中的/api/之后的部分与proxy_pass组成新的url
               rewrite             ^/api/(.*)$ /$1 break;
               # proxy_pass 用于配置访问这个location时所用代理
               proxy_pass          http://server; # proxy name of a group of upstream servers
               # proxy_pass          http://localhost:9090$request_uri;  =>有问题
               proxy_redirect      off;
               proxy_set_header Host               $host;
               proxy_set_header X-Real-Ip          $remote_addr;
               proxy_set_header X-Forwarded-For    $proxy_add_x_forwarded_for;
           }
       }
   }
   ```

5. 启动nginx即可

   ```bash
   $ ./nginx
   ```

6. 通过服务器的IP加端口号即可访问！ 

   - 系统管理员  用户名:admin 密码:123456
   - 普通测试用户 用户名:test-user 密码:123456

   ![image-20220729175229749](https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wudskq/data/20220729175230.png)

   ![](https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wudskq/data/20220729175412.png)

   ![image-20220729175436944](https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wudskq/data/20220729175436.png)

   ![image-20220729175459699](https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wudskq/data/20220729175459.png)

   ![image-20220729175555074](https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wudskq/data/20220729175555.png)

---

### 后端部署手册

<p align="center">
   <img src="https://img.shields.io/badge/JDK-1.8-green" alt="Build Status">
   <img src="https://img.shields.io/badge/SpringBoot-2.5.1-yellowgreen" alt="Build Status">
   <img src="https://img.shields.io/badge/Druid-1.2.8-orange" alt="Build Status">
   <img src="https://img.shields.io/badge/MyBatis-2.2.0-blue" alt="Build Status">
   <img src="https://img.shields.io/badge/MyBatis--Plus-3.4.2-red" alt="Build Status">
   <img src="https://img.shields.io/badge/Knife4j-3.0.3-orange" alt="Build Status">
   <img src="https://img.shields.io/badge/JJWT-0.9.0-yellowgreen" alt="Build Status">
   <img src="https://img.shields.io/badge/XXLJOB-2.3.0-blue" alt="Build Status">
   <img src="https://img.shields.io/badge/Redis-2.5.1-orange" alt="Build Status">
   <img src="https://img.shields.io/badge/阿里云OSS对象存储-blue" alt="Build Status">
</p>



#### 前置条件

1. JDK1.8
2. Maven
3. Redis
4. 阿里云OSS (非必要,配置为空项目也可启动,但上传文件相关接口不能使用)
4. XXL-JOB (非必要配置,项目可启动,接口调用次数同步数据库任务会受影响)

#### 必要配置

1. 配置文件中、修改application-dev.yml文件、目前从库数据源未用到、但仍需配置、配置与主库数据源相同即可

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

#### 定时任务XXL-JOB部署及配置(非必要、项目不会报错、但影响部分功能使用)

1. XXL-JOB部署请参考官网链接  https://www.xuxueli.com/xxl-job/

   ![image-20220729164441272](https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wudskq/data/20220729164441.png)

2. 对于该项目而言,此第三方定时任务框架用于更新项目中的接口调用数据进行入库

3. 作用二用户定时清理redis中的在线用户的垃圾数据

4. 安装完成后在application-dev.yml配置文件中将xxl-job的地址改为自己的xxl-job的地址、并在xxl-job中配置定时任务、对应

   JobHandler必须与项目中的对应的定时任务的的Value相同 ![image-20220729164926977](https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wudskq/data/20220729164927.png)

   ![image-20220729164654954](https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wudskq/data/20220729164655.png)

#### 数据库配置

1. 运行项目中的sql文件、进行初始化数据

   <img src="https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wudskq/data/20220729155828.png" alt="image-20220729155828569" style="zoom:67%;" />

#### 运行步骤(对应前端运行环境)

1. 拉取后端代码:  https://github.com/wudskq/wc-manager-system.git

2. 此项目为maven构建、打开idea等待自动导入需要的jar包

3. 运行项目即可、如下图即为启动成功 ！

   ![image-20220729140510930](https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wudskq/data/20220729140516.png)

#### 部署步骤(对应前端部署环境)

1. 这里请自定创建application-prod.yml配置文件、此操作为必须项！必须创建

1. 使用maven进行打包

   ```bash
   $ mvn clean
   $ mvn package
   ```

   ![image-20220729151927350](https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wudskq/data/20220729151927.png)

   <img src="https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wudskq/data/20220729152122.png" alt="image-20220729152122930" style="zoom: 67%;" />

   

2. 打包成功后上传wc-admin-1.0.0.jar与deploy.sh部署脚本到Linux服务器即可、注意需要jar与deploy在同一目录级别下

3. 使用脚本运行jar即可

   ```bash
   # 运行jar包,启动服务
   $ sh depoly.sh start
   
   # 查看应用状态
   $ sh deploy.sh status
   ```

   
