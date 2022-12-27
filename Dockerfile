FROM maven:3.8.6 AS buildstage
WORKDIR  /app
COPY pom.xml /app
RUN mvn dependency:resolve
COPY . /app
RUN mvn clean
RUN mvn package -DskipTests

FROM openjdk:17-jdk-alpine
COPY --from=buildstage /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]