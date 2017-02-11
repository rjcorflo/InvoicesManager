package imecorpa.app;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import imecorpa.App;
import imecorpa.app.menu.MenuControl;
import imecorpa.configuration.Configuration;
import imecorpa.configuration.View;
import imecorpa.events.ChangeViewEvent;
import imecorpa.model.users.Client;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import javax.inject.Inject;
import java.io.IOException;

public class MainController
{
    @FXML
    private BorderPane mainPane;

    @FXML
    private MenuControl menu;

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

        menu.selectedViewProperty().addListener(this::addSelectedViewProperty);
    }

    private void addSelectedViewProperty(ObservableValue<? extends View> observable, View oldValue, View newValue) {
        if (newValue != null) {
            System.out.println(" aaa a a " + newValue.toString());

            FXMLLoader loader = App.getFxmlLoader(newValue);
            try {
                this.mainPane.setCenter(loader.load());
            } catch (IOException e) {

            }
        }
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
        this.mainPane.setCenter(loader.load());

    }
}
