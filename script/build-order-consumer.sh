#!/bin/bash

# 构建 kafka 消费

cd ..

git pull

cd SSM-SECONDS-KILL/SSM-SECONDS-KILL-ORDER-CONSUMER

mvn -Dmaven.test.skip=true clean package

echo "build SSM-SECONDS-KILL-ORDER-CONSUMER jar success"


cp /home/crossoverJie/SSM/SSM-SECONDS-KILL/SSM-SECONDS-KILL-ORDER-CONSUMER/target/order-consumer-0.0.1-SNAPSHOT.jar /home/crossoverJie/order-consumer
echo "cp SSM-SECONDS-KILL-ORDER-CONSUMER jar success"





sh /home/crossoverJie/order-consumer/startup.sh
echo "/home/crossoverJie/order-consumer/startup.sh success"
