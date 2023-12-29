FROM openjdk:17-alpine
WORKDIR /app
COPY target/remd_annonces.jar /app
CMD ["java","-jar","remd_annonces.jar"]