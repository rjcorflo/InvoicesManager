package imecorpa.model.repositories;

import com.google.inject.AbstractModule;

/**
 * Guice Development Module for Logger Service.
 */
public class DevRepositoryModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(RepositoryClient.class).to(RepositoryClientInMemory.class).asEagerSingleton();
    }
}
