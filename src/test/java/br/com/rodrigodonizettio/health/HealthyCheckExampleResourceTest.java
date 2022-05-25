package br.com.rodrigodonizettio.health;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class HealthyCheckExampleResourceTest {

    @Test
    public void assertReadinessIsUpTest() {
        System.setProperty("healthcheck.readiness.endpoint", "https://github.com/rodrigodonizettio");

        given()
          .when().get("/q/health")
          .then()
             .statusCode(200)
             .body(containsString("\"name\": \"myAppNameReadiness\",\n            \"status\": \"UP\""));
    }
}
