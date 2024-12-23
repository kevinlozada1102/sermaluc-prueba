# Proyecto Spring Boot

Este es un proyecto de Spring Boot que implementa la funcionalidad de registro y autenticación de usuarios con JWT (JSON Web Token). Permite la creación de un usuario y la obtención de su información a través de la API REST.

## Requisitos

Para ejecutar el proyecto, necesitas tener lo siguiente instalado:

- **Java 17 o superior** (JDK)
- **Maven** (para la gestión de dependencias y construcción del proyecto)

## Configuración y Ejecución

1. **Clona el repositorio**:

   Si aún no has clonado el repositorio, puedes hacerlo con el siguiente comando:

   ```bash
   git clone https://github.com/kevinlozada1102/sermaluc-prueba.git
   cd sermaluc-prueba

2. **Configura el archivo application.properties**:

   En el archivo src/main/resources/application.properties, configura los parámetros de la base de datos y la clave secreta para el JWT. Por ejemplo:

   ```bash
   # Configuración de la base de datos
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=password
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   spring.h2.console.enabled=true  # Activa la consola web de H2
   # Configuración del JWT
   jwt.secret.key=mi-clave-secreta
   jwt.time.expiration=3600000  # Tiempo de expiración en milisegundos (1 hora)

3. **Compilación y ejecución**:

   Ejecuta el siguiente comando

   ```bash
   mvn clean spring-boot:run
   
