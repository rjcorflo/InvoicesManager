package imecorpa.service.logger;

import com.google.inject.AbstractModule;

/**
 * Guice Module for Logger Service.
 */
public class DevLoggerModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(LoggerService.class).to(LoggerInformation.class).asEagerSingleton();
    }
}
