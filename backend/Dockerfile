FROM java:8u111-jdk-alpine
VOLUME /tmp
EXPOSE 8080
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]