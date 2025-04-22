# Hibernate

## What is Hibernate ?
- **Hibernate is an `Object Relational Mapping(ORM) Framework` for Java. It helps you map Java objects to database tables and vice versa, allowing you to interact with your database using Java code instead of writing raw SQL queries.**

### What Hibernate Does:
- **Maps Java classes to database tables using annotations or XML.**
- **Automatically handles CRUD operations (Create, Read, Update, Delete).**
- **Manages database connections and SQL generation under the hood.**
- **Supports relationships (like One-to-Many, Many-to-One, etc.).**
- **Offers caching and lazy loading for performance optimization.**
- **Makes switching databases easier (e.g., from MySQL to PostgreSQL).**

### Key Concepts:
- **`Entity`: A Java class annotated with `@Entity` that maps to a table.**
- **`Session`: The main interface to interact with the database.**
- **`SessionFactory`: A factory for Session objects.**
- **`Transaction`: Wraps around database operations for atomicity.**
- **`Configuration`: XML or annotation-based setup for Hibernate.**