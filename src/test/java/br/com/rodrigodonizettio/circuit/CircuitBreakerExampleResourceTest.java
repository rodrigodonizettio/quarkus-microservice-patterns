package br.com.rodrigodonizettio.circuit;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class CircuitBreakerExampleResourceTest {

    @Test
    public void assertCircuitWillOpenDueSleepTimeHigherThanTimeoutTest() {
        given()
          .when().get("/circuit/1100")
          .then()
             .statusCode(200)
             .body(containsString("'circuitFallback' method called at:"), containsString("when 'sleepTime is:"));
    }

    @Test
    public void assertCircuitWontOpenDueSleepTimeLessThanTimeoutTest() {
        given()
                .when().get("/circuit/900")
                .then()
                .statusCode(200)
                .body(containsString("Everything is ok!"));
    }
}