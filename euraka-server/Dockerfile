
FROM openjdk:18

VOLUME /eureka


MAINTAINER hari

ADD target/*.jar eureka.jar

EXPOSE 8888


ENTRYPOINT ["java", "-jar", "/eureka.jar"]