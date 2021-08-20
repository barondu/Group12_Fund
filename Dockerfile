FROM openjdk:11.0

ADD target/fund-0.0.1-SNAPSHOT.jar app.jar
# Don't forget the EXPOSE instruction.
EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
