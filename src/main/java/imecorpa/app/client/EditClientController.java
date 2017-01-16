package imecorpa.app.client;

import imecorpa.model.repositories.RepositoryClient;
import imecorpa.model.users.Client;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import javax.inject.Inject;
import javax.naming.Binding;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Solus on 05/01/2017.
 */
public class EditClientController
{
    @FXML private TextField name;

    @FXML private VBox clientEdit;

    private ClientContext clientContext;

    private RepositoryClient repositoryClient;

    @Inject
    public EditClientController(ClientContext context, RepositoryClient repository)
    {
        this.clientContext = context;
        this.repositoryClient = repository;
    }

    @FXML
    private void initialize() throws SQLException
    {
        this.name.setText( clientContext.getClient().get().getFirstName());

        clientContext.clientProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isPresent()) {
                this.name.setText(newValue.get().getFirstName());
            }
        });
    }

    public void editClient(ActionEvent actionEvent) {
        Client client = this.clientContext.getClient().get();
        client.setFirstName(this.name.getText());
    }

    public void cancelEditClient(ActionEvent actionEvent) {
        clientContext.clientProperty().set(Optional.empty());
    }
}