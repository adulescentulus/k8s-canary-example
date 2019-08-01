package de.networkchallenge.howto.canary.rectangle;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

@QuarkusTest
class LocalSvgResourceTest {

    @Test
    void svgRect() {
        RestAssured.given()
                .when().get("/local/svg/RECTANGLE/1")
                .then()
                .statusCode(200)
                .body(CoreMatchers.containsString("<rect width=\"200\" height=\"100\" style=\"fill:blue;\" />"));
    }

    @Test
    void svgCircle() {
        RestAssured.given()
                .when().get("/local/svg/CIRCLE/1")
                .then()
                .statusCode(200)
                .body(CoreMatchers.containsString("<circle cx=\"50\" cy=\"50\" r=\"40\" stroke=\"green\" stroke-width=\"3\" fill=\"green\" />"));
    }

    @Test
    void jsonRect() {
        RestAssured.given()
                .when().get("/local/json/RECTANGLE/1")
                .then()
                .statusCode(200)
                .body(CoreMatchers.containsString("<rect width=\\\"200\\\" height=\\\"100\\\" style=\\\"fill:blue;\\\" />"));
    }

    @Test
    void jsonSvg() {
        RestAssured.given()
                .when().get("/local/json/CIRCLE/1")
                .then()
                .statusCode(200)
                .body(CoreMatchers.containsString("<circle cx=\\\"50\\\" cy=\\\"50\\\" r=\\\"40\\\" stroke=\\\"green\\\" stroke-width=\\\"3\\\" fill=\\\"green\\\" />"));
    }
}