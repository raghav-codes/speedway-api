# Readme

This repository contains the code for Spring boot application which can be executed
in three environments listed below.

1) Standalone application in  any java IDE
2) Docker container.
3) Heroku cloud platform.

## API Specifications

please refer RESTDOCS End point link
https://speedway-api.herokuapp.com/docs/index.html

## Instructions for Execution in Docker container hosted in your local desktop( windows Powershell)

### List of commands - Define the network and add the postgres as well as springboot application container to the network

    docker pull postgres
    docker network create --driver bridge speednetwork
    docker run --name my-speedpostgres --network speednetwork  -e POSTGRES_PASSWORD=open -e POSTGRES_DB=speeddb -p 5432:5432  -d  postgres
    docker build -t speedservice:dev .
    docker run --name speed1   --network speednetwork  -e PORT=8080  -e SPRING_PROFILES_ACTIVE=docker   -p 1000:8080  -d  speedservice:dev

## Instruction for Heroku 
    $ heroku login
    $ heroku container:login
    $ heroku container:push web
    $ heroku container:release web

Finally verified the Herokuwebapp

https://speedway-api.herokuapp.com/driver - post a driver and also get the list of drivers
https://speedway-api.herokuapp.com/raceevent - post a racevent and also get the list of evenys




