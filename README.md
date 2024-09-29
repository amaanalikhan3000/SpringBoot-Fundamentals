
# Transactional Annotation in Spring Boot Example and @EnableTransactionManagement

## Description

This project demonstrates how to manage transactions in Spring Boot using the `@Transactional` annotation and `@EnableTransactionManagement`. It explains the usage of the `PlatformTransactionManager` to handle transaction boundaries in a Spring application, ensuring data consistency and integrity.


## Technologies Used
- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Maven


### Prerequisites
- Ensure you have Java 17+ installed.
- Have a working database (e.g., MySQL, PostgreSQL) and the corresponding JDBC driver.
- Install Maven for dependency management.

### Steps

1. **Clone the repository**

   ```bash
   git clone https://github.com/yourusername/Transactional-SpringBoot-Demo.git
   cd Transactional-SpringBoot-Demo
   ```

2. **Configure Database Connection**

   Modify the `application.yml` file to include your database connection details:

   ```properties
   spring:
    data:
        mongodb:
            database: journaldb
            host: localhost
            port: 27017
            auto-index-creation: true
   ```

3. **Run the application**

   ```bash
   mvn spring-boot:run
   ```

   Alternatively, build and run the JAR file:

   ```bash
   mvn clean install
   java -jar target/transactional-springboot-demo.jar
   ```

## Usage

This project illustrates how to manage transactions in your Spring Boot application using the `@Transactional` annotation. Transactions are essential for ensuring that a series of operations either complete successfully or rollback in case of failure.

### Example Code

#### Enable Transaction Management

To enable transaction management, you need to add the `@EnableTransactionManagement` annotation to your main application class:

```java
@SpringBootApplication
@EnableTransactionManagement
public class TransactionalDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransactionalDemoApplication.class, args);
    }
}
```

#### Using @Transactional

You can annotate your service methods with `@Transactional` to indicate that they should run within a transaction:

```java
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void createUser(User user) {
        userRepository.save(user);
        // Other operations can be added here, and they will all be part of the same transaction.
    }
}
```

#### PlatformTransactionManager

Spring provides the `PlatformTransactionManager` interface, which is responsible for managing transactions. The `@Transactional` annotation uses this manager to manage transaction boundaries.

You can define a `PlatformTransactionManager` bean in your configuration class if needed:

```java
@Bean
public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
}
```

## Features

- Demonstrates the use of `@Transactional` for managing transactions in Spring Boot.
- Illustrates how to enable transaction management with `@EnableTransactionManagement`.

# Transactional Annotation in Spring Boot Example and @EnableTransactionManagement

## Description

This project demonstrates how to manage transactions in Spring Boot using the `@Transactional` annotation and `@EnableTransactionManagement`. It explains the usage of the `PlatformTransactionManager` to handle transaction boundaries in a Spring application, ensuring data consistency and integrity.


## Technologies Used
- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Maven


### Prerequisites
- Ensure you have Java 17+ installed.
- Have a working database (e.g., MySQL, PostgreSQL) and the corresponding JDBC driver.
- Install Maven for dependency management.

### Steps

1. **Clone the repository**

   ```bash
   git clone https://github.com/yourusername/Transactional-SpringBoot-Demo.git
   cd Transactional-SpringBoot-Demo
   ```

2. **Configure Database Connection**

   Modify the `application.yml` file to include your database connection details:

   ```properties
   spring:
    data:
        mongodb:
            database: journaldb
            host: localhost
            port: 27017
            auto-index-creation: true
   ```

3. **Run the application**

   ```bash
   mvn spring-boot:run
   ```

   Alternatively, build and run the JAR file:

   ```bash
   mvn clean install
   java -jar target/transactional-springboot-demo.jar
   ```

## Usage

This project illustrates how to manage transactions in your Spring Boot application using the `@Transactional` annotation. Transactions are essential for ensuring that a series of operations either complete successfully or rollback in case of failure.

### Example Code

#### Enable Transaction Management

To enable transaction management, you need to add the `@EnableTransactionManagement` annotation to your main application class:

```java
@SpringBootApplication
@EnableTransactionManagement
public class TransactionalDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransactionalDemoApplication.class, args);
    }
}
```

#### Using @Transactional

You can annotate your service methods with `@Transactional` to indicate that they should run within a transaction:

```java
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void createUser(User user) {
        userRepository.save(user);
        // Other operations can be added here, and they will all be part of the same transaction.
    }
}
```

#### PlatformTransactionManager

Spring provides the `PlatformTransactionManager` interface, which is responsible for managing transactions. The `@Transactional` annotation uses this manager to manage transaction boundaries.

You can define a `PlatformTransactionManager` bean in your configuration class if needed:

```java
@Bean
public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
}
```

## Features

- Demonstrates the use of `@Transactional` for managing transactions in Spring Boot.
- Illustrates how to enable transaction management with `@EnableTransactionManagement`.
