package de.networkchallenge.howto.canary.frontend;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class LocalSvgResourceTest {

    @Test
    void svgRect() {
        given()
                .when().get("/local/svg/RECTANGLE/1")
                .then()
                .statusCode(200)
                .body(containsString("<rect width=\"200\" height=\"100\" style=\"fill:green;\" />"));
    }

    @Test
    void svgCircle() {
        given()
                .when().get("/local/svg/CIRCLE/1")
                .then()
                .statusCode(200)
                .body(containsString("<circle cx=\"50\" cy=\"50\" r=\"40\" stroke=\"green\" stroke-width=\"3\" fill=\"green\" />"));
    }

    @Test
    void jsonRect() {
        given()
                .when().get("/local/json/RECTANGLE/1")
                .then()
                .statusCode(200)
                .body(containsString("<rect width=\\\"200\\\" height=\\\"100\\\" style=\\\"fill:green;\\\" />"));
    }

    @Test
    void jsonSvg() {
        given()
                .when().get("/local/json/CIRCLE/1")
                .then()
                .statusCode(200)
                .body(containsString("<circle cx=\\\"50\\\" cy=\\\"50\\\" r=\\\"40\\\" stroke=\\\"green\\\" stroke-width=\\\"3\\\" fill=\\\"green\\\" />"));
    }
}