package imecorpa.app.client;

import imecorpa.App;
import imecorpa.configuration.View;
import imecorpa.model.users.Client;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

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
        context.setClient(Optional.empty());

        context.clientProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isPresent()) {
                try {
                    this.showEditClientView(newValue.get());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }

    public void showListClientView() throws IOException {
        FXMLLoader loader = App.getFxmlLoader(View.ListClientView);
        ListClientController controller = loader.getController();
        this.clientRoot.getChildren().add(loader.load());
    }

    public void showEditClientView(Client client) throws IOException {
        FXMLLoader loader = App.getFxmlLoader(View.EditClientView);

        this.clientRoot.getChildren().add(loader.load());

        EditClientController controller = loader.getController();
        controller.loadClient(client);
    }
}