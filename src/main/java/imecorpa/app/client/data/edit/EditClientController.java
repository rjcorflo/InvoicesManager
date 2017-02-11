package imecorpa.app.client.data.edit;

import imecorpa.model.repositories.RepositoryClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import javax.inject.Inject;
import java.sql.SQLException;

/**
 * Created by Solus on 05/01/2017.
 */
public class EditClientController
{
    @FXML private TextField name;
    @FXML private TextField nif;

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
        this.loadData();
    }

    private void loadData() {
    }

    public void saveClient(ActionEvent actionEvent) {
    }

    public void cancelEditClient(ActionEvent actionEvent) {
    }
}