# Etapa de build
FROM maven:3.8.5-openjdk-17-slim AS build

WORKDIR /app

# Copia os arquivos do projeto para o container
COPY . .

# Compila e empacota a aplicação
RUN mvn clean package -DskipTests

# Etapa de runtime
FROM eclipse-temurin:17-jre-jammy

# Cria um usuário não-root
RUN useradd -m appuser

WORKDIR /home/appuser

# Copia o .jar gerado na etapa de build
COPY --from=build /app/target/sprint1_java2025-0.0.1-SNAPSHOT.jar app.jar

# Define o usuário não-root
USER appuser

# Exponha a porta que sua aplicação utiliza (ajuste conforme necessário)
EXPOSE 8080

# Comando para executar a aplicação
CMD ["java", "-jar", "app.jar"]