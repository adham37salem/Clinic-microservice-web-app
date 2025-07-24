# 🏥 Healthcare Microservices System

This project is a microservices-based backend system developed using **Java Spring Boot 3**. It includes independent services for **Patient**, **Doctor**, and **Payment**, all accessed through a centralized **API Gateway** built using **Spring Cloud Gateway**. The services register themselves with **Eureka Discovery Server**, making the system dynamic, scalable, and easier to manage.

---

## 📦 Project Structure

```
healthcare-system/
│
├── api-gateway/           # Spring Cloud Gateway for routing
├── discovery-server/      # Eureka Server for service discovery
├── patient-service/       # Patient microservice
├── doctor-service/        # Doctor microservice
├── payment-service/       # Payment microservice
└── README.md              # Project documentation
```

---

## 🚀 Technologies Used

- **Java 17**
- **Spring Boot 3**
- **Spring Cloud Gateway**
- **Spring WebFlux** (used in API Gateway)
- **Spring Data JPA**
- **Spring Cloud Eureka Discovery**
- **Spring OpenFeign**
- **MapStruct**
- **Lombok**
- **MySQL / H2 Database**
- **Docker & Docker Compose** *(optional)*
- **Maven**

---

## 🧩 Microservices Overview

### 🧑‍⚕️ Patient Service
- REST APIs to manage patient data
- Communicates with Doctor and Payment services
- Uses OpenFeign for internal API calls

### 👨‍⚕️ Doctor Service
- Manages doctors and their schedules
- Exposes REST APIs to Patient service

### 💳 Payment Service
- Handles payments and billing
- Tracks transactions and service charges

### 🚪 API Gateway
- Routes external requests to internal services
- Secures and manages API traffic
- Path-based routing
- Integrates with Eureka for dynamic service resolution

### 🔍 Eureka Discovery Server
- Registers all services
- Enables dynamic discovery and load balancing

---

## 🔗 API Gateway Routing

| Gateway Path              | Routes To        | Purpose                       |
|--------------------------|------------------|-------------------------------|
| `/api/patients/**`       | patient-service  | Patient data management       |
| `/api/doctors/**`        | doctor-service   | Doctor details and schedules  |
| `/api/payments/**`       | payment-service  | Payments and billing records  |

Example request:
```http
GET http://localhost:8080/api/patients/1
```

---

## 🛠️ How to Run Locally

### ✅ Prerequisites

- Java 17+
- Maven 3.8+
- MySQL (or use H2 embedded DB)
- Docker (optional)

---

### 📌 Startup Order (Manual)

1. **Run Eureka Discovery Server**
```bash
cd discovery-server
mvn spring-boot:run
```

2. **Run API Gateway**
```bash
cd api-gateway
mvn spring-boot:run
```

3. **Run Microservices**
```bash
cd patient-service
mvn spring-boot:run

cd doctor-service
mvn spring-boot:run

cd payment-service
mvn spring-boot:run
```

---

## 🐳 Docker (Optional)

Ensure each service has a `Dockerfile`.

Example:
```dockerfile
# patient-service/Dockerfile
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/patient-service.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
```

Then use this `docker-compose.yml`:

```yaml
version: '3.8'
services:
  discovery-server:
    build: ./discovery-server
    ports:
      - "8761:8761"

  api-gateway:
    build: ./api-gateway
    ports:
      - "8080:8080"
    depends_on:
      - discovery-server

  patient-service:
    build: ./patient-service
    ports:
      - "8081:8081"
    depends_on:
      - discovery-server

  doctor-service:
    build: ./doctor-service
    ports:
      - "8082:8082"
    depends_on:
      - discovery-server

  payment-service:
    build: ./payment-service
    ports:
      - "8083:8083"
    depends_on:
      - discovery-server
```

Run everything:
```bash
docker-compose up --build
```

---

## 🧪 Testing the System

You can test the APIs using tools like:

- **Postman**
- **cURL**
- **Insomnia**

Examples:

- Create a patient:
```http
POST http://localhost:8080/api/patients
```

- Get a doctor:
```http
GET http://localhost:8080/api/doctors/1
```

- Process a payment:
```http
POST http://localhost:8080/api/payments
```

---

## 📊 Service Discovery UI

Visit Eureka UI to verify registration:
```
http://localhost:8761
```

You should see:
- `PATIENT-SERVICE`
- `DOCTOR-SERVICE`
- `PAYMENT-SERVICE`
- `API-GATEWAY`

---

## 📄 Configuration Example (application.yml)

### API Gateway:

```yaml
server:
  port: 8080

spring:
  application:
    name: API-GATEWAY
  cloud:
    gateway:
      routes:
        - id: patient-service
          uri: lb://PATIENT-SERVICE
          predicates:
            - Path=/api/patients/**
        - id: doctor-service
          uri: lb://DOCTOR-SERVICE
          predicates:
            - Path=/api/doctors/**
        - id: payment-service
          uri: lb://PAYMENT-SERVICE
          predicates:
            - Path=/api/payments/**
    discovery:
      locator:
        enabled: true
        lower-case-service-id: true

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka
```

---

## ✅ Future Improvements

- [ ] Add centralized config using Spring Cloud Config Server
- [ ] Add Resilience4j for circuit breaking and fallback
- [ ] Add Swagger/OpenAPI for each service
- [ ] Add OAuth2 / JWT for secured endpoints
- [ ] Add distributed tracing with Sleuth + Zipkin

---

## 👤 Author

**Adham Salem**  
*Full Stack & Cloud Engineer*

---

## 📄 License

This project is licensed under the **MIT License**. Feel free to use and modify as needed.
