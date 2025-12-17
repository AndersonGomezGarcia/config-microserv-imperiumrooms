FROM eclipse-temurin:17-jre


WORKDIR /app

# Copia el jar ya construido desde target/
COPY target/*.jar app.jar

# Puerto
EXPOSE 8080

# Variables de entorno mínimas (sin URLs hardcodeadas)
ENV JAVA_OPTS=""

# Crear usuario no root y cambiar a él (mejor práctica en producción)
RUN useradd -m appuser || true
USER appuser

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]
