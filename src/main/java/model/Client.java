package model;

/**
 * Created by Solus on 02/01/2017.
 */
public class Client extends User
{
    private NIF nifOficial;

    public Client(int id) {
        super(id);
    }

    public NIF getNifOficial() {
        return nifOficial;
    }

    public void setNifOficial(NIF nifOficial) {
        this.nifOficial = nifOficial;
    }
}
