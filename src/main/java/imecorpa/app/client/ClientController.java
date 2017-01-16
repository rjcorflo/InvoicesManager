package imecorpa.app.client;

import imecorpa.App;
import imecorpa.configuration.View;
import imecorpa.model.users.Client;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by Solus on 05/01/2017.
 */
public class ClientController
{
    private ClientContext context;

    @FXML private HBox clientRoot;

    @Inject
    public ClientController(ClientContext context) {
        this.context = context;
    }

    @FXML
    private void initialize() {
        context.setView(ClientContext.VIEW_LIST);
        context.setClient(Optional.empty());

        context.clientProperty().addListener((observable, oldValue, newValue) -> {
            try {
                this.showEditClientView(newValue);
            } catch (IOException e) {
            }
        });
    }

    public void showListClientView() throws IOException {
        FXMLLoader loader = App.getFxmlLoader(View.ListClientView);
        this.clientRoot.getChildren().add(loader.load());
    }

    public void showEditClientView(Optional<Client> client) throws IOException {
        // Set client in context
        this.context.setClient(client);

        // Load edit view
        if (client.isPresent() && this.clientRoot.getChildren().size() < 2) {
            FXMLLoader loader = App.getFxmlLoader(View.EditClientView);
            this.clientRoot.getChildren().add(loader.load());
        }

        if (!client.isPresent() && this.clientRoot.getChildren().size() == 2) {
            this.clientRoot.getChildren().remove(1);
        }
    }
}