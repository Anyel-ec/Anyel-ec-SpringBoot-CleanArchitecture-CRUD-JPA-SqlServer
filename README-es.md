# Proyecto de Gestión de Clientes y Pedidos 🛒

## Descripción 📄

Este proyecto es una API RESTful construida en **Java** usando **Spring Boot** y sigue los principios de **Arquitectura Limpia**. La aplicación permite gestionar clientes y sus pedidos de forma modular y escalable, asegurando una separación clara entre la lógica de negocio, la infraestructura y la interacción con la base de datos.

## Estructura del Proyecto 📂

La estructura del proyecto está organizada siguiendo la Arquitectura Limpia. Esto garantiza que cada capa esté bien definida y desacoplada, permitiendo mayor flexibilidad y mantenimiento.

```
com.example.project
├── domain                   # Capa de Dominio (Reglas de Negocio)
│   ├── model                # Modelos de entidades principales (Cliente, Pedido)
│   └── repository           # Interfaces de los repositorios
├── application              # Capa de Aplicación (Casos de Uso)
│   └── usecase              # Lógica de casos de uso (ClienteService, PedidoService)
├── adapter                  # Adaptadores de Entrada y Salida
│   ├── input                # Adaptadores de Entrada (API REST)
│   └── output               # Adaptadores de Salida (Integración externa)
└── infrastructure           # Capa de Infraestructura
    ├── configuration        # Configuración de Spring y beans
    ├── controllers          # Controladores REST (ClienteController, PedidoController)
    ├── repositories         # Implementaciones de repositorios JPA
    └── services             # Servicios adicionales (ej., consumo de API externa, servicio de consola)
```

### Componentes Principales

- **Cliente**: Representa a los clientes de la aplicación, con atributos como `nombre`, `email` y una lista de `pedidos`.
- **Pedido**: Representa los pedidos realizados por cada cliente, con atributos como `descripcion` y una relación con el `cliente` correspondiente.

## Tecnologías Usadas 🚀

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA** - Para el acceso a la base de datos.
- **H2 Database** - Base de datos en memoria para pruebas (puede adaptarse a MySQL, PostgreSQL, etc.).
- **SLF4J** - Para registro de logs.
- **RestTemplate** - Cliente HTTP para consumir servicios.

## Instalación y Configuración ⚙️

### Requisitos Previos

- **Java 17** o superior.
- **Maven** para la gestión de dependencias.

### Clonar el Repositorio

```bash
git clone https://github.com/Anyel-ec/Anyel-ec-SpringBoot-CleanArchitecture-CRUD-JPA-SqlServer 
cd clean-architecture-crud
```


### Database Configuration

The application uses **Microsoft SQL Server** as its database. Make sure you have SQL Server running locally and update the environment variables for your database credentials.

- **Database URL**: `jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=lab_arq_api`
- **Username**: Set in environment variable `USERNAME_MSSQL`
- **Password**: Set in environment variable `PASSWORD_MSSQL`

The connection properties are configured in `application.properties`:

```properties
spring.application.name=CRUD-CLEAN-ARCHITECTURE

spring.jpa.properties.hibernate.format_sql=true
spring.datasource.url=jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=lab_arq_api
spring.datasource.username=${USERNAME_MSSQL}
spring.datasource.password=${PASSWORD_MSSQL}

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServerDialect
spring.jpa.hibernate.ddl-auto=update
```

To set up the environment variables, use the following commands (replacing `YOUR_USERNAME` and `YOUR_PASSWORD` with your actual SQL Server credentials):

#### On Windows

```cmd
set USERNAME_MSSQL=YOUR_USERNAME
set PASSWORD_MSSQL=YOUR_PASSWORD
```

#### On Linux/macOS

```bash
export USERNAME_MSSQL=YOUR_USERNAME
export PASSWORD_MSSQL=YOUR_PASSWORD
```
---
### Ejecutar el Proyecto

Compila y ejecuta el proyecto con Maven:

```bash
mvn spring-boot:run
```

La aplicación estará disponible en [http://localhost:8080](http://localhost:8080).

## Endpoints de la API 🌐

### Cliente

- **GET /api/clientes** - Obtiene todos los clientes.
- **GET /api/clientes/{id}** - Obtiene un cliente por su ID.
- **POST /api/clientes** - Crea un nuevo cliente.
- **PUT /api/clientes/{id}** - Actualiza un cliente existente.
- **DELETE /api/clientes/{id}** - Elimina un cliente por su ID.

### Pedido

- **GET /api/clientes/{clienteId}/pedidos** - Obtiene todos los pedidos de un cliente.
- **POST /api/clientes/{clienteId}/pedidos** - Crea un nuevo pedido para un cliente específico.
- **DELETE /api/pedidos/{id}** - Elimina un pedido por su ID.

## Ejemplos de JSON para la API 📋

### Crear un Cliente

```json
POST /api/clientes
{
  "nombre": "Juan Pérez",
  "email": "juan.perez@example.com",
  "pedidos": [
    {
      "descripcion": "Pedido de prueba 1"
    },
    {
      "descripcion": "Pedido de prueba 2"
    }
  ]
}
```

### Crear un Pedido para un Cliente

```json
POST /api/clientes/1/pedidos
{
  "descripcion": "Nuevo pedido de ejemplo"
}
```

## Servicio de Consola 🖥️

Este proyecto incluye un servicio de consola que consume el endpoint de clientes y muestra la lista de clientes en la terminal. Para ejecutar este servicio de manera autónoma, simplemente ejecuta el método `main` en `ConsoleClienteService`.

```java
public static void main(String[] args) {
    ConsoleClienteService service = new ConsoleClienteService();
    service.printAllClientes();
}
```

## Principios de Diseño 🛠️

- **Arquitectura Limpia**: Cada capa tiene una responsabilidad específica. La lógica de negocio no depende de la infraestructura, lo que facilita la escalabilidad y el mantenimiento.
- **Inyección de Dependencias**: La configuración y las dependencias son gestionadas a través de Spring, lo que permite desacoplar la lógica de negocio de la implementación específica.
- **Servicios de Consola**: Facilita pruebas rápidas al consumir los endpoints de la API y mostrar los datos en la consola.

## Contribuciones 🤝

1. Realiza un **fork** del proyecto.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza los cambios y confirma (`git commit -m 'Agrega nueva funcionalidad'`).
4. Haz un push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un **pull request** para revisión.

## Contacto 📬

Autor: Anyel EC  
[GitHub](https://github.com/Anyel-ec)

