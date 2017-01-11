package imecorpa.controllers;

import imecorpa.configuration.Configuration;
import imecorpa.configuration.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import imecorpa.App;

import javax.inject.Inject;
import java.io.IOException;

public class MainController {
    @FXML
    private TextField propertyName;

    @FXML
    private TextField propertyValue;

    @FXML
    private BorderPane idPane;

    private Configuration configuration;

    @Inject
    public MainController(Configuration configuration) throws IOException {
        this.configuration = configuration;
    }

    public void addProperty(MouseEvent mouseEvent) {
        configuration.setValue(propertyName.getText(), propertyValue.getText());
    }

    public void loadProperty(MouseEvent mouseEvent) {
        String value = configuration.getValue(propertyName.getText());
        propertyValue.setText(value);
    }

    public void activeClient(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = App.getFxmlLoader(View.ClientView);

        this.idPane.setCenter(loader.load());
    }

    public void activeProvider(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = App.getFxmlLoader(View.ProviderView);

        this.idPane.setCenter(loader.load());
    }
}
