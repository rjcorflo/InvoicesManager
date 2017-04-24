package imecorpa.model.repositories;

import com.google.inject.AbstractModule;
import imecorpa.model.repositories.RepositoryClient;
import imecorpa.model.repositories.RepositoryClientSqlite;

/**
 * Guice Module for Logger Service.
 */
public class RepositoryModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(RepositoryClient.class).to(RepositoryClientInMemory.class).asEagerSingleton();
    }
}
