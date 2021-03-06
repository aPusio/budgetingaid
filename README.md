# home budget aid

Prototype of sample app managing home budget.

## Requirements

For building and running the application you need:
- JDK 11
- Maven 3

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method
in the `com.pusio.example.budgetingaid.BudgetingAidApplication` class from your IDE.

Alternatively you can use
the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html)
like so:

```shell
mvn spring-boot:run
```

## Possible areas to improve

- proper exception handling, better messages and correct statuses in case of any exceptions
- size or format of all data is not validated