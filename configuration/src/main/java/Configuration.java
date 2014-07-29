import org.apache.commons.configuration.CombinedConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConversionException;
import org.apache.commons.configuration.DefaultConfigurationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by borshtei on 28-Jul-14.
 *
 */
public class Configuration {

    public static final String CONFIG_XML = "config.xml";
    private final Logger logger = LoggerFactory.getLogger(Configuration.class);
    private CombinedConfiguration configuration;

    public final static Configuration INSTANCE = new Configuration();

    private Configuration() {
        try {
            DefaultConfigurationBuilder defaultConfigurationBuilder = new DefaultConfigurationBuilder(CONFIG_XML);
            configuration = defaultConfigurationBuilder.getConfiguration(true);
        } catch (ConfigurationException e) {
            logger.error("can't load configuration from " + CONFIG_XML, e);
        }
    }

    /**
     * Get a string associated with the given configuration key.
     * If the key doesn't map to an existing object, the default value
     * is returned.
     *
     * @param key          The configuration key.
     * @param defaultValue The default value.
     * @return The associated string if key is found and has valid
     * format, default value otherwise.
     */
    public String getString(String key, String defaultValue) {
        String value;
        try {
            value = configuration.getString(key, defaultValue);
        } catch (ConversionException e) {
            logger.warn("can't find configuration value for " + key + ", using default " + defaultValue);
            value = defaultValue;
        }
        return value;
    }

    /**
     * Get an {@link Integer} associated with the given configuration key.
     * If the key doesn't map to an existing object, the default value
     * is returned.
     *
     * @param key          The configuration key.
     * @param defaultValue The default value.
     * @return The associated int if key is found and has valid format, default
     * value otherwise.
     */
    public Integer getInteger(String key, Integer defaultValue) {
        Integer value;
        try {
            value = configuration.getInteger(key, defaultValue);
        } catch (ConversionException e) {
            logger.warn("can't find configuration value for " + key + ", using default " + defaultValue);
            value = defaultValue;
        }
        return value;

    }


}
