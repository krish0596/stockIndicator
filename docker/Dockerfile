FROM container-registry.oracle.com/java/openjdk:21.0.2-oraclelinux8
WORKDIR /app
COPY build/libs/stockIndicator-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]