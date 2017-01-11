package imecorpa;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import imecorpa.configuration.View;
import imecorpa.di.modules.ProductionModule;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class App extends Application
{
    private static Injector injector;

    private static Locale locale;

    @Override
    public void init() throws Exception {
        super.init();
        // Init injector
        Module module = new ProductionModule();
        App.injector = Guice.createInjector(module);

        // Init default locale
        App.setLocale(Locale.getDefault());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = App.getFxmlLoader(View.MainView).load();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Locale getLocale() {
        return App.locale;
    }

    public static void setLocale(Locale locale) {
        App.locale = locale;
    }

    public static FXMLLoader getFxmlLoader(View view) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource(view.getLocation()));
        loader.setResources(ResourceBundle.getBundle("bundles.localization.strings", App.getLocale()));
        loader.setControllerFactory(injector::getInstance);

        return loader;
    }
}
