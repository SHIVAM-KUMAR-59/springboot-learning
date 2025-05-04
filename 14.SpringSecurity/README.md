# 🔐 Spring Boot JWT Authentication – Core Overview

This project uses **Spring Security** and **JWT (JSON Web Tokens)** to authenticate and authorize users in a stateless REST API environment.

---

## 📁 Key Files Explained

### 1. `SecurityConfig.java` – Spring Security Configuration

This class configures security rules for the application:

- Disables CSRF for stateless API.
- Permits unauthenticated access to `/register` and `/login`.
- Applies a custom JWT filter (`JWTFilter`) **before** `UsernamePasswordAuthenticationFilter`.
- Configures session management as **STATELESS**.
- Uses a `DaoAuthenticationProvider` with `MyUserDetailsService` and password encoding.

---

### 2. `JWTFilter.java` – Intercept and Validate JWT

This filter extends `OncePerRequestFilter` and does the following on each request:

- Extracts the JWT token from the `Authorization` header.
- Validates the token using `JWTService`.
- Loads user details from `MyUserDetailsService`.
- If valid, sets authentication in `SecurityContextHolder`.

It ensures that only authenticated users can access protected endpoints.

---

### 3. `JWTService.java` – Generate & Validate Tokens

Responsible for all JWT operations:

- 🔐 **Generate JWT Token** upon successful login.
- 🔍 **Extract Username** from token for validation.
- ⛔ **Check token expiration** and match user identity.
- Uses `io.jsonwebtoken` (`jjwt`) library for cryptographic operations.

---

## 🔄 Authentication Flow

```text
1. 📝 Register/Login:
   - User sends a POST request to /register or /login with credentials.
   - If successful:
     - Password is securely encoded.
     - A signed JWT is generated and returned in the response.

2. 📦 Subsequent Requests:
   - Client includes `Authorization: Bearer <JWT>` header in all requests.
   - `JWTFilter` intercepts the request:
     - Extracts and validates the JWT.
     - Loads user info via `MyUserDetailsService`.
     - Sets the authentication context.

3. 🔐 Access Control:
   - If the token is valid and not expired, the request proceeds.
   - Else, a 401 Unauthorized error is returned.
