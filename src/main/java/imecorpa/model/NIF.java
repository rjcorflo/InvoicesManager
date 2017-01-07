package imecorpa.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Solus on 02/01/2017.
 */
public class NIF
{
    private StringProperty nif = new SimpleStringProperty("");

    public NIF(String completeNif)
    {
        this.setNif(completeNif);
    }

    public String getNif() {
        return nif.get();
    }

    public StringProperty nifProperty() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif.set(nif);
    }
}
