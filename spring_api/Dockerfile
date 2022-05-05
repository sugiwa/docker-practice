# FROM openjdk:15-jdk-alpine
# ARG JAR_FILE=./target/*.jar
# COPY ${JAR_FILE} app.jar
# ENTRYPOINT java -jar /app.jar


FROM maven:3.6.2-jdk-13 as builder

WORKDIR /usr/src/
# pom.xmlだけCOPYし、先に依存解決
COPY ./pom.xml /usr/src/
RUN mvn -B dependency:resolve dependency:resolve-plugins

# ビルドで必要となるファイルのみCOPY
COPY ./src/ /usr/src/src/
RUN mvn -B package

FROM openjdk:15-alpine

COPY --from=builder /usr/src/target/spring_api.jar /

ENTRYPOINT []
CMD java -jar /spring_api.jar