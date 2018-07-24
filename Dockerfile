FROM openjdk
ADD target/application.jar application.jar
ENTRYPOINT ["java", "-jar", "./application.jar"]
LABEL maintainer="janitha.madushan@cambio.se"
EXPOSE 8080