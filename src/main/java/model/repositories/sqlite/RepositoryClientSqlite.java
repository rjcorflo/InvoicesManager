package model.repositories.sqlite;

import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.connectivity.DatabaseConnection;
import database.data.ClientDao;
import model.Client;
import model.repositories.RepositoryClient;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Solus on 02/01/2017.
 */
public class RepositoryClientSqlite implements RepositoryClient
{
    private Dao<ClientDao, String> dao;

    @Inject
    public RepositoryClientSqlite(DatabaseConnection connectionSource) throws SQLException, IOException {
        dao = DaoManager.createDao(connectionSource.getConnection(), ClientDao.class);
    }

    @Override
    public int put(Client client) throws SQLException {
        ClientDao clientDao = this.adaptFromClient(client);
        return dao.create(clientDao);
    }

    @Override
    public int delete(Client client) throws SQLException {
        ClientDao clientDao = this.adaptFromClient(client);
        return dao.delete(clientDao);
    }

    @Override
    public Client getById(int id) throws SQLException {
        ClientDao clientDao = dao.queryForId(String.valueOf(id));
        return this.adaptFromClientDao(clientDao);
    }

    @Override
    public Client getByIdFactura(int idFactura) {
        return null;
    }

    private Client adaptFromClientDao(ClientDao clientDao) {
        Client client = new Client(clientDao.getId_cliente());
        client.setFirstName(clientDao.getNombre_cliente());
        client.setFirstLastName(clientDao.getApellido1_cliente());
        client.setSecondLastName(clientDao.getApellido2_cliente());

        return client;
    }

    private ClientDao adaptFromClient(Client client) {
        ClientDao clientDao = new ClientDao();
        return clientDao;
    }
}
