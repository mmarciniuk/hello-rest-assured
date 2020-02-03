package pl.mm.helloRestAssured.test.pet;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import pl.mm.helloRestAssured.PetStoreBaseTest;

import java.util.UUID;

import static com.jayway.restassured.RestAssured.given;

public class PetStoreTests extends PetStoreBaseTest {

    private static final String SESSION_ID = UUID.randomUUID().toString();
    private static long createdPetId;

    @Test
    public void testAddPet() {
        createdPetId = given().sessionId(SESSION_ID)
                .headers(defaultHeaders)
                .header("Content-Type", "application/json")
                .cookies(cookies)
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .post("/pet")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().path("id");
    }

    @Test(dependsOnMethods = {"testAddPet"})
    public void testUpdatePet() {
        given().sessionId(SESSION_ID)
                .headers(defaultHeaders)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .cookies(cookies)
                .body("name=newName&status=available")
                .post("/pet/" + createdPetId)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = {"testAddPet"})
    public void testGetPetById() {
        given().sessionId(SESSION_ID)
                .headers(defaultHeaders)
                .when().get("/pet/" + createdPetId)
                .then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void findByStatus() {
        given().sessionId(SESSION_ID)
                .headers(defaultHeaders)
                .cookies(cookies)
                .pathParam("status", "available")
                .when()
                .get("/pet/findByStatus?status={status}")
                .then().statusCode(HttpStatus.SC_OK);
    }

}
