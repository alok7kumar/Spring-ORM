# Spring ORM Basic Project

A simple Spring MVC + Hibernate ORM project that demonstrates user creation and saving into a MySQL database.

This project demonstrates how to integrate Spring MVC with Hibernate ORM without using XML configuration, following a clean 3-layered architecture: Controller → Service → Repository.

---

## Technologies Used

- Java
- Spring MVC( Model View Controller )
- Spring ORM( Object Relational Mapping ) ( Hibernate )
- Hibernate Template
- MySQL
- JSP
- Maven

---

## Project Structure

- **Entity**: `User.java` (maps to database table)
- **Configuration**: `AppConfig.java` (Spring beans, Hibernate setup)
- **Repository Layer**: `UserRepository.java` (DAO for DB operations)
- **Service Layer**: `UserService.java` (calls repository methods)
- **Controller Layer**: `UserController.java` (handles HTTP requests)
- **Initializer**: `initializer.java` (replaces `web.xml`)

---

## How It Works

- Access `/form` to open the form page.
- Fill the form and submit (handled by `/handle`).
- User data is saved to MySQL database using Hibernate.

---

## Database Setup

- Database name: `firstdb`
- Table: `User` (auto-created by Hibernate)

Update your MySQL username and password inside `AppConfig.java`:
```java
 dataSource.setUsername("root");
 dataSource.setPassword("your_password");
```

---

## Running the Application

1. Import the project into Eclipse or IntelliJ.
2. Ensure MySQL is running and `firstdb` database is created.
3. Make sure your MySQL credentials match those in AppConfig.java.
4. Run the application on Tomcat server 9.
5. Visit:

```bash
http://localhost:8080/[project_name]/form
```
6. Fill the form and submit. Check the database for new user entries.

---

## Features

- Simple user form (Name and Password).
- Hibernate ORM with Spring integration.
- Save user data to the database.
- Java-based configuration (no XML).
- Dynamic table creation with hibernate.hbm2ddl.auto=update.

---

## Important

- Hibernate auto-creates the User table.
- No XML config — full Java-based Spring setup.
- This project is focused on understanding basic ORM integration, not front-end design.

---

## This is for the learning purpose

