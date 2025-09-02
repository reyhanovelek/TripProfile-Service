# 🧑‍💼 TripProfile (User Profile Service - Microservice 2)

---

🔗 [TripWise-Architecture 🍀 Overview Repository](#)

**Microservices ⬇️ part of TripWise System**

- 🖇️ Microservice 0: [TripHub - Gateway Service](#)
- 🖇️ Microservice 1: [TripPass - Authentication Service](#)
- 🖇️ Microservice 2: [TripProfile - User Profile Service](#)
- 🖇️ Microservice 3: [TripPlanner - Planner Service](#)
- 🖇️ Microservice 4: [TripJournal - Journal Service](#)
- 🖇️ Microservice 5: [TripWeather - Weather Service](#)
- 🖇️ Microservice 6: [TripMedia - Media Service](#)

---

## 📖 About

TripProfile is a microservice within the **TripWise system**, purpose-built for handling user profile management.  
It works together with **TripPass (authentication service)** and provides secure CRUD operations for user profile data.

Developed with **Java 17+**, **Spring Boot 3**, and **PostgreSQL**, this service ensures reliable and secure storage of profile information, seamlessly integrable into modern microservice architectures.

---

## ✨ Features

- Create & update passenger profiles (`PUT /me`)
- Read back current profile (`GET /me`)
- Secure endpoints with JWT from TripPass
- Robust validation & exception handling (400, 404 cases)
- Health check endpoints for monitoring
- Modular and extensible for future enhancements

---

## 🛠 Tech Stack

- Java 17
- Spring Boot 3
- Maven
- PostgreSQL (relational persistence)
- Docker

---

## 📂 Project Structure

```bash
tripprofile/
├── pom.xml
├── src/main/java/com/tripwise/tripprofile/
│   ├── TripprofileApplication.java       # Main entrypoint
│   ├── config/
│   │   └── SecurityConfig.java           # Security configuration
│   ├── controller/
│   │   └── UserProfileController.java    # REST API endpoints
│   ├── dto/
│   │   ├── UpsertProfileRequest.java     # DTO for update/create
│   │   └── UserProfileResponse.java      # DTO for responses
│   ├── exception/
│   │   └── GlobalExceptionHandler.java   # Centralized exception handling
│   ├── model/
│   │   └── UserProfile.java              # User profile entity
│   ├── repository/
│   │   └── UserProfileRepository.java    # PostgreSQL JPA repository
│   └── service/
│       └── UserProfileService.java       # Business logic
│
└── src/main/resources/
    ├── application.yml
    ├── application-dev.yml
    └── application-docker.yml
⚙️ Environment Configurations
Example .env file:

properties
Copy code
#-------------------------------------------
# TripProfile Configuration
#-------------------------------------------
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/tripprofile
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres
JWT_SECRET=your_jwt_secret_from_TripPass
🐳 Run with Docker
bash
Copy code
docker build -t tripprofile .
docker run -p 9092:9092 tripprofile
Service will be available at:

Localhost → http://localhost:9092/tripprofile

Dockerized → https://tripwise:9092/tripprofile

🌐 API Endpoints
Method	Endpoint	Auth	Description
PUT	/me	✅	Create or update user profile
GET	/me	✅	Read back current user profile
PUT	/me (400)	✅	Validation error on bad payload
GET	/me (404)	✅	Profile not found
GET	/actuator/health	❌	Health check endpoint

🔗 Integration Map (TripWise Microservices)
TripHub → API Gateway

TripPass → Authentication (Google OAuth2 / JWT provider)

TripProfile → Stores and manages passenger profile data

TripPlanner → Trip planning, itinerary service

TripJournal → Journals, memories, notes

TripWeather → Weather forecasts for trips

TripMedia → Media and profile avatars

