package configuration;

/**
 * Created by Solus on 02/01/2017.
 */
public interface Configuration {
    public void setValue(String name, String value);
    public String getValue(String name);
    public String getValue(String name, String defaultValue);
}
