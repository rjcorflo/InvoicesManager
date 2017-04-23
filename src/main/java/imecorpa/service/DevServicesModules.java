package imecorpa.service;

import com.google.inject.AbstractModule;
import imecorpa.service.logger.DevLoggerModule;
import imecorpa.service.translator.TranslatorModule;

/**
 * Created by RJ Corchero on 23/04/2017.
 */
public class DevServicesModules extends AbstractModule {
    @Override
    protected void configure() {
        install(new DevLoggerModule());
        install(new TranslatorModule());
    }
}
