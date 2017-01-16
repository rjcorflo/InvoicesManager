package imecorpa.controllers;

import com.google.common.eventbus.EventBus;
import imecorpa.configuration.View;
import imecorpa.events.ChangeViewEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by RJ Corchero on 16/01/2017.
 */
public class MenuController
{
    private EventBus eventBus;

    @Inject
    public MenuController(EventBus eventBus) throws IOException {
        this.eventBus = eventBus;
    }

    @FXML
    private void showListView(ActionEvent actionEvent) {
        ChangeViewEvent change = new ChangeViewEvent(View.ListClientView);
        eventBus.post(change);
    }
}
