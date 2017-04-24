package imecorpa.service.translator;

/**
 * Methods to translate string on Java code.
 */
public interface TranslatorService
{
    /**
     * Get a translated string by its key.
     *
     * @param key Key of strings.
     * @param parameters List of objects ofr substitution in retrieved strings.
     * @return The translated string.
     */
    String translate(String key, Object ... parameters);
}
