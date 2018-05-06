#!/usr/bin/env bash

kill -9 `cat ${jar_path}/application.pid`

nohup java -jar bigdata-1.0.0-SNAPSHOT.jar -Xmx128m -Xms128m --logging.config=/data/schedule/kafka/bigdata/config/logback.xml --logging.file=/dev/null  > /dev/null 2>&1 &