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

### Add these in your `resources/hibernate.cfg.xml`
```xml
<hibernate-configuration xmlns="http://www.hibernate.org/xsd/orm/cfg">
    <session-factory>

        <property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
        <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/databse_name</property>
        <property name="hibername.connection.username">username</property>
        <property name="hibername.connection.password">password</property>

    </session-factory>
</hibernate-configuration>
```

### 1. Configuration and Setup
- Hibernate is configured using `Configuration` class.
- Annotated classes are registered using `.addAnnotatedClass()`.
- `SessionFactory` is built from configuration and is a heavyweight object.
- `Session` is used to perform operations like save, update, get, delete.

### 2. Entity Classes
- `@Entity` marks the class as a database entity.
- `@Id` denotes the primary key field.
- `@ManyToMany`, `@OneToOne`, `@ManyToOne` etc., are used to define relationships.

### 3. Relationships
- `Alien` has a `@ManyToMany` relationship with `Laptop`.
- Relationship is bidirectional: `Laptop` also has `@ManyToMany(mappedBy = "laptops")` pointing back to `Alien`.

### 4. Persisting Data
- Before performing database operations, begin a transaction with `session.beginTransaction()`.
- Use `session.persist(object)` to insert entities into the database.
- Commit the transaction using `transaction.commit()` to save changes.

### 5. Fetching and Deleting
- `session.get(Class, id)` fetches an object by its primary key.
- `session.remove(object)` deletes an entity from the database.

### 6. Notes on Object Lifecycle
- `persist()` is used for new entities.
- `merge()` can be used to update existing entities or insert if not present.
- `clear()` and `close()` are called at the end to clean up session and factory resources.

### 7. Miscellaneous
- `@Transient` can be used to exclude a field from persistence.
- `@Table` and `@Column` can customize table and column names.
- `@Embeddable` can be used for value-type objects that are part of another entity.

### Example Flow:
1. Create objects (Alien, Laptop).
2. Set relationships (both sides).
3. Open session, begin transaction.
4. Call `persist()` for all entities.
5. Commit transaction, close session and factory.
