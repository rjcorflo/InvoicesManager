package imecorpa.app.client;

import imecorpa.App;
import imecorpa.configuration.View;
import imecorpa.di.services.logger.LoggerService;
import imecorpa.model.users.Client;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by Solus on 05/01/2017.
 */
public class ClientController
{
    @FXML private HBox clientRoot;

    /**
     * Logger servide to control data information
     */
    private LoggerService loggerService;

    @Inject
    public ClientController(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    @FXML
    private void initialize() {
    }

    /**
     * Show client list view
     *
     * @throws IOException
     */
    public void showListClientView() throws IOException {
        FXMLLoader loader = App.getFxmlLoader(View.ListClientView);
        clientRoot.getChildren().clear();
        clientRoot.getChildren().add(loader.load());
    }

    /**
     * Show client edition view
     *
     * @param client The client to edit
     * @throws IOException If there is a problem instantiating FXML
     */
    public void showEditClientView(Client client) throws IOException {
    }

    public void showDataClientView(Optional<Client> client) {
    }
}