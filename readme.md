# kafkamongodb-api
Apache Kafka and MongoDB use case

First, run ``docker compose up -d`` to set the environment up

Then, run the MainApplication class

Finally, you can test it by using Postman (or any tool like that) or just go to ``localhost:8080/messages``

The request body is a MessageRequest object like this 

~~~ 
{
    message: "Hello, Kafka!"
}
~~~

Mongo GUI at ``http://localhost:8081`` so you can see the messages sent with Kafka stored at MongoDB

### Docker instructions

``mvn clean package``

``docker build -t kafkamongodb-api .``

``docker run -d kafkamongodb-api``