package io.github.dens.api;

import io.github.dens.config.ConfigurationManager;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.params.HttpConnectionParams;

import java.io.PrintStream;

/**
 * @author dens.gorban
 */
@Slf4j
public class ApiBase {

    /**
     *
     * @return
     */
    public static RequestSpecification api() {
        HttpClientConfig httpClientConfig = HttpClientConfig.httpClientConfig()
                .setParam(HttpConnectionParams.CONNECTION_TIMEOUT, 60000)
                .setParam(HttpConnectionParams.SO_TIMEOUT, 60000);
        LogConfig logConfig = LogConfig.logConfig()
                .enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)
                .enablePrettyPrinting(true);
        RestAssuredConfig config = RestAssured.config()
                .httpClient(httpClientConfig)
                .logConfig(logConfig);

        return RestAssured.given().config(config)
                .baseUri(ConfigurationManager.config().baseUrl())
                .relaxedHTTPSValidation();
    }
}
