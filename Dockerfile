FROM eclipse-temurin:11
WORKDIR /opt/app
COPY ./target/*.jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]


