package imecorpa.model.repositories;

import com.google.inject.AbstractModule;

/**
 * Created by Solus on 03/01/2017.
 */
public class DevRepositoryModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(RepositoryClient.class).to(RepositoryClientInMemory.class).asEagerSingleton();
    }
}
