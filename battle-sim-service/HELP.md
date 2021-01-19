# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.pokemaster.Pokemon-Microservices' is invalid and this project uses 'com.pokemaster.PokemonMicroservices' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.8.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.8.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#using-boot-devtools)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring for RabbitMQ](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-amqp)
* [WebSocket](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-websockets)
* [Java Mail Sender](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-email)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#production-ready)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-security)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-developing-web-applications)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Messaging with RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq/)
* [Using WebSocket to build an interactive web application](https://spring.io/guides/gs/messaging-stomp-websocket/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Service Registration and Discovery](https://spring.io/guides/gs/service-registration-and-discovery/)
* [Routing and Filtering](https://spring.io/guides/gs/routing-and-filtering/)
* [Circuit Breaker](https://spring.io/guides/gs/circuit-breaker/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)

# Spring Cloud Netflix Maintenance Mode

The dependencies listed below are in maintenance mode. We do not recommend adding them to
new projects:

*  Zuul
*  Hystrix
*  Hystrix Dashboard

The decision to move most of the Spring Cloud Netflix projects to maintenance mode was
a response to Netflix not continuing maintenance of many of the libraries that we provided
support for.

Please see [this blog entry](https://spring.io/blog/2018/12/12/spring-cloud-greenwich-rc1-available-now#spring-cloud-netflix-projects-entering-maintenance-mode)
for more information on maintenance mode and a list of suggested replacements for those
libraries.
