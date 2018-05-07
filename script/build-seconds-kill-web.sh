#!/bin/bash

# 构建 web 消费者

#read appname

appname="consumer"
echo "input="$appname


PID=$(ps -ef | grep $appname | grep -v grep | awk '{print $2}')


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

cp /home/crossoverJie/SSM/SSM-SECONDS-KILL/SSM-SECONDS-KILL-WEB/target/SSM-SECONDS-KILL-WEB-2.2.0-SNAPSHOT.war /home/crossoverJie/tomcat/tomcat-dubbo-consumer-8083/webapps
echo "cp tomcat-dubbo-consumer-8083/webapps ok!"

cp /home/crossoverJie/SSM/SSM-SECONDS-KILL/SSM-SECONDS-KILL-WEB/target/SSM-SECONDS-KILL-WEB-2.2.0-SNAPSHOT.war /home/crossoverJie/tomcat/tomcat-dubbo-consumer-7083-slave/webapps
echo "cp tomcat-dubbo-consumer-7083-slave/webapps ok!"





sh /home/crossoverJie/tomcat/tomcat-dubbo-consumer-8083/bin/startup.sh
echo "tomcat-dubbo-consumer-8083/bin/startup.sh success"

sh /home/crossoverJie/tomcat/tomcat-dubbo-consumer-7083-slave/bin/startup.sh
echo "tomcat-dubbo-consumer-7083-slave/bin/startup.sh success"

echo "start $appname success"