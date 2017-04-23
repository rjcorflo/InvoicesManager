package imecorpa.configuration;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

/**
 * Simple {@link Configuration} implementation.
 *
 * Data only is stored during execution.
 */
class InMemoryConfiguration implements Configuration
{
    private Properties properties = new Properties();

    InMemoryConfiguration() throws URISyntaxException {
        this.setValue("databaseUrl", "C:\\Workspace\\JavaProjects\\libraries\\InvoicesManagerDatabase\\imecorpa.db");
        this.setValue("databaseUrl", "");
    }

    public void setValue(String name, String value) {
        this.properties.setProperty(name, value);
    }

    public String getValue(String name) {
        return this.properties.getProperty(name);
    }

    public String getValue(String name, String defaultValue) {
        return this.properties.getProperty(name, defaultValue);
    }
}
