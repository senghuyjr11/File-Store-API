# File-Store-API

API project built with **Java**, **Spring Data JPA**, and **Gradle**.

## Overview

File-Store-API is a backend application that provides RESTful endpoints for managing file storage operations. It is designed to be fast, reliable, and easy to integrate into larger projects needing file persistence.

## Features

- CRUD operations for files  
- Relational data persistence using Spring Data JPA  
- Modular and scalable architecture  
- Built with Gradle for easy dependency management and builds

## Technologies Used

- Java  
- Spring Boot  
- Spring Data JPA  
- Gradle

## Getting Started

### Prerequisites

- Java 17+  
- Gradle 7+  
- (Optional) Docker

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/senghuyjr11/File-Store-API.git
   cd File-Store-API
   ```

2. **Build the project:**
   ```bash
   ./gradlew build
   ```

3. **Run the application:**
   ```bash
   ./gradlew bootRun
   ```

The API will start on `http://localhost:8080`.

### Docker (Optional)

You can also run the application using Docker:

```bash
docker build -t file-store-api .
docker run -p 8080:8080 file-store-api
```

## API Endpoints

> _Add details of your main endpoints here! Example:_

| Method | Endpoint            | Description           |
|--------|---------------------|----------------------|
| GET    | `/files`            | List all files       |
| POST   | `/files`            | Upload a new file    |
| GET    | `/files/{id}`       | Get file by ID       |
| PUT    | `/files/{id}`       | Update file metadata |
| DELETE | `/files/{id}`       | Delete a file        |

## Configuration

- Database settings can be adjusted in `src/main/resources/application.properties`.

## Contributing

1. Fork the repo  
2. Create your branch (`git checkout -b feature/fooBar`)  
3. Commit your changes (`git commit -am 'Add new feature'`)  
4. Push to the branch (`git push origin feature/fooBar`)  
5. Open a Pull Request

## License

This project is licensed under the MIT License.

## Author

[**senghuyjr11**](https://github.com/senghuyjr11)

---

> _Feel free to update this README with more details about your API’s endpoints, usage examples, or documentation links!_
