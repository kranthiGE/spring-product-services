FROM openjdk:8-jdk-alpine
MAINTAINER kranthikirana
VOLUME /tmp
COPY /target/spring-services-sample-0.0.1-SNAPSHOT.jar /opt/services/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/services/lib/spring-services-sample-0.0.1-SNAPSHOT.jar"]
EXPOSE 8888