# ---------- BUILD STAGE ----------
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

COPY src ./src
RUN mvn -q -DskipTests package

# ---------- RUNTIME STAGE ----------
FROM eclipse-temurin:17-jre
WORKDIR /opt/app
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"
ENV SPRING_PROFILES_ACTIVE=docker
EXPOSE 9092
COPY --from=build /app/target/*-SNAPSHOT.jar /opt/app/app.jar
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /opt/app/app.jar"]
