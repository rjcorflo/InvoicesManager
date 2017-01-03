package controllers;

import configuration.Configuration;
import di.App;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MainController {
    @FXML
    private TextField propertyName;

    @FXML
    private TextField propertyValue;

    private Configuration config;

    public MainController() throws IOException {
        this.config = App.getInjector().getInstance(Configuration.class);
    }

    public void addProperty(MouseEvent mouseEvent) {
        config.setValue(propertyName.getText(), propertyValue.getText());
    }

    public void loadProperty(MouseEvent mouseEvent) {
        String value = config.getValue(propertyName.getText());
        propertyValue.setText(value);
    }
}
