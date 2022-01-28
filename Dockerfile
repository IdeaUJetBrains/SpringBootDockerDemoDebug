FROM maven:3.5.4-jdk-8

COPY . /project
RUN  cd /project && mvn package

#run the spring boot application
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","/project/target/demo-0.0.1-SNAPSHOT.jar"]


