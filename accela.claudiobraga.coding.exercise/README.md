Accela Cláudio Braga Coding Exercise

Web Application to manage people. List, insert, edit, delete and counting.

Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

Prerequisites

To install, run and see functionalities working in this project is necessary the following software:
JDK 11 or above
Maven
Spring
Eclipse
MySQL
Postman

Build

mvn clean install

How to Run the Coding Exercise Application

Start as a Spring Boot Application


Running and see functionalities Working

Postman / Internet browser (GET, POST, PUT, DELETE)

http://localhost:8080/persons

http://localhost:8080/persons/1

http://localhost:8080/persons/count


Sample JSON on Postman
{
    "firstName": "Accc",
    "lastName": "Cela",
    "address": {
        "street": "Road",
        "city": "Dublin",
        "state": "Ireland",
        "postalCode": "N37 T23"
    }
}


Built With

Spring Framework

Maven - Dependency Management

JavaSE-11

Author
Cláudio Braga
