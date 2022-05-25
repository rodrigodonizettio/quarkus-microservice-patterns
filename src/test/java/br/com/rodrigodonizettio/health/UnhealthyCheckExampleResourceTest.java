package br.com.rodrigodonizettio.health;

import br.com.rodrigodonizettio.profile.UnhealthyTestProfile;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
@TestProfile(UnhealthyTestProfile.class)
public class UnhealthyCheckExampleResourceTest {
    @Test
    public void assertReadinessIsDownTest() {
        given()
                .when().get("/q/health")
                .then()
                    .statusCode(503)
                    .body(containsString("\"name\": \"myAppNameReadiness\",\n            \"status\": \"DOWN\""));
    }
}