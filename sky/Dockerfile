FROM openjdk:11-jdk-slim
COPY target/sky.jar /opt/sky.jar
ENTRYPOINT ["java",  "-Djava.net.preferIPv4Stack=true",  "-jar","/opt/sky.jar"]
EXPOSE 2025
