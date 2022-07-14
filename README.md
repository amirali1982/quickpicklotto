# Quick Pick Lotto Documentation

### Technical Stack / Considerations
- Spring boot
- OpenApi / Swagger
- Junit Tests

### Assumptions:

My assumptions are:

- A ticket contains a collection of unique games.
- A ticket can have between 4 and 50 games.
- QuickPick ticket is accessed by specifying the number of games using this URL: `http://localhost:8080/quickpick/5`
- A single game contains 7 unique numbers from 1-47.


### Building and Running this microservice

Clean Compile & build: `gradlew clean build`

Compile & build: `gradlew build`

Start Microservice: `gradlew bootRun`

### Accessing the microservice

Once started then use the browser to access:

Open Welcome Page: `http://localhost:8080/quickpick`

Generate games by specifying number of games. eg; `http://localhost:8080/quickpick/5`

### Postman Collection:

Find the postman collection in <root>/postman directory if you like to use postman to access the microservice.

### OpenApi / Swagger:

API Docs: `http://localhost:8080/api-docs/`

API Docs (yaml file): `http://localhost:8080/api-docs.yaml`

If you prefer using swagger ui instead of postman then you can access it here: `http://localhost:8080/swagger-ui/index.html`

