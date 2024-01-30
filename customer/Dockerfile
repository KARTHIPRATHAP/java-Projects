
FROM openjdk:18

VOLUME /customer


MAINTAINER hari

ADD target/*.jar customer.jar

EXPOSE 8080


ENTRYPOINT ["java", "-jar", "/customer.jar"]