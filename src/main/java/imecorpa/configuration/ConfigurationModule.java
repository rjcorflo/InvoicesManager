package imecorpa.configuration;

import com.google.inject.AbstractModule;

/**
 * Created by Solus on 03/01/2017.
 */
public class ConfigurationModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(Configuration.class).to(InMemoryConfiguration.class).asEagerSingleton();
    }
}
