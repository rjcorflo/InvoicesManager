package imecorpa.app;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import imecorpa.configuration.Configuration;
import imecorpa.event.ChangeViewEvent;
import imecorpa.model.users.Client;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javax.inject.Inject;
import java.io.IOException;

public class MainController
{

    @FXML
    private BorderPane mainPane;

    @FXML
    private HBox menu;

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
        //System.out.println("  " + menu.toString());
        //menu.selectedViewProperty().addListener(this::addSelectedViewProperty);
    }

    @Subscribe
    public void selectView(ChangeViewEvent event) throws IOException {
    }

    public void showListClientView() throws IOException {
    }

    public void showDataClientView(Client client) throws IOException {
    }
}
