#!/bin/bash

read input1

echo "input="$input1

git pull

cd SSM-SECONDS-KILL

mvn -Dmaven.test.skip=true clean package

echo "build war success"

cp /home/crossoverJie/SSM/SSM-SECONDS-KILL/SSM-SECONDS-KILL-SERVICE/target/SSM-SECONDS-KILL-SERVICE-2.2.0-SNAPSHOT.war /home/crossoverJie/tomcat/tomcat-dubbo-provider-8080/webapps

echo "cp war ok!"



PID=$(ps -e|grep $input1|awk '{printf $1}')

if [ $? -eq 0 ]; then
    echo "process id:$PID"
else
    echo "process $input1 not exit"
    exit
fi


kill -9 ${PID}

if [ $? -eq 0 ];then
    echo "kill $input1 success"
else
    echo "kill $input1 fail"
fi

sh /home/crossoverJie/tomcat/tomcat-dubbo-provider-8080/bin/startup.sh

echo "start $input1 success"