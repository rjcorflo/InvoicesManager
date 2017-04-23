package imecorpa.configuration;

import com.google.inject.AbstractModule;

public class DevConfigurationModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(Configuration.class).to(InMemoryConfiguration.class).asEagerSingleton();
    }
}
