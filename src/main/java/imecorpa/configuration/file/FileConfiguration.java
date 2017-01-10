package imecorpa.configuration.file;

import imecorpa.configuration.Configuration;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by Solus on 02/01/2017.
 */
public class FileConfiguration implements Configuration
{
    private Properties prop = new Properties();

    private File propFile;

    public FileConfiguration() throws URISyntaxException {
        URL url = getClass().getResource("/configuration/config.properties");
        propFile = new File(url.toURI());
        if (!propFile.exists()) {
            try {
                propFile.createNewFile();
            } catch (Exception e) {
                System.out.println("Error loading");
            }
        }

        this.load();
    }

    public void setValue(String name, String value) {
        prop.setProperty(name, value);
        this.store();
    }

    public String getValue(String name) {
        this.load();
        return prop.getProperty(name);
    }

    public String getValue(String name, String defaultValue) {
        this.load();
        return prop.getProperty(name, defaultValue);
    }

    protected void load() {
        InputStream input = null;

        try {
            input = new FileInputStream(propFile);

            // load a properties file
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void store() {
        OutputStream output = null;
        try {
            output = new FileOutputStream(propFile);

            // Save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
