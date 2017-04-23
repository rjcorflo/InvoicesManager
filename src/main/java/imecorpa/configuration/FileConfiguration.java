package imecorpa.configuration;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

class FileConfiguration implements Configuration {
    private Properties properties = new Properties();

    private File propertiesFile;

    FileConfiguration() throws URISyntaxException {
        URL url = getClass().getResource("/configuration/config.properties");
        this.propertiesFile = new File(url.toURI());
        if (!this.propertiesFile.exists()) {
            try {
                this.propertiesFile.createNewFile();
            } catch (Exception e) {
                System.out.println("Error loading");
            }
        }

        this.load();
    }

    @Override
    public void setValue(String name, String value) {
        this.properties.setProperty(name, value);
        this.store();
    }

    @Override
    public boolean hasValue(String name) {
        return this.properties.containsKey(name);
    }

    @Override
    public String getValue(String name) {
        this.load();
        return this.properties.getProperty(name);
    }

    @Override
    public String getValue(String name, String defaultValue) {
        this.load();
        return this.properties.getProperty(name, defaultValue);
    }

    private void load() {
        try (InputStream input = new FileInputStream(this.propertiesFile)) {
            // Load a properties file
            this.properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void store() {
        try (FileOutputStream output = new FileOutputStream(this.propertiesFile)) {
            // Save properties to project root folder
            this.properties.store(output, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
