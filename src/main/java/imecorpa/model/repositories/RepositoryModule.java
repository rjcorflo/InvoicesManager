package imecorpa.model.repositories;

import com.google.inject.AbstractModule;
import imecorpa.model.repositories.RepositoryClient;
import imecorpa.model.repositories.RepositoryClientSqlite;

/**
 * Created by Solus on 03/01/2017.
 */
public class RepositoryModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(RepositoryClient.class).to(RepositoryClientInMemory.class).asEagerSingleton();
    }
}
