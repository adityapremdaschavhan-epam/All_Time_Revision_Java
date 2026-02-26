package test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestingWithRestAssured
{
    @Test
    public void testGreeting() {
        baseURI = "https://reqres.in";

        when().
                get("/api/users/2").
                then().
                statusCode(403);
        // 403 means resources forbidden
    }
}
