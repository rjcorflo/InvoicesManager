package imecorpa.controllers;

import imecorpa.di.services.logger.LoggerService;
import imecorpa.model.repositories.RepositoryClient;
import imecorpa.model.users.Client;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;

import javax.inject.Inject;
import java.sql.SQLException;

/**
 * Created by Solus on 05/01/2017.
 */
public class ClientController
{
    @FXML private HBox clientRoot;

    @FXML private TableView<Client> clientList;

    @FXML private TitledPane clientEdit;

    @FXML private TableColumn<Client,Number> tableColumnId;

    @FXML private TableColumn<Client,String> tableColumnName;

    @FXML private TableColumn<Client,String> tableColumnLastname;

    @FXML private TableColumn<Client,String> tableColumnEmail;

    @FXML private TableColumn<Client, String> tableColumnNif;

    private ObservableList<Client> observableList;

    private RepositoryClient repositoryClient;

    private LoggerService loggerService;

    @Inject
    public ClientController(RepositoryClient repository, LoggerService loggerService)
    {
        this.repositoryClient = repository;
        this.loggerService = loggerService;
    }

    @FXML
    private void initialize() throws SQLException
    {
        this.clientRoot.getChildren().remove(this.clientEdit);
        this.clientList.setPrefWidth(1000);

        System.out.println("Children " + this.clientRoot.getChildren());

        this.initializeTableView();
        this.observableList = FXCollections.observableList(this.repositoryClient.getAll());
        this.clientList.setItems(this.observableList);
    }

    private void initializeTableView()
    {
        this.tableColumnId.setCellValueFactory(cellDataFeatures -> cellDataFeatures.getValue().idProperty());

        this.tableColumnName.setCellValueFactory(cellDataFeatures -> cellDataFeatures.getValue().firstNameProperty());

        this.tableColumnLastname.setCellValueFactory(cellDataFeatures -> Bindings.concat(cellDataFeatures.getValue().firstLastNameProperty(), " ", cellDataFeatures.getValue().secondLastNameProperty()));

        this.tableColumnNif.setCellValueFactory(cellDataFeatures -> cellDataFeatures.getValue().nifProperty().getValue().nifProperty());

        this.tableColumnEmail.setCellValueFactory(cellDataFeatures -> cellDataFeatures.getValue().emailProperty());

        this.clientList.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        this.addEditClientView();
                    } else {
                        this.removeEditClientView();
                    }
                }
        );
    }

    private void addEditClientView()
    {
        if (!this.clientRoot.getChildren().contains(this.clientEdit)) {
            this.clientRoot.getChildren().add(this.clientEdit);
        }
    }

    private void removeEditClientView() {
        if (this.clientRoot.getChildren().contains(this.clientEdit)) {
            this.clientRoot.getChildren().remove(this.clientEdit);
        }
    }
}