FROM openjdk:8
ADD target/userservice-0.0.1-SNAPSHOT.jar userservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "userservice-0.0.1-SNAPSHOT.jar"]