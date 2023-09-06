# Getting Started with Spring Boot

Welcome to the "Getting Started with Spring Boot" project! This project provides a simple and comprehensive guide to help you set up a Spring Boot application with Hibernate, JPA (Java Persistence API) and PostgreSQL as the database.

## Prerequisites

Before you begin, ensure you have the following prerequisites installed on your system:

1. **Java Development Kit (JDK)**: You need Java SE 8 or higher installed. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-downloads.html) or use OpenJDK.

2. **Gradle**: Install Gradle to manage project dependencies.

3. **PostgreSQL Database**: You can download and install PostgreSQL from the [official website](https://www.postgresql.org/download/). Make sure to have a PostgreSQL server up and running. You can use any other RDBMS or H2 as well .

## Setup Instructions

Follow these steps to get started with the project:

1. **Clone the Repository**:

    ```bash
    git clone https://github.com/shishku/Sample.git
    cd Sample
    ```

2. **Configure Database Connection**:

   Open the `src/main/resources/application.properties` file and update the database connection properties according to your PostgreSQL setup:
   
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/your-database
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    ```
 
3. **Build the Project**:

   Run the following command to build the project using Maven:

    ```bash
   ./gradlew bootRun
    ```

4. **Run the Application**:

   Start the Spring Boot application by running:

    ```bash
    java -jar target/sample.jar
    ```

5. **Access the Application**:

   Open your web browser and go to [http://localhost:8080](http://localhost:8080) to access the application.


## Using MariaDB or MySQL

This project is initially configured to use PostgreSQL, but you can easily adapt it to work with MariaDB or MySQL. Follow these steps to switch to MariaDB or MySQL:

### Switching to MariaDB or MySQL

1. **Install MariaDB or MySQL**: If you haven't already, install MariaDB or MySQL on your system. You can download MariaDB from [here](https://mariadb.org/download/) or MySQL from [here](https://dev.mysql.com/downloads/).

2. **Create a Database**: Using the MariaDB or MySQL command-line client or a graphical tool, create a new database for your Spring Boot application.

3. **Open the `src/main/resources/application.properties` File**: Locate the `application.properties` file in your project's resources directory.

4. **Update the Database Configuration**:

   - Replace the `spring.datasource.url` property with the appropriate JDBC URL for MariaDB or MySQL. Here are examples for both databases:

      - For MariaDB:

        ```properties
        spring.datasource.url=jdbc:mariadb://localhost:3306/your-database
        ```

      - For MySQL:

        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/your-database
        ```

   - Update `your-database` with the name of your database and ensure the host and port are correct.

   - Modify `spring.datasource.username` and `spring.datasource.password` with your MariaDB or MySQL credentials.

5. **Specify the Hibernate Dialect**:

   - MariaDB Dialect (for MariaDB):

     ```properties
     spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
     ```

   - MySQL Dialect (for MySQL):

     ```properties
     spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
     ```

6. **Save the Changes** to the `application.properties` file.

7. Your Spring Boot application is now configured to use MariaDB or MySQL as the database. Run your application as usual.

By following these steps, you can easily adapt this project to work with MariaDB or MySQL databases. Remember to replace placeholders like `your-database`, `your-username`, and `your-password` with your actual database information.

---

### Using H2 for Development or Testing

1. Open the `src/main/resources/application.properties` file.

2. Comment out or remove the following lines to disable the PostgreSQL configuration:

    ```properties
    # spring.datasource.url=jdbc:postgresql://localhost:5432/your-database
    # spring.datasource.username=your-username
    # spring.datasource.password=your-password
    # spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```

3. Uncomment or add the following lines to configure H2 as the in-memory database for development or testing:

    ```properties
    spring.datasource.url=jdbc:h2:mem:testdb
    spring.datasource.username=sa
    spring.datasource.password=password
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
    ```

   This configuration uses an in-memory H2 database, which is useful for development and testing. You can customize the `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` properties as needed.

Now, you can choose the database that suits your needs and update the configuration accordingly. Remember to adjust the JDBC URL, dialect, and other properties as required for the specific database you're using.
## Sample HTTP Requests
To interact with the Spring Boot API, you can use a sample .http file with example HTTP requests. Here's an example of how to use the .http file to make requests to your API:


- Open the `requests.http` File:

- Open the `requests.http` file provided in this repository using your code editor.

**Run Sample Requests** :

You can send requests directly from the .http file by clicking the "Send Request" button for each request. Make sure to replace placeholders like {{base_url}} with the appropriate values.
## Project Structure

The project follows a standard Spring Boot project structure:

- `src/main/java`: Contains the Java source code.
- `src/main/resources`: Contains configuration files, including the `application.properties` file for database configuration.
- `src/test`: Contains test classes and resources.

## Usage

This project serves as a basic template for building Spring Boot applications with Hibernate, JPA, and PostgreSQL. You can now start developing your application by adding your own entities, repositories, services, and controllers.

## Contributing

Feel free to contribute to this project by opening issues or submitting pull requests. Your contributions are welcome!

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Hibernate](https://hibernate.org/)
- [Java Persistence API (JPA)](https://javaee.github.io/javaee-spec/javadocs/javax/persistence/package-summary.html)
- [PostgreSQL](https://www.postgresql.org/)

Happy coding!