package di.module;

import com.google.inject.AbstractModule;
import model.repositories.RepositoryClient;
import model.repositories.sqlite.RepositoryClientSqlite;

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
