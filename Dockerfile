FROM openjdk:20-jdk

WORKDIR /app

COPY . .

CMD ["java", "-jar", "build/libs/slots-backend-0.0.1-SNAPSHOT.jar"]