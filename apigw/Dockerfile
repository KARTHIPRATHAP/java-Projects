
FROM openjdk:18

VOLUME /apigw


MAINTAINER hari

ADD target/*.jar apigw.jar

EXPOSE 8083


ENTRYPOINT ["java", "-jar", "/apigw.jar"]