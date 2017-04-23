package imecorpa.service.translator;

import imecorpa.App;

import java.util.ResourceBundle;

/**
 * Implements the translation of sttring using a Resource Bundle.
 */
class TranslatorResource implements TranslatorService
{
    private ResourceBundle resourceBundle;

    TranslatorResource() {
    }

    @Override
    public String translate(String key) {
        if (resourceBundle == null || !App.getLocale().equals(resourceBundle.getLocale())) {
            resourceBundle = ResourceBundle.getBundle("bundles.localization.strings", App.getLocale());
        }

        return resourceBundle.getString(key);
    }
}
