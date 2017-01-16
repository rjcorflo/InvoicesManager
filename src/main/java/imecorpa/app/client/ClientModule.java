package imecorpa.app.client;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Guice Module for Client Section.
 */
public class ClientModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ClientContext.class).in(Singleton.class);
    }
}
