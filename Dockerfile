# Dockerfile

# Etapa de construcción
FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

# Copia archivos de configuración de Spring
COPY pom.xml ./

# Instalar dependencias
RUN mvn dependency:go-offline -B

# Copiar el código de la aplicación y construirla
COPY . .
RUN mvn clean package -DskipTests

# Etapa de producción (Nginx)
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copiar los archivos compilados desde la etapa de construcción a la carpeta de Nginx
COPY --from=build /app/target/gpds-autos-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto de Nginx
EXPOSE 8080

# Comando de inicio de Nginx
ENTRYPOINT ["java","-jar", "app.jar"]