#FROM eclipse-temurin:17.0.4.1_1-jdk
FROM eclipse-temurin:11
WORKDIR /opt/app
COPY ./target/*.jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]


