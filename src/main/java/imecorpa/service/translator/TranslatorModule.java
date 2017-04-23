package imecorpa.service.translator;

import com.google.inject.AbstractModule;

/**
 * Guice Module for Translator Service.
 */
public class TranslatorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TranslatorService.class).to(TranslatorResource.class).asEagerSingleton();
    }
}
