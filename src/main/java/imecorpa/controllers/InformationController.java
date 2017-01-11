package imecorpa.controllers;

import imecorpa.di.services.logger.LoggerService;
import imecorpa.model.users.Client;
import imecorpa.di.services.logger.Log;
import imecorpa.model.repositories.RepositoryClient;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Solus on 03/01/2017.
 */
public class InformationController
{
    @FXML
    private TableView<Log> logInfo;
    @FXML
    private TableColumn<Log, Log.Type> logTypeColumn;
    @FXML
    private TableColumn<Log, String> logMessage;
    @FXML
    private TableColumn<Log, LocalDateTime> logTime;

    private RepositoryClient repository;

    private LoggerService logger;

    @Inject
    public InformationController(RepositoryClient repository, LoggerService logger) {
        this.repository = repository;
        this.logger = logger;
    }

    @FXML
    private void initialize() {
        this.initializeTableView();

        logInfo.setItems(logger.getLogList());

        try {
            Client client = repository.getById(1);

            logger.addInformation("client "+ client.getFirstName() + " " + client.getFirstLastName());

        } catch (Exception e) {
            logger.addError("Error recuperando el cliente");
        }
    }

    private void initializeTableView() {
        logTypeColumn.setCellValueFactory(c -> c.getValue().logTypeProperty());
        logTypeColumn.setCellFactory(column -> {
            return new TableCell<Log, Log.Type>() {
                @Override
                protected void updateItem(Log.Type item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        this.setText("");
                        this.setStyle("");
                    } else {
                        this.setText(item.name());
                        switch(item) {
                            case Error:
                                this.setStyle("-fx-background-color: red;");
                                break;
                            case Warning:
                                this.setStyle("-fx-background-color: yellow;");
                                break;
                            default:
                                this.setStyle("-fx-background-color: green;");
                                break;
                        }
                    }
                }
            };
        });

        //logMessage.setCellValueFactory(c -> c.getValue().logMessageProperty());
        logMessage.setCellFactory(TextFieldTableCell.forTableColumn());

        logTime.setCellValueFactory(c -> c.getValue().timeProperty());
        logTime.setCellFactory(column -> {
            return new TableCell<Log, LocalDateTime>() {
                @Override
                protected void updateItem(LocalDateTime item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        this.setText("");
                    } else {
                        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm");
                        this.setText(item.format(format));
                    }
                }
            };
        });
    }
}
