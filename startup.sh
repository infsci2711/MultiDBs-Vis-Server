#!/bin/bash


#Install essential
sudo apt-get install maven
sudo apt-get install git
sudo apt-get install openjdk-7-jdk
sudo apt-get install mysql-server
sudo apt-get install nginx


#Create folders
cd /opt
sudo mkdir project
cd project


#Clone projects from github
sudo git clone https://github.com/ColFusion/ColFusionDockerUtils.git
sudo git clone https://github.com/ColFusion/ColFusionUtils.git
sudo git clone https://github.com/infsci2711/MultiDBs-Utils.git
sudo git clone https://github.com/infsci2711/MultiDBs-Vis-Server.git
sudo git clone https://github.com/infsci2711/MultiDBs-Vis-WebClient.git


#Set the index page
cd /usr/share/nginx
sudo rm -R html
sudo ln -sv /opt/project/MultiDBs-Vis-WebClient html



#Set up your mysql
cd..
cd..
mysql -u root -proot
CREATE USER 'dataverse'@'%' IDENTIFIED BY 'dataverse';

GRANT ALL PRIVILEGES ON *.* TO 'dataverse'@'%' WITH GRANT OPTION;


CREATE DATABASE visualization;
use visualization;
../opt/project/MultiDBs-Vis-Server/visualization2.sql;
exit


#Maven install
cd ColFusionDockerUtils
mvn install
cd ..
cd ColFusionUtils
mvn install
cd ..
cd MultiDBs-Utils
mvn install
cd ..
cd MultiDBs-Vis-Server
mvn install


#Start the server (Go to Multidbs-Vis-Server/MultidbsVisServerAPI/target)
cd /opt/project/MultiDBs-Vis-Server/MultidbsVisServerAPI/target

nohup java -jar multidbsvisserverapi-0.1-SNAPSHOT.jar /opt/project/Multidbs-Vis-Server/MultidbsVisServerAPI/src/main/resources/config.properties > log.out 2> error.log < /dev/null &



#Test if it is running
lsof -i:7654