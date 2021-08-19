FROM openjdk:11.0

ADD target/fund-spring-boot-webapp-0.0.2-SNAPSHOT.jar app.jar
# Don't forget the EXPOSE instruction.
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]
