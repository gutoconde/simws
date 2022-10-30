FROM maven:3.6.3 AS maven
LABEL MAINTAINER="gutoconde@gmail.com"

WORKDIR /usr/src/app
COPY . /usr/src/app
# Compile and package the application to an executable JAR
RUN mvn package 

#FROM openjdk:8-alpine
FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /opt/app
COPY --from=maven /usr/src/app/target/*.jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]


