#Establece la imagen base
FROM openjdk:8-jdk-alpine

#Expone el puerto donde va a atender el contenedor
EXPOSE 8000

#Establece una variable para el momento de construir la imagen (la ruta del jar)
ARG JAR_FILE

#Copia el jar dentro del contenedor
ADD ${JAR_FILE} app.jar

#Establece el comando a ejecutarse apenas el container este iniciado.
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]