package imecorpa.configuration;

/**
 * Contains methods to change and retrieve basic configuration about the application.
 */
public interface Configuration {
    /**
     * Set a configuration value.
     *
     * @param identifier Identifier of one configuration value.
     * @param value Value to save.
     */
    void setValue(String identifier, String value);

    /**
     * Check if a value exists.
     *
     */
    boolean hasValue(String name);

    /**
     * Retrieve a configuration value.
     *
     * @param identifier Identifier of one configuration value.
     * @return Value to be retrieved. Null if not exists.
     */
    String getValue(String identifier);

    /**
     * Retrieve a configuration value or a default one if not exists.
     *
     * @param identifier Identifier of one configuration value.
     * @param defaultValue A default value no be returned if value not exists.
     * @return Value to be retrieved or default if not exists.
     */
    String getValue(String identifier, String defaultValue);
}
