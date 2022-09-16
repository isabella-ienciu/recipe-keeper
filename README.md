# 🍰 Recipe Keeper

Recipe keeper is a personal app for storing recipes. It's a project mainly used for learning various technologies.
Currently includes a postgres db, a backend implemented using Java and Spring and a frontend implemented using Angular. They can all be started inside docker containers.

## Prerequisites

You must install: docker, java, maven, npm, angular

## Installation
### V1: Start database inside docker container and start frontend and backend applications locally

To create a docker container with the postgres database, run the following commands inside the **recipe-keeper-db-docker** folder:
1. To build the docker image:
```bash
docker build -t recipe-postgres .
```
2. To create the container using the image:
```bash
docker run -d --name recipe-keeper-db -p 5555:5432 recipe-postgres
```
3. To start the container:
```bash
docker start recipe-keeper-db
```
4. To run spring boot app locally: (after starting db on docker)
```bash
mvn spring-boot:run
```
5. To start angular app locally: 
```bash
ng serve 
```

### V2: Start database, frontend and backend inside docker container with docker compose
Docker compose defines a multi-container application; the application will take the name of the folder containing docker-compose.yml
- in db folder: 
``` bash
docker build -t recipe-postgres .      # build db docker image
```
- in backend folder: 
``` bash
mvn clean install -DskipTests          # build jar
docker build -t recipe-api-spring .    # build backend docker image
```
- in frontend folder: 
``` bash
docker build -t recipe-keeper-ui .    # build frontend docker image
```
- in main folder: 
``` bash
docker-compose up -d --build          # starts and rebuilds all apps
# OR
docker-compose up -d --build recipe-keeper-api   # starts all apps, rebuilds only the one mentioned
docker-compose start
docker-compose stop
docker-compose down                   # deletes all containers (and app containing them)
```
## References
- This article was used when setting up the db container:
<https://wkrzywiec.medium.com/database-in-a-docker-container-how-to-start-and-whats-it-about-5e3ceea77e50>
