package imecorpa.app;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import imecorpa.app.client.ClientContext;
import imecorpa.app.client.ClientController;
import imecorpa.configuration.Configuration;
import imecorpa.configuration.View;
import imecorpa.events.ChangeViewEvent;
import imecorpa.model.users.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import imecorpa.App;

import javax.inject.Inject;
import java.io.IOException;

public class MainController
{
    @FXML
    private BorderPane mainPane;

    private Configuration configuration;

    private EventBus eventBus;

    @Inject
    public MainController(Configuration configuration, EventBus eventBus) throws IOException {
        this.configuration = configuration;
        this.eventBus = eventBus;
    }

    @FXML
    private void initialize() {
        eventBus.register(this);
    }

    @Subscribe
    public void selectView(ChangeViewEvent event) throws IOException {
        switch (event.getView()) {
            case ListClientView:
                this.showListClientView();
                break;
            default:
                break;
        }
    }

    public void showListClientView() throws IOException {
        FXMLLoader loader = App.getFxmlLoader(View.ClientView);
        this.mainPane.setCenter(loader.load());
    }

    public void showDataClientView(Client client) throws IOException {
        FXMLLoader loader = App.getFxmlLoader(View.ClientView);
        ClientController controller = loader.getController();
        this.mainPane.setCenter(loader.load());

    }
}
