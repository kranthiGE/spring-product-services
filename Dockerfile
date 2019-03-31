FROM openjdk:8-jdk-alpine
MAINTAINER kranthikirana

FROM maven:3.5-jdk-8-alpine
WORKDIR apps/spring-product-services/

ADD pom.xml pom.xml
ADD src src
RUN ["mvn", "clean", "package"]

ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "target/spring-product-services-0.0.1-SNAPSHOT.jar"]
EXPOSE 8888