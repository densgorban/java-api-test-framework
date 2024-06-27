package io.github.dens.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.Sources;

/**
 * @author dens.gorban
 */
@LoadPolicy(Config.LoadType.MERGE)
@Sources({"system:properties", "classpath:config.properties", "classpath:allure.properties"})
public interface Configuration extends Config {

    @Key("allure.results.directory")
    String allureResultsDir();

    @Key("base.url")
    String baseUrl();

    @Key("base.test.data.path")
    String baseTestDataPath();

    @Key("base.test.video.path")
    String baseTestVideoPath();

    int timeout();

}
