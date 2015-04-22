#Stop the server from running
kill -9 $(ps aux | grep java | grep multidbsvisserverapi-0.1-SNAPSHOT.jar | awk '{print $2}')