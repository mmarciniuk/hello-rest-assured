# REST Assured

Website: http://rest-assured.io/

## What is REST Assured
REST Assured is a _Java_ based framework for testing API. 
Thanks to DSL design (Domain Specific Language) creating a test with this framework is very easy and descriptive.
Example:
```
given().headers(defaultHeaders).when().get("/pet/0").then().statusCode(HttpStatus.SC_OK);
```
## Requirements
To use REST Assured following prerequisites need to be meet:
* knowledge of _Java_
* knowledge of _Maven_
* knowledge of _TestNG_ (or _JUnit_)
* some IDE (for eg. IntelliJ IDEA)
* JDK installed

## Step by step
This example use API Petstore https://petstore.swagger.io/

1. Create maven project
2. Add properties to maven:
```xml
<properties>
    <maven.compiler.target>1.8</maven.compiler.target>
    <maven.compiler.source>1.8</maven.compiler.source>
</properties>
```
These [properties](https://mkyong.com/maven/how-to-tell-maven-to-use-java-8/) will tell maven to use _Java_ in version _1.8_.

3. Add dependencies to maven:
```xml
<dependencies>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.0.0</version>
        <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>org.hamcrest</groupId>
        <artifactId>hamcrest-all</artifactId>
        <version>1.3</version>
        <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.8.6</version>
        <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>com.jayway.restassured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>2.9.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

4. Next we can create [abstract class for Petstore test(s)](src/test/java/pl/mm/helloRestAssured/PetStoreBaseTest.java)
5. Now w can create class [PetStoreTests](src/test/java/pl/mm/helloRestAssured/test/pet/PetStoreTests.java) which will contains tests for few endpoints of this API.
   1. testAddPet
   2. testUpdatePet
   3. testGetPetById
   4. findByStatus

As we can notice tests created in REST Assured are very self self-descriptive.

## Useful links
* https://javastart.pl/baza-wiedzy/testy-automatyczne-rest-assured/zanim-zaczniesz-automatyzowac
