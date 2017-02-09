package imecorpa.configuration;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by Solus on 02/01/2017.
 */
class InMemoryConfiguration implements Configuration
{
    private Properties prop = new Properties();

    InMemoryConfiguration() throws URISyntaxException {
        prop.setProperty("databaseUrl", "C:\\Workspace\\JavaProjects\\libraries\\InvoicesManagerDatabase\\imecorpa.db");
    }

    public void setValue(String name, String value) {
        prop.setProperty(name, value);
    }

    public String getValue(String name) {
        return prop.getProperty(name);
    }

    public String getValue(String name, String defaultValue) {
        return prop.getProperty(name, defaultValue);
    }
}
