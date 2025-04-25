# Sample SpringBoot Project

## Inversion of Control (IoC)

- A principle where the control of object creation and lifecycle is transferred from the program to a container/framework.
- In Spring Boot, the IoC container manages beans and their dependencies.
- Helps in decoupling components.
- Achieved using annotations and configuration classes.
- Core to the Spring Framework's design philosophy.


## Dependency Injection

- A design pattern used to remove hard-coded dependencies.
- Objects are provided their dependencies instead of creating them.
- Promotes loose coupling and easier testing.
- Spring Boot uses annotations like `@Autowired`, `@Component`, `@Service`, `@Repository`.
- Constructor injection is preferred for mandatory dependencies.

## Beans
- Objects created by the `spring` framework are known as beans

## Getting the objects without using `new` keyword
```java
@Component // Allows spring to create the object for this class
public class Alien {
    public void code(){
        System.out.println("Coding...");
    }
}

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // The run method returns the ApplicationContext object
        ApplicationContext context = SpringApplication.run(Application.class, args);

        // Alien obj = new Alien(); --> Conventional way of creating objects
        Alien obj = context.getBean(Alien.class); // getBean retrieves the object of that class from the IOC container
        obj.code();
    }

}
```

### What if the class `Alien` depends on another class?

- We use the `@Autowired` annotation to inject the dependency.
- Spring automatically wires the required bean from the context.
- This allows automatic linking between dependent beans.

```java
@Component
public class Laptop {
    public void compile() {
        System.out.println("Compiling...");
    }
}

@Component
public class Alien {

    @Autowired
    private Laptop laptop; // Dependency injected by Spring

    public void code() {
        laptop.compile(); // Using the injected dependency
        System.out.println("Coding...");
    }
}
```
- Spring will automatically create objects of both `Alien` and `Laptop`.
- It will inject the `Laptop` bean into the `Alien` bean.
- No need to manually instantiate `Laptop`.