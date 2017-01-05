package imecorpa.model.repositories.sqlite;

import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import imecorpa.database.connectivity.DatabaseConnection;
import imecorpa.database.data.ClientDao;
import imecorpa.model.Client;
import imecorpa.model.repositories.RepositoryClient;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Client> getAll() throws SQLException {
        List<ClientDao> listDao = this.dao.queryForAll();
        List<Client> listClients = listDao.stream().map(this::adaptFromClientDao).collect(Collectors.toList());
        return listClients;
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
