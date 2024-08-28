FROM openjdk:17-jdk-slim
RUN mkdir app
ADD /target/interview-0.0.1-SNAPSHOT.jar /app/interview-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT java -jar interview-0.0.1-SNAPSHOT.jar