package imecorpa.model.repositories;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import imecorpa.database.connectivity.DatabaseConnection;
import imecorpa.database.data.ClientDao;
import imecorpa.model.NIF;
import imecorpa.model.users.Client;
import imecorpa.model.users.User;

import javax.inject.Inject;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Solus on 02/01/2017.
 */
class RepositoryClientInMemory implements RepositoryClient
{
    private List<Client> listClients;

    @Inject
    RepositoryClientInMemory() throws SQLException, IOException {
        listClients = new ArrayList<>();

        Client client = new Client();
        client.setId(1);
        client.setEmail("email@email.com");
        client.setFirstName("First");
        client.setFirstLastName("FirstName");
        client.setSecondLastName("SecondLastName");
        client.setNif(new NIF("012345678Z"));
        listClients.add(client);

        client = new Client();
        client.setId(2);
        client.setEmail("aaaa@email.com");
        client.setFirstName("Geralt");
        client.setFirstLastName("Rivia");
        client.setSecondLastName("Riv");
        client.setNif(new NIF("099889988Z"));
        listClients.add(client);

        client = new Client();
        client.setId(3);
        client.setEmail("yennefer@email.com");
        client.setFirstName("Yen");
        client.setFirstLastName("Of");
        client.setSecondLastName("Vengerberg");
        client.setNif(new NIF("011111111W"));
        listClients.add(client);

        client = new Client();
        client.setId(4);
        client.setEmail("ciri@email.com");
        client.setFirstName("Ciri");
        client.setFirstLastName("Rivia");
        client.setSecondLastName("SecondLastName");
        client.setNif(new NIF("78521458Z"));
        listClients.add(client);

        client = new Client();
        client.setId(5);
        client.setEmail("ask@email.com");
        client.setFirstName("Asker");
        client.setFirstLastName("Fers");
        client.setSecondLastName("Fore");
        client.setNif(new NIF("Zip"));
        listClients.add(client);
    }

    @Override
    public int put(Client client) throws SQLException {
        this.listClients.add(client);

        return this.listClients.indexOf(client);
    }

    @Override
    public int delete(Client client) throws SQLException {
        int index = this.listClients.indexOf(client);
        if (index < 0) {
            this.listClients.remove(client);
        }

        return index;
    }

    @Override
    public Client getById(int id) throws SQLException {
        return this.listClients.stream().filter((client) -> client.getId() == id).collect(Collectors.toList()).get(0);
    }

    @Override
    public Client getByIdFactura(int idFactura) {
        return null;
    }

    @Override
    public List<Client> getAll() throws SQLException {
        return this.listClients;
    }
}
