package imecorpa.di.modules;

import com.google.inject.AbstractModule;
import imecorpa.configuration.ConfigurationModule;
import imecorpa.di.services.logger.LoggerModule;
import imecorpa.di.services.translator.TranslatorModule;
import imecorpa.model.repositories.RepositoryModule;

/**
 * Created by RJ Corchero on 11/01/2017.
 */
public class ProductionModule extends AbstractModule
{
    @Override
    protected void configure() {
        install(new ConfigurationModule());
        install(new LoggerModule());
        install(new TranslatorModule());
        install(new RepositoryModule());
    }
}
