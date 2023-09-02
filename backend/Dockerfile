FROM java:8u111-jdk-alpine
LABEL authors="vijayps"
VOLUME /tmp
EXPOSE 9201
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]