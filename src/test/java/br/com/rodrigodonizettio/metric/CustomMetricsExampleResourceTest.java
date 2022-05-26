package br.com.rodrigodonizettio.metric;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class CustomMetricsExampleResourceTest {
    @Test
    void assertMyCountedCustomMetricsDoesExistTest() {
        given()
            .when().get("/q/metrics/application")
            .then()
            .statusCode(200)
            .body(containsString("application_br_com_rodrigodonizettio_metric_CustomMetricsExampleResource_myCounted"));
    }

    @Test
    void assertMyTimedCustomMetricsDoesExistTest() {
        given()
                .when().get("/q/metrics/application")
                .then()
                .statusCode(200)
                .body(containsString("application_br_com_rodrigodonizettio_metric_CustomMetricsExampleResource_myTimed"));
    }
}
