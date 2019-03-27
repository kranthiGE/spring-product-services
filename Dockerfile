FROM openjdk:8-jdk-alpine
MAINTAINER kranthikirana
VOLUME /tmp

FROM maven:3.5-jdk-8-alpine
WORKDIR /tmp
COPY --from=0 /app/spring-services-sample /tmp
RUN mvn install

COPY /target/spring-product-services-0.0.1-SNAPSHOT.jar /opt/services/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/services/lib/spring-product-services-0.0.1-SNAPSHOT.jar"]
EXPOSE 8888