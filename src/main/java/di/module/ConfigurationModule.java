package di.module;

import com.google.inject.AbstractModule;
import configuration.Configuration;
import configuration.file.FileConfiguration;

/**
 * Created by Solus on 03/01/2017.
 */
public class ConfigurationModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(Configuration.class).to(FileConfiguration.class).asEagerSingleton();
    }
}
