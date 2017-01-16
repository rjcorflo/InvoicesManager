package imecorpa.app.client;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Created by RJ Corchero on 16/01/2017.
 */
public class ClientModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ClientContext.class).in(Singleton.class);
    }
}
