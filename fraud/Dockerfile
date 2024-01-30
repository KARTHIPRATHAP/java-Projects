
FROM openjdk:18

VOLUME /fraud


MAINTAINER hari

ADD target/*.jar fraud.jar

EXPOSE 8081


ENTRYPOINT ["java", "-jar", "/fraud.jar"]