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

    public NIF getCifOficial() {
        return nifOficial;
    }

    public void setCifOficial(NIF nifOficial) {
        this.nifOficial = nifOficial;
    }
}
