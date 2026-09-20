FROM maven:3.9-eclipse-temurin-25

WORKDIR /app

COPY src/Main.java ./src/main/java/Main.java

RUN printf '<project xmlns="http://maven.apache.org/POM/4.0.0"><modelVersion>4.0.0</modelVersion><groupId>app</groupId><artifactId>app</artifactId><version>1.0</version><properties><maven.compiler.source>25</maven.compiler.source><maven.compiler.target>25</maven.compiler.target></properties><dependencies><dependency><groupId>org.postgresql</groupId><artifactId>postgresql</artifactId><version>42.7.5</version></dependency></dependencies></project>' > pom.xml

RUN mvn package dependency:copy-dependencies -DoutputDirectory=lib -DskipTests

CMD ["java", "-cp", "target/classes:lib/*", "Main"]