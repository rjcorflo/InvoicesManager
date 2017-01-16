package imecorpa.model.repositories;

import imecorpa.model.users.Client;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Solus on 02/01/2017.
 */
public interface RepositoryClient
{
    int put(Client client) throws SQLException;
    int delete(Client client) throws SQLException;
    Client getById(int id) throws SQLException;
    Client getByIdFactura(int idFactura);
    List<Client> getAll() throws SQLException;
}
