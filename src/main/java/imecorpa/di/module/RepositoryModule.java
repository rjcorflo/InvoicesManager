package imecorpa.di.module;

import com.google.inject.AbstractModule;
import imecorpa.model.repositories.RepositoryClient;
import imecorpa.model.repositories.sqlite.RepositoryClientSqlite;

/**
 * Created by Solus on 03/01/2017.
 */
public class RepositoryModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(RepositoryClient.class).to(RepositoryClientSqlite.class).asEagerSingleton();
    }
}
