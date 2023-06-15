# Step 1 : Build stage
FROM maven:3.6.3-openjdk-17 as build

WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code and build
COPY src/ ./src/
RUN mvn clean package

# Step 2 : Package stage
FROM openjdk:17-jdk-slim

# Copy built jar file from build stage
COPY --from=build /app/target/TicketMaster-0.0.1-SNAPSHOT.jar /app.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]
