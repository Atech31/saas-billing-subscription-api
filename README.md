# Multi-Tenant SaaS Billing & Subscription API

A secure, enterprise-grade multi-tenant REST API built with **Java 17**, **Spring Boot**, and **Spring Data JPA**. This service isolates data across multiple tenants using a custom request interceptor and `ThreadLocal` context management.

[![Java Version](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.5-green?style=for-the-badge&logo=springboot)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue?style=for-the-badge&logo=postgresql)](https://www.postgresql.org/)

---

## Architecture & Multi-Tenancy Design
* **Tenant Isolation:** Every incoming HTTP request must include the **`X-Tenant-ID`** header.
* **Interceptor Pattern:** `TenantInterceptor` intercepts requests under `/api/v1/**`, validates the tenant header, and stores the tenant identifier in a secure `ThreadLocal` context (`TenantContext`).
* **Automatic Cleanup:** After request completion, the interceptor clears the context to prevent thread-pooling data leaks.

---

## Core Features
* **Multi-Tenant Request Routing:** Automatic tenant resolution per request via headers.
* **Subscription Management:** Create, track, and assign tiered subscription plans (`BASIC`, `PRO`, `ENTERPRISE`).
* **Automated Invoice Generation:** Issue invoices with dynamic due dates and status tracking.
* **Relational Mapping:** Robust JPA entities linking tenants, plans, subscriptions, and invoices.

---

## Tech Stack
* **Backend:** Java 17, Spring Boot, Spring Data JPA, Hibernate
* **Database:** PostgreSQL / MySQL
* **Build Tool:** Maven
* **Utilities:** Lombok, Jakarta Validation

---

## 📂 Project Structure
```text
saas-billing-subscription-api/
├── src/main/java/com/saas/billing/
│   ├── config/          # Web & Security configurations
│   ├── controller/      # REST API endpoints (Subscriptions, Invoices)
│   ├── model/           # JPA Entities (Tenant, Plan, Subscription, Invoice)
│   ├── repository/      # Spring Data JPA Repositories
│   ├── security/        # TenantInterceptor & ThreadLocal TenantContext
│   └── service/         # Business logic layer
└── src/main/resources/
    └── application.properties # Datasource & JPA configuration
