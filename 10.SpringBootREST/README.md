## 🧩 Aspect Oriented Programming (AOP) in Spring

Aspect-Oriented Programming (AOP) allows the separation of cross-cutting concerns—like logging, security, and transaction management—from the main business logic.

---

### 🔑 Key Terminology

- **Aspect:**  
  A modular unit of a cross-cutting concern. For example, logging or transaction management. In Spring, aspects can be implemented using regular classes with `@Aspect` annotation.

- **Join Point:**  
  A specific point during the execution of a program, such as the execution of a method. In Spring AOP, a join point always refers to a method execution.

- **Advice:**  
  The action taken by an aspect at a particular join point.  
  Types include:
    - `@Before`
    - `@AfterReturning`
    - `@AfterThrowing`
    - `@After` (finally)
    - `@Around`

- **Pointcut:**  
  A predicate expression that matches join points. Advice is executed when the matched join point is reached. Spring uses AspectJ's pointcut expression language by default.

- **Introduction (Inter-type declaration):**  
  Allows adding new methods or fields to existing classes. In Spring, it enables implementing new interfaces for advised beans.

- **Target Object:**  
  The actual object being advised (proxied) by one or more aspects.

- **AOP Proxy:**  
  A proxy object created by the AOP framework to wrap the target object and apply aspects. Spring uses:
    - **JDK Dynamic Proxies** (for interfaces)
    - **CGLIB Proxies** (for classes)

- **Weaving:**  
  The process of linking aspects with the target objects to produce advised objects. It can happen at:
    - **Compile-time**
    - **Load-time**
    - **Runtime** (used in Spring AOP)

---

### 🛠️ Types of Advice in Spring AOP

| Advice Type                | Description                                                                                                                  |
|----------------------------|------------------------------------------------------------------------------------------------------------------------------|
| **Before Advice**          | Runs *before* the join point. Cannot stop execution unless an exception is thrown.                                           |
| **After Returning Advice** | Runs *after* successful completion of the method.                                                                            |
| **After Throwing Advice**  | Runs if the method throws an exception.                                                                                      |
| **After (Finally) Advice** | Runs regardless of method outcome (success or exception).                                                                    |
| **Around Advice**          | Surrounds the method execution; allows pre- and post-processing. Can decide whether to proceed or halt the method execution. |

---

✅ Use Spring AOP to keep your business logic clean and reusable by separating system-wide concerns!
