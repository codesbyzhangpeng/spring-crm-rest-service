# spring-crm-rest-service
Customer Relationship Manager Rest API/Service

Basic about Spring RESTful Web Service: http://www.zhangpeng-chen.com/2019/07/21/restful-web-service/

Development process: 

-> Add Maven dependency for Spring MVC and Jackson Project (spring-mvc, jackson-databind, servlet-api, servlet.jsp-api)
-> Add code for all java config: @Configuration, @EnableMvc, @ComponentScan
-> Add code for all java config: Servlet Initializer
-> Create a new POJO class e.g. Customer.java and populate them with a list of Customer
-> Create Spring Rest Service using @RestController
-> Create a database and populate the table with a few customers
-> Test the app with postman:
  1 - Get a list of customers
  2 - Get a customer using PathVariable for REST Endpoints
  2 - Add a new customer
  3 - Update an existing customer
  4 - Delete an existing customer
-> Exception handling (CustomerNotFoundException) with @ExceptionHandler
-> Global Exception Handling with @ControllerAdvice

Details: http://www.zhangpeng-chen.com/2019/07/21/spring-rest-support/
