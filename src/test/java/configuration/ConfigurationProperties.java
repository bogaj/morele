package configuration;

import java.util.Properties;

public class ConfigurationProperties {

    private static Properties properties;

    private ConfigurationProperties() {
    }

    public static void setProperties(Properties properties) {
        ConfigurationProperties.properties = properties;
    }

    public static Properties getProperties() {
        if (properties == null) {
            throw new IllegalStateException("Sprawdź ustawienia setProperties() przed wywołaniem getProperties()");
        }
        return properties;
    }
}

