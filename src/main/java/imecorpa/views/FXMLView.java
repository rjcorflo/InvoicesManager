package imecorpa.views;

import imecorpa.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * Created by RJ Corchero on 12/02/2017.
 */
public class FXMLView
{
    private Parent view;

    private FXMLLoader loader = App.getFxmlLoader();

    public  FXMLView() {
        this.loader = App.getFxmlLoader();
    }

    public FXMLLoader getLoader() {
        return this.loader;
    }

    public Parent getView() {
        if (this.view == null) {
            this.loader.setLocation(getClass().getResource(getClass().getSimpleName() + "View.fxml"));

            try {
                this.view = this.loader.load();
            } catch (IOException e) {
                System.out.println("Error");
            }
        }

        return view;
    }

    public <T> T getController() {
        return this.loader.getController();
    }
}
