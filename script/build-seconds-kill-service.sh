#!/bin/bash

# 构建服务提供者

read appname

echo "input="$appname


PID=$(ps -ef | grep $appname | grep -v grep | awk '{print $2}')

#if [ $? -eq 0 ]; then
#    echo "process id:$PID"
#else
#    echo "process $appname not exit"
#    exit
#fi

for var in ${PID[@]};
do
    echo "loop pid= $var"
    kill -9 $var
done

echo "kill $appname success"


cd ..

git pull

cd SSM-SECONDS-KILL

mvn -Dmaven.test.skip=true clean package

echo "build war success"

cp /home/crossoverJie/SSM/SSM-SECONDS-KILL/SSM-SECONDS-KILL-SERVICE/target/SSM-SECONDS-KILL-SERVICE-2.2.0-SNAPSHOT.war /home/crossoverJie/tomcat/tomcat-dubbo-provider-8080/webapps

echo "cp war ok!"





sh /home/crossoverJie/tomcat/tomcat-dubbo-provider-8080/bin/startup.sh

echo "start $appname success"