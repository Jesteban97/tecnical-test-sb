# Usa una imagen base de Java 17 en Alpine
FROM openjdk:17-jdk-alpine
COPY target/tecnicaltest-0.0.1-SNAPSHOT.jar java-app.jar
ENTRYPOINT ["java", "-jar", "java-app.jar"]
