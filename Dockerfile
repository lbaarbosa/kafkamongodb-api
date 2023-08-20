FROM openjdk:17

COPY ./target/kafkamongodb-api-0.0.1-SNAPSHOT.jar /dockerImage/my-app.jar

ENTRYPOINT ["java", "-jar", "/target/kafkamongodb-api-0.0.1-SNAPSHOT.jar"]

