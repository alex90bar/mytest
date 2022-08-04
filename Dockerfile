FROM adoptopenjdk:11-jre-hotspot
ADD target/mytest-0.0.1-SNAPSHOT.jar my-test.jar
ENTRYPOINT ["java", "-jar", "my-test.jar"]