package imecorpa.model.repositories;

import imecorpa.model.repositories.exception.RepositoryException;
import imecorpa.model.users.Client;

import java.sql.SQLException;
import java.util.List;

/**
 * Provide methods to persist clients.
 */
public interface RepositoryClient
{
    /**
     * Save client.
     *
     * @param client
     * @return
     * @throws SQLException
     */
    int put(Client client) throws RepositoryException;

    /**
     *
     * @param client
     * @return
     * @throws SQLException
     */
    int delete(Client client) throws RepositoryException;

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    Client getById(int id) throws RepositoryException;

    /**
     *
     * @param idFactura
     * @return
     */
    Client getByIdFactura(int idFactura) throws RepositoryException;

    /**
     *
     * @return
     * @throws SQLException
     */
    List<Client> getAll() throws RepositoryException;
}
