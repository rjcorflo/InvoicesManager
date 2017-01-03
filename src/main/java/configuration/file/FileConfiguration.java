package configuration.file;

import configuration.Configuration;

import java.io.*;
import java.util.Properties;

/**
 * Created by Solus on 02/01/2017.
 */
public class FileConfiguration implements Configuration
{
    private Properties prop = new Properties();

    public FileConfiguration() {
        File file = new File("config.properties");
        if (!file.exists()) {
            try {
                file.createNewFile();
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
            input = new FileInputStream("config.properties");

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
            output = new FileOutputStream("config.properties");

            // save properties to project root folder
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
