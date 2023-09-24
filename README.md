# <h1 align="center"> Job Description </h1>
<p align="center">
  <a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
  </a>
  <a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-4.0-brightgreen.svg" />
  </a>
  <a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.3-brightgreen.svg" />
  </a>
   <img alt = "GPL v3" src="https://img.shields.io/badge/License-GPLv3-blue.svg" />
</p>

---

<p align="left">

## Overview
This repository demonstrates CRUD (Create, Read, Update, Delete) operations on a Job entity using Spring Boot. The Job entity includes validation using Spring Boot annotations.

## Job Entity

The Job entity represents job listings with various fields, including validation constraints.

## Fields

- id: Unique identifier for the job.
- title: Title of the job.
- description: Description of the job.
- location: Location of the job.
- salary: Salary for the job (minimum value of 20,000 required).
- companyEmail: Email address of the company.
- companyName: Name of the company.
- employerName: Name of the employer.
- jobType: Type of job (IT, HR, Sales, Marketing, etc.) represented using an Enum.
- appliedDate: Date when the job was applied.

## Validation

- salary has a minimum value constraint of 20,000.

## Database

This project uses an H2 in-memory database for data storage.
```java
spring.datasource.url=jdbc:h2:mem:h2db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=ina728mg
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.h2.console.enabled=true
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true
```

### CRUD Operations

## Using Inbuilt CrudRepository Methods



### Controller

The Controller layer is responsible for handling incoming HTTP requests and delegating them to the appropriate services. It defines API endpoints for various operations, including adding visitors, retrieving hit counts, and updating counts for specific users. Each endpoint maps to a specific service method to ensure proper request handling and response generation.

```java
@RestController
@RequestMapping("/api/v1/visitor-count-app")
public class UrlHitController {
    @Autowired
    private URLService urlService;

    // Endpoint mappings for various operations
    // ...
}
```

### Service

The Service layer encapsulates the core business logic and data processing. It interacts with the Repository layer to retrieve and store data. In this application, it handles operations like adding visitors, retrieving hit counts, and updating counts for users. The Service layer validates input data and performs necessary operations before returning results to the Controller.

```java
@Service
public class UrlService {
    @Autowired
    private UrlRepo urlRepo;

    // Service methods for various operations
    // ...
}
```

### Repository

The Repository layer manages data access to in-memory storage. It maintains a list of `UrlHitCounterEntity` objects to store hit counts for visitors. While this in-memory storage is suitable for a simple application, in a production environment, a database should be used for data persistence.

```java
@Repository
public class UrlRepo {
    @Autowired
    private List<UrlHitCounterEntity> urlList;

    // Repository methods for managing visitor data
    // ...
}
```

## Database Design

The URL Hit Counter application utilizes a simple in-memory data structure to store hit counts. In a production environment, it is advisable to replace this in-memory storage with a relational or NoSQL database for better data persistence and scalability.

### In-Memory Data Structure

The primary data structure used in this application is a `List` of `UrlHitCounterEntity` objects. Each `UrlHitCounterEntity` object represents a visitor and their hit count. This structure allows for easy manipulation of hit counts but is not suitable for long-term data storage.

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlHitCounterEntity {
    private String userName;
    private Integer count;
}
```

## Data Structures Used

### List

The application utilizes the Java `List` data structure to maintain a collection of `UrlHitCounterEntity` objects. This dynamic data structure allows for the storage and retrieval of visitor hit counts. However, please note that this implementation is limited to in-memory storage and is not suitable for persisting data in a production environment.

```java
@Bean
public List<UrlHitCounterEntity> getUrlHitCounterList(){
    return new ArrayList<>();
}
```

### UrlHitCounter Class

The `UrlHitCounterEntity` class defines the structure for storing visitor information. It includes two fields: `userName` (to identify the visitor) and `count` (to track the hit count for that visitor). Instances of this class are used to represent visitors and manage their hit counts.

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlHitCounterEntity {
    private String userName;
    private Integer counter;
}
```


## Endpoints

### Get Total Hit Count
- **Endpoint**: `/api/v1/count`
- **HTTP Method**: GET
- **Description**: Retrieves the total hit count for the default URL.

### Get Hit Count for a Specific User
- **Endpoint**: `/api/v1/username/{username}/count`
- **HTTP Method**: GET
- **Description**: Retrieves the hit count for a specific user identified by `{username}`.

### Add a New Visitor
- **Endpoint**: `/visitor`
- **HTTP Method**: POST
- **Description**: Adds a new visitor to the system.

### Get All Visitors
- **Endpoint**: `/visitors`
- **HTTP Method**: GET
- **Description**: Retrieves a list of all visitors and their hit counts.

### Get the Number of Visitors
- **Endpoint**: `/visitor/count`
- **HTTP Method**: GET
- **Description**: Retrieves the total number of visitors.

### Increment Hit Count for a Specific User
- **Endpoint**: `/api/v1/count_update/username/{username}`
- **HTTP Method**: PUT
- **Description**: Increments the hit count for a specific user identified by `{username}`.

## Usage

1. Use a tool like [Postman](https://www.postman.com/) to make HTTP requests to the provided endpoints.

2. Create visitors using the "Add a New Visitor" endpoint with a POST request.

3. Retrieve hit counts and manage visitors using the provided endpoints.

## Project Structure

The project follows a standard Spring Boot application structure with components organized into layers:

- **Controller:** Handles incoming HTTP requests and defines API endpoints.
- **Service:** Implements business logic and interacts with the repository.
- **Repository:** Manages data access and storage.
- **Entity:** Defines data models.
- **BeanManager:** Contains Spring bean configurations.

## Data Storage

Visitor hit counts are stored in-memory using a `List`. In a production environment, you should consider using a database for data persistence.

## Contributing

Contributions to this project are welcome! If you have any suggestions, find issues, or want to enhance the functionality, please feel free to open an issue or submit a pull request.

<!-- License -->
## License
This project is licensed under the [GNU General Public License v3.0](LICENSE).

<!-- Acknowledgments -->
## Acknowledgments
Thank you to the Spring Boot and Java communities for providing excellent tools and resources.

<!-- Contact -->
## Contact
For questions or feedback, please contact [Sourav Das](mailto:sourav12212@gmail.com).
