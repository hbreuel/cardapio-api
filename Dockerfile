FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-22-jdk -y
COPY src .

RUN apt-get install maven -y

RUN mvn clean install

FROM openjdk:22-jdk

EXPOSE 8080

COPY --from=build /target/cardapio-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar" ]