FROM eclipse-temurin:17-jdk     
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY mvnw .
COPY .mvn .mvn

RUN chmod 777 mvnw
RUN ./mvnw package 
CMD ["java", "-jar", "target/projeto_java_com_bd-0.0.1-SNAPSHOT.jar"]