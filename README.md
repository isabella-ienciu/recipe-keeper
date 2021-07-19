# 🍰 Recipe Keeper

Recipe keeper is a personal app for storing recipes. It's a project mainly used for learning various technologies.

Currently it incorporates a postgres database stored inside a docker container and a _just started_ REST Service implemented using Spring.

## Prerequisites

You must install: docker, java, maven.

## Installation

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
## References
- This article was used when setting up the db container:
<https://wkrzywiec.medium.com/database-in-a-docker-container-how-to-start-and-whats-it-about-5e3ceea77e50>