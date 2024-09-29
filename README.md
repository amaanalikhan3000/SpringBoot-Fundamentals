# Spring Boot API with `ResponseEntity`

This project demonstrates how to use `ResponseEntity` in a Spring Boot application to return various HTTP status codes based on different scenarios, such as `OK`, `Created`, `Bad Request`, `Not Found`, and `No Content`.

## How It Works

The `ResponseEntity` class in Spring Boot provides the flexibility to define both the response body and the HTTP status code. Below are common response scenarios implemented in this project:

### HTTP Response Scenarios

1. **404 Not Found**: When a requested resource is not available, the server returns `HttpStatus.NOT_FOUND`.

    ```java
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    ```

    Example:
    ```bash
    GET /api/entries/{id}
    Response: 404 Not Found
    ```

2. **201 Created**: When a new resource is created, the server returns `HttpStatus.CREATED` along with the created resource.

    ```java
    return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
    ```

    Example:
    ```bash
    POST /api/entries
    Response: 201 Created
    ```

3. **400 Bad Request**: When invalid data is submitted, the server returns `HttpStatus.BAD_REQUEST`.

    ```java
    return new ResponseEntity<>(myEntry, HttpStatus.BAD_REQUEST);
    ```

    Example:
    ```bash
    POST /api/entries (invalid data)
    Response: 400 Bad Request
    ```

4. **200 OK**: When the requested resource is successfully retrieved, the server returns `HttpStatus.OK`.

    ```java
    return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
    ```

    Example:
    ```bash
    GET /api/entries/{id}
    Response: 200 OK
    ```

5. **204 No Content**: When a resource is successfully deleted, the server returns `HttpStatus.NO_CONTENT`.

    ```java
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    ```

    Example:
    ```bash
    DELETE /api/entries/{id}
    Response: 204 No Content
    ```
