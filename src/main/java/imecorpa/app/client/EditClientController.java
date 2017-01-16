package imecorpa.app.client;

import imecorpa.model.repositories.RepositoryClient;
import imecorpa.model.users.Client;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Solus on 05/01/2017.
 */
public class EditClientController
{
    @FXML private TextField name;

    @FXML private VBox clientEdit;

    private RepositoryClient repositoryClient;

    @Inject
    public EditClientController(RepositoryClient repository)
    {
        this.repositoryClient = repository;
    }

    @FXML
    private void initialize() throws SQLException
    {
    }

    public void loadClient(Client client) {
        this.name.setText(client.getFirstName());
    }
}