# Aplicación de microservicios para un restaurante
Autor: Julián Alejandro Mora Londoño

Tipo: Aplicación de JAVA con Spring Boot 

# Pasos para el despliegue de la aplicación en ambiente local

## 1- Configuración base de datos postgresql
Crear base de datos usando el motor de base de datos postgresql

## Datos para la creación de la base de datos
NOMBRE BD: restaurante

PUERTO BD: 5432 (Puerto por defecto)

USUARIO BD: postgres

CONTRASEÑA BD: root

## 2- Ejecutar script de migración sql en la base de datos creada
El script sql se encuentra en la siguiente ruta del proyecto: "scripts/script-db-restaurante.sql"

## 3- Compilar proyecto con maven desde la consola de comandos
Pararse en la raíz del proyecto y ejecutar el siguiente comando en consola:

mvn clean install -DskipTests

## 4- Ejecutar la aplicación desde la consola de comandos
1- Navegar a la raíz del proyecto

2- Ejecutar el siguiente comando en la consola:

java -Duser.timezone=GMT -jar target/demo-0.0.1-SNAPSHOT.war

## 5- Realizar pruebas de los microservicios con swagger
Una vez ejecutándose la aplicación, puede navegar a
http://127.0.0.1:8080/swagger-ui.html para realizar pruebas de los microservicios con swagger.

IMPORTANTE: Asegúrese de restaurar el script sql mencionado anteriormente, si es necesario ejecútelo nuevamente.





