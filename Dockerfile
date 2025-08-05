# Usar uma imagem base com JDK 21
FROM eclipse-temurin:21-jdk-alpine

## Criar um volume para arquivos temporários
#VOLUME /tmp

# Copiar o JAR gerado pelo Maven para o contêiner
COPY target/chat-app-0.0.1-SNAPSHOT.jar app.jar

# Definir o comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "/app.jar"]