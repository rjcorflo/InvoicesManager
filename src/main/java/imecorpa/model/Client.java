package imecorpa.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Created by Solus on 02/01/2017.
 */
public class Client extends User
{
    private ObjectProperty<NIF> nifOficial = new SimpleObjectProperty<>();

    public Client(int id) {
        super(id);
    }

    public NIF getNifOficial() {
        return nifOficial.get();
    }

    public ObjectProperty<NIF> nifOficialProperty() {
        return nifOficial;
    }

    public void setNifOficial(NIF nifOficial) {
        this.nifOficial.set(nifOficial);
    }
}
