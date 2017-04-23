package imecorpa.service;

import com.google.inject.AbstractModule;
import imecorpa.service.logger.LoggerModule;
import imecorpa.service.translator.TranslatorModule;

/**
 * Created by RJ Corchero on 23/04/2017.
 */
public class ServicesModules extends AbstractModule {
    @Override
    protected void configure() {
        install(new LoggerModule());
        install(new TranslatorModule());
    }
}
