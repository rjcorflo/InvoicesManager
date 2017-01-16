package imecorpa.di.services.logger;

import com.google.inject.AbstractModule;

/**
 * Guice Module for Logger Service.
 */
public class LoggerModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(LoggerService.class).to(LoggerInformation.class).asEagerSingleton();
    }
}
