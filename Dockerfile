FROM openjdk:8-jdk-alpine
MAINTAINER kranthikirana
VOLUME /apps

FROM maven:3.5-jdk-8-alpine
WORKDIR /opt/services/apps/spring-services-sample/

ADD pom.xml pom.xml
ADD src src
RUN ["mvn", "package"]

ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/services/apps/spring-product-services/target/spring-product-services-0.0.1-SNAPSHOT.jar"]
EXPOSE 8888