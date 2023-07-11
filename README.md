# Prueba Técnica Fuzzy Fish - Evaluación: JAVA2020.
### Autor: Matias Solana Mendez

### Tecnologías

- [JDK 11](https://www.oracle.com/ar/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3](https://maven.apache.org)
- [Git](https://git-scm.com)
- Spring Boot
- JPA
- Hibernate
- H2
- Maven
- Pruebas Unitarias con Junit

### Funcionalidades

1.  Buscar el precio de un producto a traves del endpoint GET /prices

2.  Formato en los mensajes de error: {"mensaje": "mensaje de error"}

3.  Pruebas unitarias con junit

#### Ejecución con maven y Java (Necesario maven y java 11 instalados)

- clonar el proyecto ```$ https://github.com/MattMendez/FuzzyFish-TestJava2020```
- Ir al directorio del proyecto
  ```$ cd ecommerce/ ```
- Generar jar del proyecto

```$ mvn clean && mvn install -DskipTests ```
- Correr proyecto con Maven ```$ mvn spring-boot:run  ```

## Documentacion
Para pruebas y documentacion recomiendo usar [Swagger](https://swagger.io) una vez que el proyecto este corriendo se puede acceder por el siguiente link:
[Swagger-UI](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/)

## Curl


``` 
curl --location --request GET 'http://localhost:8080/price' \
--header 'Content-Type: application/json' \
--data-raw '{
  "date": "2020-12-31T23:59:58",
  "productId": 35455,
  "brandId": 1
}'
```