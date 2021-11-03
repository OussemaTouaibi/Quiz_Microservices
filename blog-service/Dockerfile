FROM java:8
EXPOSE 9003
ADD /target/blog-service-0.0.1-SNAPSHOT.jar blog-service.jar
ENTRYPOINT ["java", "-jar", "blog-service.jar"]