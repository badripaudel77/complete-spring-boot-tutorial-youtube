# Spring Boot Tutorial Application (sb-yt-tutorial)

Welcome to the **complete-spring-boot-tutorial** with REST API development project from scratch! This is a comprehensive Spring Boot demonstration application designed to showcase modern Java development practices. It implements a REST-ful API featuring a real-world example of a **Posts** and **Comments**.

## 🚀 Key Features

*   **REST API**: API development for `Post` and `Comment` resources with associations / mappings.
*   **Database Integration**: Uses **Spring Data JPA** with **PostgreSQL** for robust data persistence.
*   **Database Migration**: Integrated **Flyway** for version-controlled database schema management.
*   **Modern Java**: Built using **Java 25** and **Spring Boot 4.0.0**.
*   **Clean Architecture**: Structured with clear separation of concerns with N-Layer architecture (Controllers, Services, Repositories, DTOs).
*   **API Versioning**: Demonstrates dynamic API versioning configuration.

## 🛠 Technologies Used

*   **Java 25**
*   **Spring Boot 4.0.0**
    *   Spring WebMVC
    *   Spring Data JPA
*   **PostgreSQL** (Database)
*   **Flyway** (Database Migration)
*   **Lombok** (Boilerplate reduction)
*   **Maven** (Build tool)

## 📂 Project Structure

The source code is organized into the following packages under `com.example.tutorial`:

*   `config`: Application configuration classes.
*   `controller`: REST controllers handling HTTP requests (`PostController`, `CommentController`).
*   `dto`: Data Transfer Objects for API communication.
*   `model`: JPA Entities representing the database schema (`Post`, `Comment`).
*   `repository`: Interfaces for database access (DAO).
*   `service`: Business logic layer.

## 📋 Prerequisites

Before running the application, ensure you have the following installed:

1.  **Java Development Kit (JDK) 25**
2.  **PostgreSQL** (running locally or accessible via network)
3.  **Maven** (optional, as the project includes the Maven Wrapper)

## ⚙️ Setup & Configuration

### 1. Database Setup

Create a PostgreSQL database named `yt_sb`. You can do this using the `psql` CLI or a tool like pgAdmin:

```sql
CREATE DATABASE yt_sb;
```

### 2. Application Configuration

Open `src/main/resources/application.yaml` and verify the database connection settings. Update the `username` and `password` if your local PostgreSQL configuration differs from the defaults:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/yt_sb
    username: postgres  # Change if necessary
    password: postgres  # Change if necessary
```

*Note: Flyway is enabled and will automatically apply database migrations located in `src/main/resources/db/migration` on startup.*

## ▶️ Running the Application

You can run the application using one of the following methods:

### 1. Using Maven (if installed)
If you have Maven installed on your system:
```bash
mvn spring-boot:run
```

### 2. Using Maven Wrapper
If you don't have Maven installed, use the wrapper included in the project:

**For example on Windows:**
```bash 
.\mvnw spring-boot:run
```

### 3. From the IDE (UI)
You can run the application directly from your IDE (e.g., IntelliJ IDEA) by locating the main application class `TutorialApplication.java` and clicking the **Run** button (green arrow).

Once the application starts, the server will be accessible at `http://localhost:8080`.

## 🧪 Testing
To run the tests:
```bash 
mvn test
```