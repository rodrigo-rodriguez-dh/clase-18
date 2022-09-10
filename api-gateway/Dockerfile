FROM openjdk:8-jdk-alpine
RUN apk update && apk add bash
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY wait-for-it.sh .
ENTRYPOINT ["./wait-for-it.sh", "-t", "60","config-service:8888", "--", "java", "-jar", "app.jar"]