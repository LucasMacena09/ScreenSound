# ScreenSound

ScreenSound is a Spring Boot application for managing singers and their songs.

## Features

- Register singers as solo, duo, or band.
- Add songs for each singer.
- List all songs.
- List songs for a specific singer.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL, PostgreSQL, or other SQL databases

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven
- Your preferred SQL database (e.g., MySQL, PostgreSQL)

### Installation

1. **Clone the repository:**

```bash
git clone https://github.com/your-username/screensound.git
cd screensound
```

2. **Configure the database:**

Set up the application.properties file with your database credentials.
Run the provided SQL script to create the necessary tables.

3. **Run the application:**

You can run the application using Maven:

```bash
./mvnw spring-boot:run
```

Or build a JAR package and run it:

```bash
./mvnw clean package
java -jar target/screensound-0.0.1-SNAPSHOT.jar
```

Using the application:

The application runs in the console. You can interact with it using command-line prompts.

Example usage:

```bash
Copy code
java -jar target/screensound-0.0.1-SNAPSHOT.jar
```
This will start the console application where you can manage your movie soundtracks and music.

## Contributing
Contributions are welcome! If you'd like to contribute, please follow these steps:

1. Fork the project
2. Create a branch for your feature (git checkout -b feature/MyFeature)
3. Commit your changes (git commit -am 'Add MyFeature')
4. Push to the branch (git push origin feature/MyFeature)
5. Open a Pull Request
