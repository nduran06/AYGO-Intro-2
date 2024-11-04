# Introduction to Virtualization and Distributed Programming - Part 2

## Summary

In this lab a cloud application is built using AWS, and where: A basic Java user registration application runs in a Docker microcontainer on an EC2 machine; within this machine, there is another microcontainer containing the Mongo database, with which the application interacts; In order to access this EC2 machine, an API Gateway was created with Springboot and is deployed on another EC2 machine.

## Prerequisites

## Features

#### Java
```
Versión de JAVA: 17
```

#### Docker Image
```
```
### Database Config

#### MongoDB container

1. In your EC2 machine create a mongo-init.js file, with this content:

```
db.createUser(
        {
            user: "<Database user username>",
            pwd: "<Database user password>",
            roles: [
                {
                    role: "readWrite",
                    db: "<Database name to create>"
                }
            ]
        }
);

```

2. In the same folder where you created the mongo-init.js file, create the docker-compose.yml with this content:

```
services:
    mongodb:
        image: mongo:latest
        container_name: <Docker container name>
        restart: always
        environment:
            MONGO_INITDB_ROOT_USERNAME: <Database user username>
            MONGO_INITDB_ROOT_PASSWORD: <Database user password>
            MONGO_INITDB_DATABASE: <Database name to create>
        ports:
            - 27017:27017
        volumes:
            - ./mongo-init.js:/docker-entrypoint-initdb.d/mongo-init.js:ro

```
3. Create your container with Docker Compose:

```
docker-compose up --build -d mongodb

```

#### Code

1. Change the value of the URI attribute for the database connection to the corresponding data for the EC2 machine, in the application.properties file

```
mongodb://nduran06:aygopass123@ec2-54-205-104-132.compute-1.amazonaws.com:27017/?retryWrites=true&w=majority
```
![](imgs/config_uri.png)

This configuration follows these parameters:

![Connection URI](https://www.mongodb.com/docs/drivers/java/sync/v4.3/fundamentals/connection/connect/)(imgs/uri_config.png.png)

