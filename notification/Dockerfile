
FROM openjdk:18

VOLUME /notification


MAINTAINER hari

ADD target/*.jar notification.jar

EXPOSE 8082


ENTRYPOINT ["java", "-jar", "/notification.jar"]