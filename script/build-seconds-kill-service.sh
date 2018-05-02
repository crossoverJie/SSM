#!/bin/bash

# 构建服务提供者

#read appname

appname="provider"

echo "input="$appname


PID=$(ps -ef | grep $appname | grep -v grep | awk '{print $2}')

#if [ $? -eq 0 ]; then
#    echo "process id:$PID"
#else
#    echo "process $appname not exit"
#    exit
#fi

# 遍历杀掉 pid
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

echo "cp tomcat-dubbo-provider-8080/webapps ok!"

cp /home/crossoverJie/SSM/SSM-SECONDS-KILL/SSM-SECONDS-KILL-SERVICE/target/SSM-SECONDS-KILL-SERVICE-2.2.0-SNAPSHOT.war /home/crossoverJie/tomcat/tomcat-dubbo-provider-7080-slave/webapps

echo "cp tomcat-dubbo-provider-7080-slave/webapps ok!"



sh /home/crossoverJie/tomcat/tomcat-dubbo-provider-8080/bin/startup.sh
echo "tomcat-dubbo-provider-8080/bin/startup.sh success"

sh /home/crossoverJie/tomcat/tomcat-dubbo-provider-7080-slave/bin/startup.sh
echo "tomcat-dubbo-provider-8080/bin/startup.sh success"

echo "start $appname success"