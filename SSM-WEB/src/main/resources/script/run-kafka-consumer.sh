#!/bin/sh

#crontab
# * * * * * sh /data/schedule/kafka/run-kafka-consumer.sh >>/data/schedule/kafka/run-sms-log.log

# 如果进程存在就不启动
a1=`ps -ef|grep 'KafkaMsgConsumer'|grep -v grep|wc -l`
if [ $a1 -gt 0  ];then
        echo "=======     `date +'%Y-%m-%d %H:%M:%S'` KafkaMsgConsumer  is EXIT...=======     "
        exit
fi
LANG="zh_CN.UTF-8"
nohup /opt/java/jdk1.7.0_80/bin/java -d64 -Djava.security.egd=file:/dev/./urandom
-Djava.ext.dirs=/opt/tomcat/webapps/ROOT/WEB-INF/lib
-Dtopic=TOPIC_A
-Dlogback.configurationFile=/data/schedule/kafka/logback.xml
-DkafkaConfig=/opt/tomcat/iopconf/easyframe-msg.properties
-classpath /opt/tomcat/webapps/ROOT/WEB-INF/classes com.crossoverJie.kafka.SMSMsgConsumer >> /data/schedule/kafka/smslog/kafka.log 2>&1 &

echo "`date +'%Y-%m-%d %H:%M:%S'`  KafkaMsgConsumer running...."