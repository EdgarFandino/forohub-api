ForoHub API - Challenge Alura ORACLE ONE
📌 Descripción

ForoHub es una API REST desarrollada con Spring Boot que permite gestionar tópicos de un foro.
La aplicación permite crear, listar, actualizar y eliminar tópicos, además de implementar autenticación mediante JWT.

Este proyecto fue desarrollado como parte del Challenge Back-End del programa ONE (Oracle Next Education) - Alura Latam.

🚀 Tecnologías utilizadas

Java 21

Spring Boot

Spring Security

JWT (JSON Web Token)

Spring Data JPA

MySQL

Maven

Hibernate

Jakarta Validation

📂 Estructura del proyecto
com.challenge.forohub
│
├── controller
│   └── TopicoController
│
├── service
│   └── TopicoService
│
├── repository
│   └── TopicoRepository
│
├── domain
│   └── topico
│        ├── Topico
│        └── StatusTopico
│
├── dto
│   ├── DatosRegistroTopico
│   ├── DatosListadoTopico
│   └── DatosActualizarTopico
│
├── security
│   ├── JWTUtil
│   └── JWTAuthenticationFilter
│
├── infra
│   └── errores
│        └── TratadorDeErrores
│
└── ForohubApplication
⚙️ Configuración de la base de datos

Crear base de datos en MySQL:

CREATE DATABASE forohub;

Configurar en application.properties:

spring.datasource.url=jdbc:mysql://localhost/forohub
spring.datasource.username=root
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
🔐 Autenticación

La API utiliza JWT para autenticación.

Endpoint para obtener token:

POST /login

Ejemplo:

{
 "login":"admin",
 "password":"123456"
}

Respuesta:

{
 "token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}

El token debe enviarse en las solicitudes protegidas:

Authorization: Bearer TOKEN
📌 Endpoints principales
Crear tópico
POST /topicos

Body:

{
 "titulo":"Error API",
 "mensaje":"No puedo conectar",
 "autor":"Edgar",
 "curso":"Spring Boot"
}
Listar tópicos
GET /topicos

Con paginación:

GET /topicos?page=0&size=10
Actualizar tópico
PUT /topicos

Body:

{
 "id":1,
 "titulo":"Error API corregido",
 "mensaje":"Problema solucionado"
}
Eliminar tópico
DELETE /topicos/{id}
📊 Funcionalidades implementadas

Registro de tópicos

Listado de tópicos con paginación

Actualización de tópicos

Eliminación de tópicos

Validación de datos

Prevención de tópicos duplicados

Autenticación con JWT

Manejo global de errores

👨‍💻 Autor

Edgar Fandiño
Challenge Back-End - Alura Latam / Oracle Next Education
