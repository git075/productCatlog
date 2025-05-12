# productCatlog
# 🛍️ Product Catalog REST API

A **Spring Boot** based RESTful **Product Catalog API** with full CRUD support, **pagination**, **caching via Redis Cloud**, and **in-memory H2 Database** for fast development and testing.

This project is designed with clean architecture, performance best practices, and production-readiness in mind — perfect for recruiters, internships, and interviews.

---

## ✅ Features

- Add, update, delete, and view products
- Pagination for large data handling
- Redis Cloud integration for efficient caching
- H2 in-memory database for lightweight dev/testing
- Swagger UI for API testing
- Modular structure with proper layering
- Cache eviction upon data mutation
- TTL-based caching
- Follows SOLID, DRY, and REST best practices

---

## 🧰 Tools & Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Spring Cache + Redis Cloud**
- **H2 Database**
- **Maven**
- **Swagger (springdoc-openapi)**

---

## 🚀 How to Run the Backend

### ✅ Prerequisites
- JDK 17+
- Maven 3.6+
- IDE (IntelliJ, VSCode, Eclipse)

### 🔧 Clone and Run
```bash
git clone https://github.com/your-username/product-catalog-api.git
cd product-catalog-api
./mvnw spring-boot:run


🌐 Swagger UI
Test the APIs interactively:

📌 http://localhost:8080/swagger-ui.html

🧪 Sample Input & Output
➕ Create Product (POST)
POST /api/products
Content-Type: application/json

{
  "name": "Samsung Galaxy S24",
  "description": "Latest flagship smartphone",
  "price": 999.99
}

📄 Get Paginated Products (GET)
Request
GET /api/products?page=0&size=5

Response
{
  "content": [
    {
      "id": 1,
      "name": "Samsung Galaxy S24",
      "description": "Latest flagship smartphone",
      "price": 999.99
    }
  ],
  "totalElements": 1,
  "totalPages": 1,
  "number": 0,
  "size": 5
}


🧠 Redis Cloud Setup
Go to Redis Cloud → Create a free Redis DB.

Copy the:

Host

Port

Password

Update application.properties:
spring.redis.host=your-redis-host
spring.redis.port=your-redis-port
spring.redis.password=your-password
spring.redis.ssl.enabled=true

spring.cache.type=redis


🏆 Best Practices Used
✅ RESTful layered architecture
✅ Pagination with Pageable and Page<T>
✅ Redis Cloud-based distributed caching
✅ Cache invalidation on update/delete
✅ TTL to prevent stale data
✅ Exception handling and ResponseEntity usage
✅ Logging using SLF4J
✅ Clean code structure (controller/service/repo layers)
✅ Swagger UI for self-documentation
✅ Externalized config via application.properties
✅ Profile-based environment handling

🧑‍💻 Author
Anurag Ghosliya
Java | Spring Boot | Redis | Backend Developer
📧 anuragchoudhary9929@gmail.com

