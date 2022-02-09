FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/MyDrugs-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]