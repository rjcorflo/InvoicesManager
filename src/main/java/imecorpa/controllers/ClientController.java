package imecorpa.controllers;

import com.google.inject.Inject;
import imecorpa.di.services.logger.LoggerService;
import imecorpa.model.Client;
import imecorpa.model.repositories.RepositoryClient;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.sql.SQLException;

/**
 * Created by Solus on 05/01/2017.
 */
public class ClientController
{
    @FXML private TableView<Client> tableClients;

    @FXML private TableColumn<Client,Number> tableColumnId;

    @FXML private TableColumn<Client,String> tableColumnName;

    @FXML private TableColumn<Client,String> tableColumnLastname;

    private ObservableList<Client> observableList;

    private RepositoryClient repositoryClient;

    private LoggerService loggerService;

    @Inject
    public ClientController(RepositoryClient repository, LoggerService loggerService) {
        this.repositoryClient = repository;
        this.loggerService = loggerService;
    }

    @FXML
    private void initialize() throws SQLException {
        this.initializeTableView();
        this.observableList = FXCollections.observableList(this.repositoryClient.getAll());
        this.tableClients.setItems(this.observableList);
    }

    private void initializeTableView() {
        this.tableColumnId.setCellValueFactory(cellDataFeatures -> cellDataFeatures.getValue().idProperty());

        this.tableColumnName.setCellValueFactory(cellDataFeatures -> cellDataFeatures.getValue().firstNameProperty());

        this.tableColumnLastname.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFirstLastName() + " " + c.getValue().getSecondLastName()));
    }
}
