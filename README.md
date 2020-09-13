# prueba-tecnica-nexos-backend

## Pasos para el despliegue de la aplicación en ambiente local

# Configuración base de datos postgresql
1- Crear base de datos

# Datos de configuración
NOMBRE BD: restaurante

PUERTO BD: 5432 (Puerto por defecto)

USUARIO BD: postgres

CONTRASEÑA BD: root

# Compilar proyecto
Pararse en la raíz del proyecto y ejecutar el siguiente comando en consola:

mvn clean install -DskipTests

# Ejecutar la aplicación desde la consola
Navegar a la siguiente ruta del proyecto: ./target/

Ejecutar el siguiente comando en la consola:

java -Duser.timezone=GMT -jar demo-0.0.1-SNAPSHOT.jar





