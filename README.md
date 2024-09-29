# MongoDB Relationships in Spring Boot: @DBRef Annotation

## Description
This project demonstrates how to manage relationships in MongoDB using Spring Boot, with a focus on the @DBRef annotation for linking collections seamlessly. It serves as a guide for implementing relational-like behavior in NoSQL databases, making it easier to reference documents in separate collections.

MongoDB doesn’t support foreign key relationships natively like traditional SQL databases. However, with the help of the @DBRef annotation in Spring Boot, we can link documents between collections to establish relationships, ensuring consistency and simplifying queries.

### Technologies Used
- Java 17+

- Spring Boot 3.x

- MongoDB

- Spring Data MongoDB

- Maven


## Installation

### Prerequisites
- Ensure you have Java 17+ and MongoDB installed.
- Install Maven for dependency management.


### Steps

1. Clone the repository

   ```bash
   git clone https://github.com/yourusername/MongoDB-SpringBoot-DBRef-Demo.git
   cd MongoDB-SpringBoot-DBRef-Demo
   ```

2. Configure MongoDB

   Modify the `application.properties` file to include your MongoDB connection details:

   ```properties
   spring.data.mongodb.host=localhost
   spring.data.mongodb.port=27017
   spring.data.mongodb.database=mydatabase
   ```

3. Run the application

   ```bash
   mvn spring-boot:run
   ```

   Alternatively, build and run the JAR file:

   ```bash
   mvn clean install
   java -jar target/mongodb-springboot-dbref-demo.jar
   ```

