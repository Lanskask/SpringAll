FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

# ENV http_proxy "http://127.0.0.1:3001"
# ENV https_proxy "http://127.0.0.1:3001"