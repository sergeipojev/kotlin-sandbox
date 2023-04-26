# Kotlin Sandbox

Given project was created to show the possibilities of Kotlin and to be able to try out Kotlin.
Project includes Togglz, MongoDb, Rest Controllers, Models, Services, Repositories, WebClient and RestTemplate to communicate with external API.
Just for example I was using Formula 1 public API to retrieve the data from the network.

### Formula 1 API
https://documenter.getpostman.com/view/11586746/SztEa7bL#intro

## Getting started
In order to try it out you will need
 - Java 17 installed
 - Mongo DB
 = Gradle support
 
To start, make sure MongoDB is running and all Gradle dependencies are resolved.

### Starting MongoDB

I have prepared docker-compose file to run MongoDB locally in docker. Docker compose file is located under local-setup

```
docker-compose -p [PROJECT_NAME] up -d

Where ...
-p: project name  
-d: detached mode
```

### Starting application
To start application you have to options. If you are using IDE, you can open a project in IDE and run ApiMvpApplication.kt.
Antoher way is to use gradle run. Run in project root directory
```
./gradlew bootRun
```
By default, application is available on port 8080: http://localhost:8080
You can change port in application.yml file

## Documentation

Currently there is available Swagger for application API.

### Swagger
Swagger is available on URL: http://localhost:8080/swagger-ui.html
NB! In case if you have changed port number, make sure to change it here too.


## Authors and acknowledgment
Sergei Pojev - sergei.pojev@gmail.com

## License
MIT License 

## Project status
Early stages, under construction.
