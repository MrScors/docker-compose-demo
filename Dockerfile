FROM openjdk:8
ADD target/DockerDemoApp.jar /DockerDemoApp.jar
ENTRYPOINT ["java", "-jar", "DockerDemoApp.jar"]

# Use for debugging
#ENTRYPOINT ["tail"]
#CMD ["-f","/dev/null"]