package imecorpa.events;

import imecorpa.configuration.View;

/**
 * Created by RJ Corchero on 14/01/2017.
 */
public class ChangeViewEvent {
    private View view;

    public ChangeViewEvent(View view) {
        this.view = view;
    }

    public View getView() {
        return this.view;
    }
}
