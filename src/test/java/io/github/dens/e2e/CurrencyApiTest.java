package io.github.dens.e2e;

import io.github.dens.annotations.Smoke;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import io.github.dens.api.ApiBase;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;

/**
 * @author dens.gorban
 */

public class CurrencyApiTest {

    @Smoke
    @Story("Currency API Tests")
    @Owner("Denys Gorban")
    @Description("Test that verifies user GETs a list USD currency pairs")
    @Test
    public void getCurrencyTest() {

        Response response = ApiBase.api().when().get("/USD");

        response.then().assertThat()
                .statusCode(200)
                .body("result", is("success"))
                .body("rates.AED", allOf(greaterThan(3f),lessThan(4f)))
                .body("rates.size()", is(162))
                .body(matchesJsonSchemaInClasspath("schema/currency-schema.json"))
                .time(lessThanOrEqualTo(3000L));
        ;



    }
}
