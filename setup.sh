#!/bin/bash


#Start the server (Go to Multidbs-Vis-Server/MultidbsVisServerAPI/target)
nohup java -jar multidbsvisserverapi-0.1-SNAPSHOT.jar /opt/project/MultiDBs-Vis-Server/MultiDBsVisServerAPI/src/main/resources/config.properties > log.out 2> error.log < /dev/null &


#Test if it is running
lsof -i:7654