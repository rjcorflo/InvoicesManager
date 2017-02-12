package imecorpa.app.client.menu;

import com.google.common.eventbus.EventBus;

import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by RJ Corchero on 16/01/2017.
 */
public class MenuClientController
{
    private EventBus eventBus;

    @Inject
    public MenuClientController(EventBus eventBus) throws IOException {
        this.eventBus = eventBus;
    }
}
