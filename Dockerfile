# ===== Etapa 1: Build =====
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copia os arquivos do projeto
COPY . .

# Faz o build do Quarkus (gera o diretório target/quarkus-app)
RUN mvn clean package -DskipTests

# ===== Etapa 2: Execução =====
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copia tudo que foi gerado pelo Quarkus
COPY --from=build /app/target/quarkus-app/lib/ /app/lib/
COPY --from=build /app/target/quarkus-app/*.jar /app/
COPY --from=build /app/target/quarkus-app/app/ /app/app/
COPY --from=build /app/target/quarkus-app/quarkus/ /app/quarkus/

# Porta padrão
EXPOSE 8080

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "/app/quarkus-run.jar"]
