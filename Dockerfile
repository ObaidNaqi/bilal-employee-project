FROM openjdk:8
COPY target/employeeapp-0.0.1-SNAPSHOT.jar /app/app.jar
CMD [ "java", "-jar", "/app/app.jar" , "mysqldb"]
