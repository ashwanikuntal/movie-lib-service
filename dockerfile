FROM java:8-jdk-alpine
COPY ./target/movie-lib-service-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch movie-lib-service-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=default", "movie-lib-service-0.0.1-SNAPSHOT.jar"]