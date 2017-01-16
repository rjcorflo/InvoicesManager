package imecorpa.app.client;

import imecorpa.model.users.Client;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Observable;
import java.util.Optional;

/**
 * Created by RJ Corchero on 16/01/2017.
 */
public class ClientContext
{
    public static final String VIEW_LIST = "list";
    public static final String VIEW_DATA = "data";

    private StringProperty view = new SimpleStringProperty();

    private ObjectProperty<Optional<Client>> client = new SimpleObjectProperty<>();

    private ListProperty<Client> clientList = new SimpleListProperty<>(FXCollections.emptyObservableList());

    public String getView() {
        return view.get();
    }

    public StringProperty viewProperty() {
        return view;
    }

    public void setView(String view) {
        this.view.set(view);
    }


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
