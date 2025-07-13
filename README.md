# E-Commerce Platform

A Spring Boot-based e-commerce platform for product management and order processing.

## Features

- Product CRUD (Create, Read, Update, Delete)
- Order creation and retrieval
- JWT-based authentication (if enabled)
- PostgreSQL database integration

## Technologies

- Java 21
- Spring Boot 3.5.3
- Spring Data JPA
- Spring Security
- PostgreSQL
- Maven

## Getting Started

### Prerequisites

- Java 21+
- Maven
- PostgreSQL

### Setup

1. Clone the repository.
2. Configure your PostgreSQL database in `src/main/resources/application.properties`.
3. Build and run the application:

   ```sh
   mvn clean install
   mvn spring-boot:run

### API Endpoints
Product Endpoints
POST /api/products - Create a product
GET /api/products - List all products
GET /api/products/{id} - Get product by ID
PUT /api/products/{id} - Update product
DELETE /api/products/{id} - Delete product

### Order Endpoints
POST /api/orders - Create an order
GET /api/orders - List all orders
GET /api/orders/{id} - Get order by ID
