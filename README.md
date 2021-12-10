# spring-security-practice
This is a practice project of Spring Security JWT token Authentication and Authorization

Simple Spring Security demo using jwt token based authentication by the following YouTube video:
https://www.youtube.com/watch?v=VVn9OG9nfH0&t=6000s&ab_channel=Amigoscode


#Run App using Docker Compose
* To build Docker Compose

`docker compose build`

* To run Docker Compose

`Docker compose up`

You need to create a database userservice inside MySQL container to avoid communication link failure



##Dokcer Commands
The app can be run using the following docker commands

1. Create mysql container

`docker run --name test-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=test -e MYSQL_USER=katsu -e MYSQL_PASSWORD=root -d mysql`

2. Create custom network

` docker network create spring-security-demo-network`

3. docker connect the custom network to the db along with it's db name

`docker network connect spring-net test-mysql`

5. building docker image for app

`docker build . -t app`

7. create a container and run app inside the container
Make sure specify the network using --net commands as well as environment variables as specified in the application properties folder

8. run app 
`docker run -p 8080:8080 --name spring-sec-app --net spring-security-demo-network -e DB_HOSTNAME=spring-demo-mysql -e DB_USER=root -e DB_PASSWORD=root -e DB_PORT=3306 spring-security-demo`


* Make sure you bash into mysql containr and create db as follows
1. Bash into MySQL container 
`docker exec -it [container_id] bash`
3. login
`mysql -u root -p`
4. Create db
`create database userservice;`

* To check container's network state

`Docker container inspect [container_name]`



