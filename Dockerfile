FROM adoptopenjdk/openjdk9-openj9:latest

WORKDIR /app

COPY target/bip-user-0.0.1-SNAPSHOT.jar /app/bip-user.jar

ENTRYPOINT ["java","-jar","bip-user.jar"]


#FROM openjdk:10-jre-slim
#COPY ./target/hola-docker-1.0.0-SNAPSHOT.jar /usr/src/hola/
#WORKDIR /usr/src/hola
#EXPOSE 8080
#CMD ["java", "-jar", "hola-docker-1.0.0-SNAPSHOT.jar"]