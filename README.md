# FitFusion

FitFusion is a fitness application that enables trainers to assign workouts and diets to customers through an online platform. Customers can log in, access their exercise routines, and follow them securely using JWT authentication.

## Features
- User authentication with JWT
- Role-based access control (Admin, Trainer, Customer)
- Assigning and managing workouts and diets
- Secure API endpoints

## Project Structure
### 1. Models
The following entity classes are created in the `model` package with the required annotations (Lombok, JPA):

#### User
- `Long id`
- `String email`
- `String password`
- `int age`
- `String gender`
- `Long contactNo`
- `Set<Role> roles` (ManyToMany)
- `List<Exercise> exerciseList` (OneToMany)
- `List<Diet> diets` (OneToMany)

#### Role
- `Long id`
- `String roleName`

#### Exercise
- `Long id`
- `String name`
- `String description`
- `int sets`
- `int reps`
- `User user` (ManyToOne)

#### Diet
- `Long id`
- `String name`
- `String description`
- `User user` (ManyToOne)

### 2. DTO Classes
The following DTO classes are created in the `dto` package:

- `DietDto`
  - `String name`
  - `String description`

- `ExerciseDto`
  - `String name`
  - `String description`
  - `int sets`
  - `int reps`

- `UserDto`
  - `String email`
  - `String password`
  - `int age`
  - `String gender`
  - `Long contactNo`
  - `String userType` ("ADMIN", "CUSTOMER", "TRAINER")

- `JwtRequest`
  - `String username`
  - `String password`

- `JwtResponse`
  - `String jwtToken`

### 3. Controllers
API endpoints are created in the `controller` package:

#### AuthController
- **POST `/auth/login`** - User login

#### DietController (Trainer APIs)
- **GET `/diet/all`** - Fetch all diets
- **GET `/diet/{id}`** - Fetch diet by ID
- **POST `/diet/create/{userId}`** - Create diet for a user
- **PUT `/diet/{id}`** - Update diet by ID
- **DELETE `/diet/{id}`** - Delete diet by ID

#### ExerciseController (Trainer APIs)
- **GET `/exercise/all`** - Fetch all exercises
- **GET `/exercise/{id}`** - Fetch exercise by ID
- **POST `/exercise/create/{userId}`** - Create exercise for a user
- **PUT `/exercise/{id}`** - Update exercise by ID
- **DELETE `/exercise/{id}`** - Delete exercise by ID

#### UserController
- **Admin APIs**
  - **GET `/user/all`** - Fetch all users
  - **GET `/user/{id}`** - Fetch user by ID
  - **PUT `/user/{id}`** - Update user by ID
  - **DELETE `/user/{id}`** - Delete user by ID

- **Customer APIs**
  - **GET `/user/exercise/{id}`** - Fetch user exercises
  - **GET `/user/diet/{id}`** - Fetch user diets

- **Public APIs**
  - **POST `/user/register`** - User registration

### 4. Services
Implement business logic in the `service` package:
- `DietService`
- `ExerciseService`
- `UserService`

### 5. Repositories
Extend JPA Repository in the `repository` package:
- `DietRepository`
- `ExerciseRepository`
- `UserRepository`

### 6. Exception Handling
Create custom exceptions in the `exception` package:
- `DietNotFoundException`
- `ExerciseNotFoundException`
- `UserNotFoundException`

### 7. JWT Security
Create classes in the `jwt` package:
- `JwtAuthenticationHelper`
- `JwtAuthenticationFilter`

### 8. Security Configuration
Create `FitFusionSecurityConfig`:
- Configure `PasswordEncoder`, `AuthenticationManager`, and `SecurityFilterChain`
- Open endpoints: `/auth/login`, `/user/register`

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd FitFusion
   ```
3. Build the project:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
5. Test the APIs using Postman.

## Technologies Used
- Java
- Spring Boot
- Spring Security
- JWT Authentication
- Hibernate & JPA
- Lombok
- Maven

## License
This project is licensed under the MIT License.



Ref Img

![image](https://github.com/user-attachments/assets/1d999a36-58f8-4cf1-af68-5cdc3dc95f52)

![image](https://github.com/user-attachments/assets/a6e8e8e9-bbb5-41c6-9426-86316a64c67d)

![image](https://github.com/user-attachments/assets/c530c60f-800f-43db-aea5-2426be0c73ec)

![image](https://github.com/user-attachments/assets/6807fdb6-882f-4bb2-9c32-d96f778ced70)



