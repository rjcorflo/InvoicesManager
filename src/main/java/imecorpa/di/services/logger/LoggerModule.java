package imecorpa.di.services.logger;

import com.google.inject.AbstractModule;

/**
 * Created by RJ Corchero on 11/01/2017.
 */
public class LoggerModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(LoggerService.class).to(LoggerInformation.class).asEagerSingleton();
    }
}
