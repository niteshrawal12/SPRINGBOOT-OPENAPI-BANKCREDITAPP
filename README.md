# SPRINGBOOT-OPENAPI-BANKCREDITAPP
# Camunda, Spring Boot, and OpenAPI Integration Example

This is a sample project that demonstrates the integration of Camunda BPM, Spring Boot, and OpenAPI. The project includes a RESTful web service API for managing bank credits and utilizes Camunda BPM for process execution.

## Prerequisites

- Java JDK 17 or higher
- Maven
- MySQL database
- Camunda Run (for the Camunda engine)

## Getting Started

1. **Clone the Repository**:
   git clone https://github.com/niteshrawal12/SPRINGBOOT-OPENAPI-BANKCREDITAPP.git
2. **Database Setup**:
Set up a MySQL database and configure the connection details in src/main/resources/application.properties.
Run Camunda Run:
3. **Download Camunda Run from Camunda's website.**
Start Camunda Run using the provided batch or shell script.
Run the Spring Boot Application:
4. **Build and run the Spring Boot application using Maven**:
mvn spring-boot:run

5. **Access the Camunda Web Interface**:

Open your web browser and go to http://localhost:8080 to access the Camunda web interface. Deploy your BPMN diagrams and start process instances here.
Access the OpenAPI Documentation:

Open your web browser and go to http://localhost:8080/swagger-ui.html to access the OpenAPI documentation generated by Springdoc.

6. **Project Structure**
src/main/java/com/openapi/example: Contains the main application files.

BankCredit: Entity class representing bank credit information.
BankCreditRepository: Spring Data JPA repository for accessing bank credit data.
BankCreditController: REST controller for managing bank credits.
ServiceTaskDelegate: Camunda service task delegate for handling credit processes.
src/main/resources: Contains application configuration and resource files.

application.properties: Configuration for database connection.
src/main/webapp: Contains the webapp resources for Camunda (if applicable).

7. **Testing**
The project includes unit tests for various components:

BankCreditControllerTest: Tests for the REST controller.
ServiceTaskDelegateTest: Tests for the Camunda service task delegate.


