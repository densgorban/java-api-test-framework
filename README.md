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
> - Make sure API response Ɵme is not less then 3 seconds then current Ɵme in second.
>   - Timestamp is returned in the API response.
> - Verify that 162 currency pairs are retuned by the API.
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
3. Import the project in [IntelliJ IDEA](https://www.jetbrains.com/idea/download/).
4. Make your desired changes.
5. Use IntelliJ IDEA to run your desired tests. Alternatively, you can use the terminal to run the tests, for example 
```./gradlew test -Dbrowser=firefox -Dheadless=false```
6. Build and browse the allure report using
```
./gradlew allureServe
```

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
      
- ### Test Data
  The project uses *csv* file to store test data and [*univocity-parsers*](https://github.com/uniVocity/univocity-parsers) to retrieve the data and map it to a Java bean.

  To add configurations for new test data, add a new Java bean in the [*dto*](./src/main/java/io/github/dens/dto) package. For example, let's say I want to add test data for a `User` with the attributes `First Name` and `Last Name`. The code for this is as follows:

   ```java
   package io.github.dens.dto;

   import com.univocity.parsers.annotations.Parsed;

   import lombok.Getter;
   import lombok.ToString;

   @Getter
   @ToString(callSuper = true)
   public class UserDto extends BaseDto {

       @Parsed(field = "First Name", defaultNullRead = "")
       private String firstName;

       @Parsed(field = "Last Name", defaultNullRead = "")
       private String lastName;
   }
   ```
   Note that the class extends from BaseDto and thus, inherits the attribute `Test Case ID`.

   Now, in the [*testdata*](./src/test/resources/testdata) folder you can add a csv file `currency.csv` for `USD` with the below contents and use it in your tests.
   ```
   Test Case ID,First Name,Last Name
   TC-1,Tahanima,Chowdhury
   ```
   For reference, check [this](./src/main/java/io/github/dens/dto/CurrencyDto.java)

- ### Page Objects and Page Component Objects
  The project uses [*Page Objects* and *Page Component Objects*](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/) to capture the relevant behaviors of a web page. Check the [*ui*](./src/main/java/io/github/dens/ui) package for reference.

- ### Tests
  The project uses *JUnit 5* as the test runner. Check [this implementation](./src/test/java/io/github/dens/e2e/LoginTest.java) for reference.
