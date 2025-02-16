FROM openjdk:8-jdk-alpine
COPY target/Mandelbrott-1.0.jar ./

CMD ["java", "-jar", "Mandelbrott-1.0.jar"]