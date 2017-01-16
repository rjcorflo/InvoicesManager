package imecorpa.di.modules;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import imecorpa.app.client.ClientModule;
import imecorpa.configuration.ConfigurationModule;
import imecorpa.di.services.logger.LoggerModule;
import imecorpa.di.services.translator.TranslatorModule;
import imecorpa.model.repositories.RepositoryModule;

import javax.inject.Singleton;

/**
 * Created by RJ Corchero on 11/01/2017.
 */
public class ProductionModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(EventBus.class).in(Singleton.class);
        install(new ConfigurationModule());
        install(new LoggerModule());
        install(new TranslatorModule());
        install(new RepositoryModule());
        install(new ClientModule());
    }
}
