#!/usr/bin/env bash

nohup java -jar bigdata-1.0.0-SNAPSHOT.jar --logging.config=/data/schedule/kafka/bigdata/config/logback.xml --logging.file=/dev/null  > /dev/null 2>&1 &