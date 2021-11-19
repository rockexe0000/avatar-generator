FROM maven:3.6-alpine AS deps

# avatar-generator
# avatar-generator-8bit
# avatar-generator-cat
# avatar-generator-smiley
# sample
# rest-api

WORKDIR /opt/app
# COPY avatar-generator/pom.xml avatar-generator/pom.xml
# COPY avatar-generator-8bit/pom.xml avatar-generator-8bit/pom.xml
# COPY avatar-generator-cat/pom.xml avatar-generator-cat/pom.xml
# COPY avatar-generator-smiley/pom.xml avatar-generator-smiley/pom.xml
# COPY sample/pom.xml sample/pom.xml
# COPY rest-api/pom.xml rest-api/pom.xml
# 
# COPY pom.xml .
# 
# RUN mvn -B -e -C dependency:go-offline

COPY . .
RUN mvn package
# RUN mvn clean install -DskipTests=true




# FROM maven:3.6-alpine AS builder
# 
# WORKDIR /opt/app
# COPY --from=deps /root/.m2 /root/.m2
# COPY --from=deps /opt/app/ /opt/app
# 
# COPY avatar-generator/src avatar-generator/src
# COPY avatar-generator-8bit/src avatar-generator-8bit/src
# COPY avatar-generator-cat/src avatar-generator-cat/src
# COPY avatar-generator-smiley/src avatar-generator-smiley/src
# COPY sample/src sample/src
# COPY rest-api/src rest-api/src
# 
# RUN mvn -B -e -o clean install -DskipTests=true




# app
FROM openjdk:8-jre-alpine

# WORKDIR /app
COPY --from=deps /opt/app/rest-api/target/rest-api-0.0.1.jar /app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]




