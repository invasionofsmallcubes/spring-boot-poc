# Example of RabbitMQ on Spring Boot training to reproduce exactly-once behavior using Spring Cloud Stream

To run the example:
`make run-example`

And in another terminal run:
`make run-batch`

Then remove `spring.cloud.stream.bindings.<channel>.group` to see the different behavior.

References:
- [Introduction to Spring Cloud Stream](https://www.baeldung.com/spring-cloud-stream)
- [Spring Cloud Stream Reference Guide](https://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/#consumer-groups)
