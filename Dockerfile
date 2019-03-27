FROM openjdk:8-jdk-alpine
MAINTAINER kranthikirana
VOLUME /apps
WORKDIR /apps
RUN git clone https://github.com/kranthiGE/spring-services-sample.git

FROM maven:3.5-jdk-8-alpine
WORKDIR /apps/spring-services-sample
RUN mvn install

COPY /target/spring-product-services-0.0.1-SNAPSHOT.jar /opt/services/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/services/spring-product-services-0.0.1-SNAPSHOT.jar"]
EXPOSE 8888