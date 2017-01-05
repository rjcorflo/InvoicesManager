package imecorpa.di.services.translator;

import imecorpa.App;

import java.util.ResourceBundle;

/**
 * Created by Solus on 05/01/2017.
 */
public class TranslatorResource implements TranslatorService
{
    protected ResourceBundle resourceBundle;

    @Override
    public String translate(String key) {
        if (resourceBundle == null || !App.getLocale().equals(resourceBundle.getLocale())) {
            resourceBundle = ResourceBundle.getBundle("bundles.localization.strings", App.getLocale());
        }

        return resourceBundle.getString(key);
    }
}
