package imecorpa.configuration;

/**
 * 
 */
public interface Configuration {
    /**
     *
     *
     * @param name
     * @param value
     */
    void setValue(String name, String value);

    /**
     *
     * @param name
     * @return
     */
    String getValue(String name);

    /**
     *
     * @param name
     * @param defaultValue
     * @return
     */
    String getValue(String name, String defaultValue);
}
