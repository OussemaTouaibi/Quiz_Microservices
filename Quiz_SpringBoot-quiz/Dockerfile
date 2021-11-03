FROM java:8
EXPOSE 9001
ADD /target/quiz-service-0.0.1-SNAPSHOT.jar docker-quiz-service.jar
ENTRYPOINT ["java", "-jar", "docker-quiz-service.jar"]