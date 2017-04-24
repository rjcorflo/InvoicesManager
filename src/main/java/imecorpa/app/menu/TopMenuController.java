package imecorpa.app.menu;

import com.google.common.eventbus.EventBus;
import imecorpa.event.ChangeViewEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by RJ Corchero on 16/01/2017.
 */
public class TopMenuController
{
    private EventBus eventBus;

    @Inject
    public TopMenuController(EventBus eventBus) throws IOException {
        this.eventBus = eventBus;
    }

    @FXML
    private void showListView(ActionEvent actionEvent) {
        ChangeViewEvent change = new ChangeViewEvent();
        eventBus.post(change);
    }
}
