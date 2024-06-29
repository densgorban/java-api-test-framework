# Otakoyi Technical task using Java and RestAssured

> Given the API: https://open.er-api.com/v6/latest/USD
> Returns the USD rates against multiple currency.

> #### Task
> 
> - Create a test framework using Java/JVM language framework.
>   ***BDD approach would be an added advantage.***
> 
> - Write necessary tests to cover the acceptance criteria below. 
> 
> - Make sure code is modular and easily understood.
> 
> - Structure the code properly so that we can make changes easier.
> 
> - Upload the solution in bitbucket/GitHub and share the link of the repo
> - Include a README.md file.

> #### Acceptance criteria
> - API call is successful and returns valid price.
> - Check the status code and status is returned by the API response.
>   - API could return multiple statuses like SUCCESS, FAILURE etc. Make sure this is
    catered for.
> - Fetch the USD price against the AED and make sure the prices are in range on 3.6 – 3.7
> - Make sure API response time is not less then 3 seconds then current Ɵme in second.
>   - Timestamp is returned in the API response.
> - Verify that 162 currency pairs are returned by the API.
> - Make sure API response matches the Json schema
>   - Generate a schema from the API response.

## Features

- Configuration-based architecture
- Data-Driven (DDD)
- Behaviour-Driven (BDD)
- Automatic API logging
- Provides detailed test report
- Supports parallel test execution

## Installation Steps

In order to use the framework:

1. [Clone](https://github.com/densgorban/playwright-java) the repository.
```
git clone https://github.com/densgorban/playwright-java.git
```
2. Import the project in [IntelliJ IDEA](https://www.jetbrains.com/idea/download/).
3. Make your desired changes.
4. Use IntelliJ IDEA to run your desired tests. Alternatively, you can use the terminal to run the tests, for example 
```./gradlew test -Dtag=Smoke```
5. Build and browse the allure report using
```./gradlew allureServe```

## Languages and Frameworks

The project uses the following:
- *[Java 11](https://openjdk.java.net/projects/jdk/11/)* as the programming language.
- *[RestAssured](https://rest-assured.io/)* as the web browser automation framework using the Java binding.
- *[Univocity Parsers](https://www.univocity.com/pages/univocity_parsers_tutorial)* to parse and handle CSV files.
- *[JUnit 5](https://junit.org/junit5/)* as the testing framework.
- *[Lombok](https://projectlombok.org/)* to generate getters.
- *[Owner](http://owner.aeonbits.org/)* to minimize the code to handle properties file.
- *[Allure Report](https://qameta.io/allure-report/)* as the test reporting strategy.
- *[Gradle](https://gradle.org/)* as the Java build tool.
- *[IntelliJ IDEA](https://www.jetbrains.com/idea/)* as the IDE.

## Project Structure

The project is structured as follows:

```bash
📦 playwright-java-test-automation-architecture
├─ .github
│  ├─ FUNDING.yml
│  ├─ dependabot.yml
│  └─ workflows
│     └─ test-execution.yml
├─ .gitignore
├─ LICENSE
├─ README.md
├─ build.gradle
├─ gradle
│  └─ wrapper
│     ├─ gradle-wrapper.jar
│     └─ gradle-wrapper.properties
├─ gradlew
├─ gradlew.bat
├─ settings.gradle
└─ src
   ├─ main
   │  └─ java
   │     └─ io
   │        └─ github
   │           └─ dens
   │              ├─ config
   │              │  ├─ Configuration.java
   │              │  └─ ConfigurationManager.java
   │              ├─ dto
   │              │  ├─ BaseDto.java
   │              │  └─ ProductsDto.java
   │              ├─ ui
   │              │  ├─ component
   │              │  │  ├─ BaseComponent.java
   │              │  │  ├─ Header.java
   │              │  │  └─ SideNavMenu.java
   │              │  └─ api
   │              │     ├─ ApiBase.java
   │              └─ util
   └─ test
      ├─ java
      │  └─ io
      │     └─ github
      │        └─ dens
      │           ├─ annotation
      │           │  ├─ DataSource.java
      │           │  ├─ Regression.java
      │           │  ├─ Smoke.java
      │           ├─ e2e
      │           │  ├─ CurrencyApiTest.java
      │           └─ util
      │              ├─ CsvToDtoMapper.java
      │              └─ DataArgumentsProvider.java
      └─ resources
         ├─ allure.properties
         ├─ config.properties
         ├─ junit-platform.properties
         └─ testdata
            └─ currency.csv
```

## Basic Usage

- ### Configuration
  The project uses a [*config.properties*](./src/test/resources/config.properties) file to manage global configurations such as browser type and base url.
  
  1. To add a new property, register a new entry in this file.
      ```
      key=value
      ```
    
      Then, add a method in the [*Configuration*](./src/main/java/io/github/dens/config/Configuration.java) interface in the below format.
      ```java
      @Key("key")
      dataType key();
      ```
    
      For example, let's say I want to add a new property named `context` with the value `dev`. In the `config.properties` file, I'll add:
      ```
      context=dev
      ```
    
      In the `Configuration` interface, I'll add:
      ```java
      @Key("context")
      String context();
      ```
    
      To use your newly created property, you need to use the below import statement.
      ```java
      import static io.github.dens.config.ConfigurationManager.config;
      ```
    
      Then, you can call `config().key()` to retrieve the value of your newly created property. For the example I've provided, I need to call `config().context()`.

  2. You can supply the properties present in the `config.properties` file as system properties in your test via gradle.
      ```bash
      ./gradlew test -Dkey1=value1 -Dkey2=value2
      ```
