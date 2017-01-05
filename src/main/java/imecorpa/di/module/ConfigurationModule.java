package imecorpa.di.module;

import com.google.inject.AbstractModule;
import imecorpa.configuration.Configuration;
import imecorpa.configuration.file.FileConfiguration;
import imecorpa.di.services.logger.LoggerInformation;
import imecorpa.di.services.logger.LoggerService;
import imecorpa.di.services.translator.TranslatorResource;
import imecorpa.di.services.translator.TranslatorService;

/**
 * Created by Solus on 03/01/2017.
 */
public class ConfigurationModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(Configuration.class).to(FileConfiguration.class).asEagerSingleton();
        bind(LoggerService.class).to(LoggerInformation.class).asEagerSingleton();
        bind(TranslatorService.class).to(TranslatorResource.class).asEagerSingleton();
    }
}
