# 🌱 Spring Boot Learning Repository

Welcome to the Spring Boot Learning Repository. This repository captures my hands-on journey through Spring Boot and related technologies. It is organized by topic and project to progressively build skills from fundamental concepts to advanced real-world applications including microservices architecture.

Whether you're a beginner looking to learn Spring Boot or an experienced developer seeking reference implementations, this repository provides well-structured and modular examples.

---

## 📚 Contents

1. [Core Java & Maven Setup](#🧰-core-java--maven-setup)
2. [JDBC & ORM](#🔌-jdbc--orm)
3. [Spring Framework Fundamentals](#🌿-spring-framework-fundamentals)
4. [Spring Boot Web & REST](#🌐-spring-boot-web--rest)
5. [Spring Data JPA & Repositories](#🗄️-spring-data-jpa--repositories)
6. [Security & Authentication](#🔐-security--authentication)
7. [Backend Project](#📝-backend-project)
8. [Microservices Architecture](#🧩-microservices-architecture)
9. [Other Files](#📄-other-files)
10. [Notes](#📝-notes)
11. [Contributing](#🙌-contributing)
12. [Contact](#📬-contact)

---

## 🧰 Core Java & Maven Setup

- `01. Maven-Setup`  
  Basic Maven project initialization and configuration. Includes `pom.xml` structure and dependency management.

---

## 🔌 JDBC & ORM

- `02. JDBC`  
  Working with Java Database Connectivity (JDBC) to interact with relational databases manually.

- `03. Hibernate`  
  Object-Relational Mapping (ORM) using Hibernate. Includes entity mapping, HQL, and annotations.

---

## 🌿 Spring Framework Fundamentals

- `04. SpringBootDemo`  
  A basic Spring Boot demo project for getting started with annotations, auto-configuration, and main application structure.

- `05. Spring`  
  Core Spring concepts: IoC container, dependency injection, bean scopes, and XML/annotation-based configuration.

- `06. SpringBootJDBC`  
  Combining Spring Boot with JDBC for structured and maintainable database interactions.

- `07. Servlet`  
  Simple Java Servlet examples to understand HTTP request/response handling.

---

## 🌐 Spring Boot Web & REST

- `08. SpringBootMVC`  
  Spring Boot with MVC architecture: Controllers, Views, and Request Mapping.

- `09. JobAppProject`  
  Mini project simulating a Job Application System. Demonstrates form handling, service layers, and persistence.

- `10. SpringBootREST`  
  Building REST APIs using Spring Boot, handling HTTP methods and RESTful resource representation.

---

## 🗄️ Spring Data JPA & Repositories

- `11. SpringBootJPA`  
  Introduction to JPA with Spring Boot. CRUD operations, relationships, and query derivation.

- `12. SpringBootECommerceExample`  
  A sample E-Commerce backend showcasing product, category, and order management using Spring Data JPA.

- `13. SpringDataRESTDemo`  
  Demonstrates Spring Data REST to expose repositories directly as RESTful services.

---

## 🔐 Security & Authentication

- `14. SpringSecurity`  
  Fundamentals of Spring Security: user authentication, password encryption, and role-based access control.

- `15. SpringOAuth`  
  Implementing OAuth2 for token-based authentication. Includes JWT integration for secure APIs.

---

## 📝 Backend Project

- `16. QuizApp`  
  Backend quiz application built with Spring Boot. Features quiz creation, question management, scoring logic, and user interaction.

---

## 🧩 Microservices Architecture

A production-style microservices system for a quiz platform using Spring Cloud:

- `17.1. Question-Service`  
  Microservice for managing quiz questions. REST APIs, DTOs, and service-layer design.

- `17.2. Quiz-Service`  
  Microservice responsible for quiz definitions, associations with questions, and user interactions.

- `17.3. Service-Registry`  
  Eureka Service Registry for microservice discovery and registration.

- `17.4. API-Gateway`  
  Spring Cloud Gateway setup for routing, filtering, and securing microservices APIs.

---

## 📄 Other Files

- `.gitignore` – Specifies intentionally untracked files to ignore.
- `README.md` – Documentation for the entire repository.

---

## 📝 Notes

- Each directory is a self-contained Maven or Spring Boot project.
- Best practices followed: separation of concerns, layered architecture, proper naming conventions.
- Ideal for:
  - Preparing for interviews
  - Building real-world backend systems
  - Understanding Spring’s core to cloud-native capabilities
- Technologies Covered:
  - Spring Boot
  - Spring MVC, JPA, Security
  - JDBC, Hibernate
  - RESTful APIs
  - OAuth2 & JWT
  - Spring Cloud (Eureka, Gateway)

---

## 🙌 Contributing

This repository is a personal learning log, but you're welcome to fork it, experiment, extend the examples, or adapt them for your own learning or projects!

- ### 🔧 How to Fork and Use This Repository

  - If you’d like to contribute, experiment, or build upon the code, follow these steps:

    - **Fork the Repository**
      - Click the Fork button at the top-right of this GitHub repo.
      - This creates a copy of the repository under your GitHub account.
    - **Clone Your Fork**

      ```bash
      git clone https://github.com/<your-username>/<repo-name>.git
      cd <repo-name>
      ```

    - **Set Up the Project**

      - Open the project in your favorite IDE (like IntelliJ IDEA, Eclipse, or VS Code).
      - Ensure Java and Maven/Gradle are properly installed.
      - Run the following to install dependencies (if using Maven):

        ```bash
        mvn clean install
        ```

    - **Explore or Extend the Code**
      - Feel free to navigate through the folders (e.g., `SpringBootREST`, `SpringSecurity`, `QuizApp`, etc.).
      - Modify or extend functionality to match your use case.
    - **Push Changes to Your Fork**

      ```bash
      git add .
      git commit -m "Your meaningful commit message"
      git push origin main
      ```

    - **(Optional) Create a Pull Request**
      - If you’d like to contribute improvements back to this repo, open a pull request with a brief description of the changes.

---

## 📬 Contact

If you'd like to discuss anything or need guidance, feel free to reach out via GitHub or email me on **shivamkumardev01@gmail.com**.

---

> _“The best way to learn is by doing. This repository is a reflection of that philosophy.”_
