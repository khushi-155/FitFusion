Overview

The E-Voting System is designed to facilitate online elections efficiently. Users can create elections, cast votes, and monitor election results in a secure and organized manner. This application is built using Spring Boot, Hibernate, and MySQL, ensuring smooth and efficient data management.

1. Features

Create, update, delete, and view elections.
Add and manage election choices.
Cast and count votes securely.
Monitor election results in real-time.
User authentication for secure voting.

2. Tech Stack

Backend: Spring Boot, Hibernate
Database: MySQL
Tools: Maven, Postman (for API testing)

3. Installation & Setup
Prerequisites
Java 17+
MySQL Database
Maven
IDE - Eclipse

4. Steps to Setup

Clone the Repository

git clone https://github.com/your-repository/e-voting-system.git
cd e-voting-system

Configure MySQL Database
Create a new database in MySQL:
CREATE DATABASE evoting_system;
Update application.properties file with your MySQL credentials:
spring.datasource.url=jdbc:mysql://localhost:3306/evoting_system
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

5.Build and Run the Application

mvn clean install
mvn spring-boot:run

6. Access the Application

API endpoints will be available at http://localhost:8080

If a frontend is integrated, access the UI accordingly.

API Endpoints

a. Election APIs

POST /api/elections - Create an election
GET /api/elections - Get all elections
PUT /api/elections/{id} - Update an election
DELETE /api/elections/{id} - Delete an election

b. Choice APIs

POST /api/choices - Add election choices
GET /api/choices - Get all choices
PUT /api/choices/{id} - Update election choices
DELETE /api/choices/{id} - Delete election choices

c.Vote APIs

POST /api/votes - Cast a vote
GET /api/votes - Get all votes

7. Future Enhancements

8. Add authentication and user roles.

9. Implement real-time election monitoring.

Ref Img

![image](https://github.com/user-attachments/assets/1d999a36-58f8-4cf1-af68-5cdc3dc95f52)

![image](https://github.com/user-attachments/assets/a6e8e8e9-bbb5-41c6-9426-86316a64c67d)

![image](https://github.com/user-attachments/assets/c530c60f-800f-43db-aea5-2426be0c73ec)

![image](https://github.com/user-attachments/assets/6807fdb6-882f-4bb2-9c32-d96f778ced70)



