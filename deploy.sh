#!/bin/bash

#如果系统中存在多个版本jdk，可以通过export指定
#export JAVA_HOME=/usr/java/jdk1.8.0_162
#export PATH=$JAVA_HOME/bin:$PATH
#export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar

# jar文件路径
APP_PATH=$(pwd)

# jar文件名称
APP_NAME=wc-admin-1.0.0.jar

# 日志文件路径
LOG_PATH=$(pwd)/log

#使用说明，用来提示输入参数
usage() {
        echo "使用说明: sh cg.sh [start|stop|restart|status]"
        exit 1
}

#检查程序是否在运行
is_exist(){
        # shellcheck disable=SC2006
        pid=`ps -ef|grep $APP_NAME|grep -v grep|awk '{print $2}'`
        #如果不存在返回1，存在返回0
        if [ -z "$pid" ]; then
                return 1
        else
                return 0
        fi
}

#启动方法
start(){
        echo $APP_NAME"-------应用正在启动中!-------"
        is_exist
        if [ $? -eq 0 ]; then
                echo "$APP_NAME is already running. pid=$pid"
        else
                nohup java -jar "$APP_PATH"/$APP_NAME >/dev/null &
		tail -f "$LOG_PATH"/log_all.log
        fi
}

#停止方法
stop(){
        echo $APP_NAME"-------应用已经停止!-------"
        is_exist
        if [ $? -eq "0" ]; then
                kill -9 $pid
        else
                echo "$APP_NAME is not running"
        fi
}

#输出运行状态
status(){
        echo $APP_NAME"---------应用当前状态-------"
        is_exist
        if [ $? -eq "0" ]; then
                echo "$APP_NAME is running. Pid is $pid"
        else
                echo "$APP_NAME is NOT running."
        fi
}

#重启
restart(){
        echo $APP_NAME"-------应用即将重新启动!-------"
        stop
        sleep 5
        start
}

#根据输入参数，选择执行对应方法，不输入则执行使用说明
case "$1" in
"start")
start
;;
"stop")
stop
;;
"status")
status
;;
"restart")
restart
;;
*)
usage
;;
esac



