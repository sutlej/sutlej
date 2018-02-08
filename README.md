<div align="center" style="margin: 20px">
  <img src="https://github.com/sutlej/sutlej/raw/master/banner.jpeg">
</div>

## How to run on local without an IDE
- Run `../mvnw spring-boot:run` inside `backend` folder.
- Run `../mvnw frontend:install-node-and-yarn frontend:yarn` inside `frontend` folder.
- Start the frontend using `yarn start`.

## How to run on local using an IDE
- Run the `Application` file to run the Spring Boot backend in any IDE
- Run `yarn start` in the `frontend` folder to start the frontend. This should open a browser window with the main page.

## How to generate and use jar
- Run `./mvnw clean install` inside the `sutlej` directory. This will build both frontend and backend.
- Run the jar: `java -jar backend/target/backend-0.1.0-SNAPSHOT.jar`
- The application will be accessible at `http://localhost:8080`

---
**Note:** The boilerplate code was taken from [spring-boot-react-maven-starter](https://github.com/shekhargulati/spring-boot-react-maven-starter) by [@shekhargulati](https://github.com/shekhargulati).
