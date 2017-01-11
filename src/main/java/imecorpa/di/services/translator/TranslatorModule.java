package imecorpa.di.services.translator;

import com.google.inject.AbstractModule;

/**
 * Created by RJ Corchero on 11/01/2017.
 */
public class TranslatorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TranslatorService.class).to(TranslatorResource.class).asEagerSingleton();
    }
}
