# Applesoft rating system

## SETUP INSTRUCTIONS

1. Create applesoft database
2. Run sql script(rate_service.sql found in the project folder) to create rate_service table:
3. Run the following sql statement to limit the number of connections to the DB: set GLOBAL max_connections = 10
4. Build the project by doing: mvn clean compile package
5. Run the project by doing: mvn spring-boot:run
6. If you want to run the java is located in the target folder
6. Test the service: http://localhost:9005/swagger-ui.html

N.B rateService field can be e.g Happy, Bad etc