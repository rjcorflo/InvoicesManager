package imecorpa.model.repositories;

import imecorpa.model.Client;

import java.sql.SQLException;

/**
 * Created by Solus on 02/01/2017.
 */
public interface RepositoryClient
{
    public int put(Client client) throws SQLException;
    public int delete(Client client) throws SQLException;
    public Client getById(int id) throws SQLException;
    public Client getByIdFactura(int idFactura);
}
