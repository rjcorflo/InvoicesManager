package imecorpa.app.client.data.list;

import imecorpa.model.repositories.RepositoryClient;
import imecorpa.model.repositories.exception.RepositoryException;
import imecorpa.model.users.Client;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import javax.inject.Inject;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Controller for {@link Client clients} list.
 *
 * Controls edition and creation of users. Also controls filter of clients.
 *
 */
public class ListClientController
{
    @FXML private VBox clientList;

    @FXML private TableView<Client> tableClient;

    @FXML private TableColumn<Client,Number> tableColumnId;

    @FXML private TableColumn<Client,String> tableColumnName;

    @FXML private TableColumn<Client,String> tableColumnLastname;

    @FXML private TableColumn<Client,String> tableColumnEmail;

    @FXML private TableColumn<Client, String> tableColumnNif;

    /**
     * Repository of {@link Client Clients}.
     */
    private RepositoryClient repositoryClient;

    @Inject
    public ListClientController(RepositoryClient repository)
    {
        this.repositoryClient = repository;
    }

    @FXML
    private void initialize() throws RepositoryException
    {
        this.initializeTableView();
        List<Client> list = this.repositoryClient.getAll();
        this.tableClient.setItems(FXCollections.observableArrayList(list));
    }

    private void initializeTableView()
    {
        // Change context client on double click for edition
        this.tableClient.setRowFactory(tv -> {
            TableRow<Client> tr = new TableRow<>();
            tr.setOnMouseClicked(mouseEvent -> {
                if (mouseEvent.getClickCount() == 2) {
                }
            });
            return tr;
        });

        // Data association
        this.tableColumnId.setCellValueFactory(cellDataFeatures -> cellDataFeatures.getValue().idProperty());

        this.tableColumnName.setCellValueFactory(cellDataFeatures -> cellDataFeatures.getValue().firstNameProperty());

        this.tableColumnLastname.setCellValueFactory(cellDataFeatures -> Bindings.concat(cellDataFeatures.getValue().firstLastNameProperty(), " ", cellDataFeatures.getValue().secondLastNameProperty()));

        this.tableColumnNif.setCellValueFactory(cellDataFeatures -> cellDataFeatures.getValue().nifProperty().getValue().nifProperty());

        this.tableColumnEmail.setCellValueFactory(cellDataFeatures -> cellDataFeatures.getValue().emailProperty());
    }

    @FXML
    private void addClient(ActionEvent actionEvent) {
        Optional<Client> newClient = Optional.of(new Client());
    }

    @FXML
    private void editClient(ActionEvent actionEvent) throws IOException {
        Optional<Client> selectedClient = Optional.ofNullable(this.tableClient.getSelectionModel().getSelectedItem());
    }
}