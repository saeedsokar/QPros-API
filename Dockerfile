FROM maven:3.9.4-eclipse-temurin-20
COPY src /apitesting/Restassured/src
COPY pom.xml /apitesting/Restassured/pom.xml
WORKDIR /apitesting/Restassured
ENTRYPOINT mvn clean test