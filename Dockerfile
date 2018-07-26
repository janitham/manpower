FROM openjdk
LABEL maintainer="janithasen@gmail.com"
ADD target/application.jar application.jar
ENTRYPOINT ["java", "-jar", "./application.jar"]