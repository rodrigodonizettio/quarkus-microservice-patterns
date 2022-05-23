package br.com.rodrigodonizettio;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class ExternalizedConfigExampleResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/config")
          .then()
             .statusCode(200)
             .body(containsString("The 'external-config' key-property has value: externalizedValueExample"));
    }

}