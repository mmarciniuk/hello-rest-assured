package pl.mm.helloRestAssured;

import com.jayway.restassured.RestAssured;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;
import java.util.Map;

public abstract class PetStoreBaseTest {

    @Value("{restassured.baseHost:http://petstore.swagger.io}")
    protected String host = "http://petstore.swagger.io";
    @Value("${restassured.port:80}")
    protected int port = 80;
    @Value("${restassured.basePath:/v2}")
    protected String basePath = "/v2";
    protected Map<String, Object> defaultHeaders = new HashMap<String, Object>(){{
        put("accept", "application/json");
    }};
    protected Map<String, Object> cookies = new HashMap<>();

    @BeforeSuite
    public void setUpRestAssuredForPetStore() {
        RestAssured.baseURI = host;
        RestAssured.port = port;
        RestAssured.basePath = basePath;
    }

}
