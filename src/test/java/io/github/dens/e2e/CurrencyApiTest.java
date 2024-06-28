package io.github.dens.e2e;

import io.github.dens.annotations.Smoke;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import io.github.dens.api.ApiBase;
import org.junit.jupiter.api.Test;

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

        response.then().statusCode(201);

    }
}
