package imecorpa.service.translator;

import imecorpa.App;

import java.util.ResourceBundle;

/**
 * Implements the translation of strings using a Resource Bundle.
 */
class TranslatorResource implements TranslatorService
{
    private ResourceBundle resourceBundle;

    TranslatorResource() {
    }

    @Override
    public String translate(String key, Object... args) {
        if (resourceBundle == null || !App.getLocale().equals(resourceBundle.getLocale())) {
            resourceBundle = ResourceBundle.getBundle("bundles.localization.strings", App.getLocale());
        }

        return String.format(resourceBundle.getString(key), args);
    }
}
