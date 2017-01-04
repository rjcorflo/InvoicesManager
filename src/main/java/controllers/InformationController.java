package controllers;

import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import model.Client;
import model.log.Log;
import model.repositories.RepositoryClient;

import java.time.LocalDateTime;

/**
 * Created by Solus on 03/01/2017.
 */
public class InformationController
{
    @FXML
    private TableView<Log> logInfo;

    private RepositoryClient repository;

    @Inject
    public InformationController(RepositoryClient repository) {
        this.repository = repository;
    }

    @FXML
    private void initialize() {
        logInfo.getItems().add(new Log(Log.LogType.Error, "Mensaje 1", LocalDateTime.now()));
        logInfo.getItems().add(new Log(Log.LogType.Error, "Mensaje 2", LocalDateTime.now()));
        logInfo.getItems().add(new Log(Log.LogType.Error, "Mensaje 3", LocalDateTime.now()));
        logInfo.getItems().add(new Log(Log.LogType.Error, "Mensaje 3", LocalDateTime.now()));
        logInfo.getItems().add(new Log(Log.LogType.Error, "Mensaje 3", LocalDateTime.now()));
        logInfo.getItems().add(new Log(Log.LogType.Error, "Mensaje 3", LocalDateTime.now()));
        logInfo.getItems().add(new Log(Log.LogType.Error, "Mensaje 3", LocalDateTime.now()));
        logInfo.getItems().add(new Log(Log.LogType.Error, "Mensaje 3", LocalDateTime.now()));
        logInfo.getItems().add(new Log(Log.LogType.Error, "Mensaje 3", LocalDateTime.now()));
        logInfo.getItems().add(new Log(Log.LogType.Error, "Mensaje 3", LocalDateTime.now()));
        logInfo.getItems().add(new Log(Log.LogType.Error, "Mensaje 3", LocalDateTime.now()));
        logInfo.getItems().add(new Log(Log.LogType.Error, "Mensaje 3", LocalDateTime.now()));
        logInfo.getItems().add(new Log(Log.LogType.Error, "Mensaje 3", LocalDateTime.now()));
        logInfo.getItems().add(new Log(Log.LogType.Error, "Mensaje 3", LocalDateTime.now()));
        logInfo.getItems().add(new Log(Log.LogType.Error, "Mensaje 3", LocalDateTime.now()));
        logInfo.getItems().add(new Log(Log.LogType.Error, "Mensaje 3", LocalDateTime.now()));
        logInfo.getItems().add(new Log(Log.LogType.Error, "Mensaje 3", LocalDateTime.now()));
        logInfo.getItems().add(new Log(Log.LogType.Error, "Mensaje 3", LocalDateTime.now()));

        try {
            Client client = repository.getById(1);

            logInfo.getItems().add(new Log(Log.LogType.Error, "client "+ client.getFirstName() + " " + client.getFirstLastName(), LocalDateTime.now()));

        } catch (Exception e) {
            logInfo.getItems().add(new Log(Log.LogType.Error, e.getMessage(),LocalDateTime.now()));
        }
    }
}
