# Client and Order Management Project 🛒

## Description 📄

This project is a RESTful API built in **Java** using **Spring Boot** and follows **Clean Architecture** principles. The application enables the management of clients and their orders in a modular, scalable way, ensuring a clear separation between business logic, infrastructure, and database interaction.

## Project Structure 📂

The project is organized following Clean Architecture principles. This structure ensures that each layer is well-defined and decoupled, allowing for greater flexibility and maintainability.

```
com.example.project
├── domain                   # Domain Layer (Business Logic)
│   ├── model                # Main entity models (Client, Order)
│   └── repository           # Repository interfaces
├── application              # Application Layer (Use Cases)
│   └── usecase              # Use case logic (ClientService, OrderService)
├── adapter                  # Input and Output Adapters
│   ├── input                # Input Adapters (REST API)
│   └── output               # Output Adapters (External Integration)
└── infrastructure           # Infrastructure Layer
    ├── configuration        # Spring configuration and beans
    ├── controllers          # REST Controllers (ClientController, OrderController)
    ├── repositories         # JPA repository implementations
    └── services             # Additional services (e.g., external API consumption, console service)
```

### Key Components

- **Client**: Represents the clients in the application, with attributes like `name`, `email`, and a list of `orders`.
- **Order**: Represents orders made by each client, with attributes such as `description` and a relation to the corresponding `client`.

## Technologies Used 🚀

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA** - For database access.
- **MSSQL Database** 
- **SLF4J** - For logging.
- **RestTemplate** - HTTP client for consuming services.

## Installation and Configuration ⚙️

### Prerequisites

- **Java 17** or higher.
- **Maven** for dependency management.

### Clone the Repository

```bash
git clone https://github.com/Anyel-ec/Anyel-ec-SpringBoot-CleanArchitecture-CRUD-JPA-SqlServer 
cd clean-architecture-crud
```

Here's the updated **Database Configuration** section for your `README.md`:

---

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
### Running the Project

Compile and run the project with Maven:

```bash
mvn spring-boot:run
```

The application will be available at [http://localhost:8080](http://localhost:8080).

## API Endpoints 🌐

### Client

- **GET /api/clients** - Get all clients.
- **GET /api/clients/{id}** - Get a client by ID.
- **POST /api/clients** - Create a new client.
- **PUT /api/clients/{id}** - Update an existing client.
- **DELETE /api/clients/{id}** - Delete a client by ID.

### Order

- **GET /api/clients/{clientId}/orders** - Get all orders of a client.
- **POST /api/clients/{clientId}/orders** - Create a new order for a specific client.
- **DELETE /api/orders/{id}** - Delete an order by ID.

## API JSON Examples 📋

### Create a Client

```json
POST /api/clients
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "orders": [
    {
      "description": "Test order 1"
    },
    {
      "description": "Test order 2"
    }
  ]
}
```

### Create an Order for a Client

```json
POST /api/clients/1/orders
{
  "description": "New sample order"
}
```

## Console Service 🖥️

This project includes a console service that consumes the client endpoint and displays the client list in the terminal. To run this service standalone, simply execute the `main` method in `ConsoleClienteService`.

```java
public static void main(String[] args) {
    ConsoleClienteService service = new ConsoleClienteService();
    service.printAllClientes();
}
```

## Design Principles 🛠️

- **Clean Architecture**: Each layer has a specific responsibility. Business logic is independent of infrastructure, allowing for scalability and easy maintenance.
- **Dependency Injection**: Configuration and dependencies are managed through Spring, decoupling business logic from specific implementations.
- **Console Services**: Quick testing through endpoint consumption and console display.

## Contributing 🤝

1. Fork the project.
2. Create a new branch (`git checkout -b feature/new-feature`).
3. Make your changes and commit them (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature/new-feature`).
5. Open a **pull request** for review.

## Contact 📬

Author: Anyel EC  
[GitHub](https://github.com/Anyel-ec)
