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


### Controller

The Controller layer is responsible for handling incoming HTTP requests and delegating them to the appropriate services. It defines API endpoints for various operations, including add job description's data,fetch data,update data,delete data. Each endpoint maps to a specific service method to ensure proper request handling and response generation.

```java
@RestController
public class JobController {
    @Autowired
    JobService jobService;


```

### Service

The Service layer encapsulates the core business logic and data processing. It interacts with the Repository layer to retrieve and store data. In this application, it handles operations like adding new data, retrieving data, and updating data. The Service layer validates input data and performs necessary operations before returning results to the Controller.

```java
@Service
public class JobService {
    @Autowired
    IJobRepo jobRepo;


```

### Repository

Though I use H2-database , so there is a parent interface "CrudRepository" where I can fetch all methods that present in this interface.

```java
@Repository
public interface IJobRepo extends CrudRepository<Job,Long> {
//some code
}
```

##### CRUD Operations

## Using Inbuilt CrudRepository Methods


## Create
- *Endpoint*: `\jobs`
- *HTTP Method*: POST
- *Example Request Body*:
  ```
   {
        "id": 1,
        "title": "Software Engineer",
        "description": "Developing and maintaining software applications.",
        "location": "New York",
        "salary": 20000.0,
        "companyEmail": "hr@company.com",
        "companyName": "Tech Solutions Inc.",
        "employerName": "John Doe",
        "jobType": "IT",
        "appliedDate": "2023-09-24"
    }
  ```

## Read
- *Endpoint*: `\job`
- *HTTP Method*: GET
- *Example Get All body*:
  ```
   {
        "id": 1,
        "title": "Software Engineer",
        "description": "Developing and maintaining software applications.",
        "location": "New York",
        "salary": 20000.0,
        "companyEmail": "hr@company.com",
        "companyName": "Tech Solutions Inc.",
        "employerName": "John Doe",
        "jobType": "IT",
        "appliedDate": "2023-09-24"
    }
  ```


## Update
- *Endpoint*: `job/id/location`
- *HTTP Method*: PUT
- *Description*: `Update job location by id`.

## Delete
- *Endpoint*:`job/id/{id}`
- *HTTP Method*: DELETE
- *Description*: `Delete some id which i pass through the PathVariable`.

## Custom Get Methods using Custom Finders

- Custom finder methods allow querying based on specific criteria.

Custom Finder 1

- *Endpoint*: `jobs/company/name/{companyName}`
- *HTTP Method*: GET
- *Description*: `get all jobs with same company name`.

  Custom Finder 2

- *Endpoint*: `job/type/{type}/salary/lessOrEqual/{salary}`
- *HTTP Method*: GET
- *Description*: `get all jobs by type less than or equal to some given salary`.

## Custom Queries (Update and Delete) using @Query

- Custom queries allow writing SQL queries for specific operations.
Custom Update Query
- *Endpoint*: `job/salary/{hike}/type/{type}`
- *HTTP Method*: PUT
- *Description*: `update the salary of this type which i provide by the PathVariable`.

Custom Delete Query
- *Endpoint*: `job/delete/description`
- *HTTP Method*: DELETE
- *Description*: ```{
    "description" : "Developing and maintaining software applications."
}
```   


## Project Structure

The project follows a standard Spring Boot application structure with components organized into layers:

- **Controller:** Handles incoming HTTP requests and defines API endpoints.
- **Service:** Implements business logic and interacts with the repository.
- **Repository:** Manages data access and storage.
- **Entity:** Defines data models.


## Run the Application
- Clone this repository.
- Open the project in your favorite IDE.
- Build and run the application.

<!-- Contact -->
## Contact
For questions or feedback, please contact [Sourav Das](mailto:sourav12212@gmail.com).
