package imecorpa.model.repositories;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import imecorpa.database.connectivity.DatabaseConnection;
import imecorpa.database.data.ClientDao;
import imecorpa.model.NIF;
import imecorpa.model.users.Client;

import javax.inject.Inject;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Solus on 02/01/2017.
 */
class RepositoryClientSqlite implements RepositoryClient
{
    private Dao<ClientDao, String> dao;

    @Inject
    RepositoryClientSqlite(DatabaseConnection connectionSource) throws SQLException, IOException {
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
        return listDao.stream().map(this::adaptFromClientDao).collect(Collectors.toList());
    }

    private Client adaptFromClientDao(ClientDao clientDao) {
        Client client = new Client(clientDao.getId_cliente());
        Optional<String> firstName = Optional.ofNullable(clientDao.getNombre_cliente());
        client.setFirstName(firstName.orElse(""));
        Optional<String> firstLastName = Optional.ofNullable(clientDao.getApellido1_cliente());
        client.setFirstLastName(firstLastName.orElse(""));
        Optional<String> secondLastName = Optional.ofNullable(clientDao.getApellido2_cliente());
        client.setSecondLastName(secondLastName.orElse(""));
        client.setNif(new NIF(clientDao.getCif()));

        return client;
    }

    private ClientDao adaptFromClient(Client client) {
        return new ClientDao();
    }
}
