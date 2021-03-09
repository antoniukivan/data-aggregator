# Data Aggregator

Service for manipulating the database for machines by endpoints or load data from CSV file to the database.   
Service is designed to work with large CSV files. I showed it in my tests where I saved one million records
to the database in less than 50 ms.  

### REST API

http://localhost:8080 - Data Aggregator Service API url.

|             Web API               |  HTTP  |           endpoint             |
|-----------------------------------|:------:|:------------------------------:|
|Add machine to the database        |POST    |/machines                       |
|Get machine by id                  |GET     |/machines/id                    |
|Update machine by id               |PUT     |/machines/id                    |
|Get number of machines by model    |GET     |/machines?model="some-model"    |
|Get all machines by owner          |GET     |/machines/by-owner?owner="owner"|
|Get all machine models by attribute|GET     |/machines/models?attribute="info"|


### Built with

- Java 8  
- Hibernate
- H2 Database   
- Spring Boot   
- JUnit 4   
- Lombok   
- OpenCSV   

### To start you need:
1. Setup connection with your DataBase
- spring.datasource.user="your-username"
- spring.datasource.password="your-password"
- spring.datasource.driverClassName="your-db-driver"
- spring.datasource.url: jdbc:mysql://"your-host-name":"your-port"/"your-name-db"?useUnicode=true&serverTimezone=UTC
2. Run   
3. Enter the CSV file path into the input console   
4. Enter 'START' to load data from CSV file to your database.
 
