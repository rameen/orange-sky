# Retail App Store
The retail app exposes a set of api to fetch products details, which includes title
and price and update price details

## Software Stack
* Dropwizard - 2.0.0
  - The Dropwizard framework provides the basic skeleton for building the backend application.
* MongoDB - 4.0.0
  - MongoDB was chosen because it fulfills the NoSQL data store requirement.It has been used to store price details of the products and serves as source for price details.

* Junit- 4.13
* Apache Maven - 3.6.1
* Java Version - 8

## Build Steps
Go the source code directory and run following commands

`mvn clean install`

`java -jar target/orange-sky-1.0-SNAPSHOT.jar server app-config.yml`

These commands will start your application at 8080 port.
Start MongoDB in your local setup

## API
#### Fetch Price Details:
This service tries to call target endpoint (redsky) for product title and retrieves price information from the MongoDB.
The response for product id `12345679` for title has been hardcoded.It assumes that price information is present in the DB.  

Request :

GET /products/{id}

Response

`status : 200`

`{
    "id": 12345679,
    "title": "Dummy Product Title",
    "current_price": {
        "value": 400.0,
        "currency": "USD"
    }
}`

#### Update Price Details:
This service updates the prices of an existing product in the MongoDB.It is only responsible for updating the price of an exsiting product.
Request:

POST /products

`{
     "productId":12345679,
     "price":500,
     "currency":"USD"
 }`
 
Response:

`status: 200`

`{
     "productId":12345679,
     "price":500,
     "currency":"USD"
 }`

#### HealthCheck Api

This service can be used to check the health of the backend application

Request:

GET localhost:8081/healtcheck

Response:

`{
     "data": {
         "healthy": true,
         "message": "The Orange Sky Application is healthy ",
         "duration": 0,
         "timestamp": "2020-09-18T14:07:19.581+05:30"
     } 
}`
 
#### Error Message Structure
`status: http status error code`

`{
     "code": 500/404,
     "message": "Something went wrong/Resource Not Found"
 }`
 
 
 #### Test Cases
 To run the test cases execute the following command
 `mvn test`
 
 ###### Test Coverage till date.
 ![](test-coverage/testcoverage.png)
 
 #### Postman Collection
 The collection can be accessed [here](https://www.getpostman.com/collections/d260e0bfae44b349fbd7)






