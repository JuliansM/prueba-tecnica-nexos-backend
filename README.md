# Aplicación de microservicios para un restaurante
Autor: Julián Alejandro Mora Londoño

Tipo: Aplicación de JAVA con Spring Boot 

# Pasos para el despliegue de la aplicación en ambiente local

## Configuración base de datos postgresql
1- Crear base de datos usando el motor de base de datos postgresql

## Datos de configuración
NOMBRE BD: restaurante

PUERTO BD: 5432 (Puerto por defecto)

USUARIO BD: postgres

CONTRASEÑA BD: root

## Ejecutar script de migración sql en la base de datos creada
El script sql se encuentra en la siguiente ruta del proyecto: "scripts/script-db-restaurante.sql"

## Compilar proyecto
Pararse en la raíz del proyecto y ejecutar el siguiente comando en consola:

mvn clean install -DskipTests

## Ejecutar la aplicación desde la consola
Navegar a la siguiente ruta del proyecto: ./target/

Ejecutar el siguiente comando en la consola:

java -Duser.timezone=GMT -jar demo-0.0.1-SNAPSHOT.jar

## Pruebas con swagger
Una vez ejecutándose la aplicación, puede navegar a
http://127.0.0.1:8080/swagger-ui.html para realizar pruebas de los microservicios con swagger.





