package io.github.dens.config;

import org.aeonbits.owner.ConfigCache;

/**
 * @author dens.gorban
 */
public final class ConfigurationManager {

    private ConfigurationManager() {}

    public static Configuration config() {
        return ConfigCache.getOrCreate(Configuration.class);
    }
}
