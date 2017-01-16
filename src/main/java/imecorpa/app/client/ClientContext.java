package imecorpa.app.client;

import imecorpa.model.users.Client;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Optional;

/**
 * Context for properties to share between Client controllers and views
 */
public class ClientContext
{
    /**
     * The client to work with. Optional.empty() if there are no client to work.
     */
    private ObjectProperty<Optional<Client>> client = new SimpleObjectProperty<>();

    /**
     * List of clients in the App.
     */
    private ListProperty<Client> clientList = new SimpleListProperty<>(FXCollections.emptyObservableList());

    public Optional<Client> getClient() {
        return client.get();
    }

    public ObjectProperty<Optional<Client>> clientProperty() {
        return client;
    }

    public void setClient(Optional<Client> client) {
        this.client.set(client);
    }

    public ObservableList<Client> getClientList() {
        return clientList.get();
    }

    public ListProperty<Client> clientListProperty() {
        return clientList;
    }

    public void setClientList(ObservableList<Client> clientList) {
        this.clientList.set(clientList);
    }
}
