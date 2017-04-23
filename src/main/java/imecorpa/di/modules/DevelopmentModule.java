package imecorpa.di.modules;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import imecorpa.configuration.DevConfigurationModule;
import imecorpa.model.repositories.DevRepositoryModule;
import imecorpa.service.DevServicesModules;

import javax.inject.Singleton;

/**
 * Guice Module for Production Environment.
 * <p>
 * Combines all other modules to create the App Object Graph.
 */
public class DevelopmentModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(EventBus.class).in(Singleton.class);
        install(new DevConfigurationModule());
        install(new DevServicesModules());
        install(new DevRepositoryModule());
    }
}
