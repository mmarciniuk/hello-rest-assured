package pl.mm.helloRestAssured;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;
import java.util.Map;

public abstract class PetStoreBaseTest {

    protected String host = "http://petstore.swagger.io";
    protected int port = 80;
    protected String basePath = "/v2";
    protected Map<String, Object> defaultHeaders = new HashMap<String, Object>() {{
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
