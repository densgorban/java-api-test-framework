package io.github.dens.api;

import io.github.dens.config.ConfigurationManager;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

/**
 * @author dens.gorban
 */

public class ApiBase {

    public static RequestSpecification api() {
        RequestSpecification request = RestAssured.given()
                .baseUri(ConfigurationManager.config().baseUrl());
        return request;
    }
}
