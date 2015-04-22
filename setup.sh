#Maven install
cd ..
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
cd MultidbsVisServerAPI/target
nohup java -jar multidbsvisserverapi-0.1-SNAPSHOT.jar /opt/project/MultiDBs-Vis-Server/MultiDBsVisServerAPI/src/main/resources/config.properties > log.out 2> error.log < /dev/null &


#Test if it is running
lsof -i:7654