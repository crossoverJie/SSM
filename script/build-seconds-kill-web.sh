#!/bin/bash

# 构建 web 消费者

read appname

echo "input="$appname


PID=$(ps -ef | grep $appname | grep -v grep | awk '{print $2}')

if [ $? -eq 0 ]; then
    echo "process id:$PID"
else
    echo "process $appname not exit"
    exit
fi

echo "pid = $PID"
kill -9 ${PID}

if [ $? -eq 0 ];then
    echo "kill $appname success"
else
    echo "kill $appname fail"
    exit
fi

cd ..

git pull

cd SSM-SECONDS-KILL

mvn -Dmaven.test.skip=true clean package

echo "build war success"

cp /home/crossoverJie/SSM/SSM-SECONDS-KILL/SSM-SECONDS-KILL-WEB/target/SSM-SECONDS-KILL-WEB-2.2.0-SNAPSHOT.war /home/crossoverJie/tomcat/tomcat-dubbo-consumer-8083/webapps

echo "cp war ok!"





sh /home/crossoverJie/tomcat/tomcat-dubbo-consumer-8083/bin/startup.sh

echo "start $appname success"