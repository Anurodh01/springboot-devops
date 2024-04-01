FROM openjdk:17
EXPOSE 8060
ADD target/springboot-devops.jar springboot-devops.jar
ENTRYPOINT ["java","-jar","/springboot-devops.jar"]