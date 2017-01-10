package imecorpa;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import imecorpa.configuration.View;
import imecorpa.di.module.ConfigurationModule;
import imecorpa.di.module.RepositoryModule;
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

    private static FXMLLoader fxmlLoader;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Module module = Modules.combine(new ConfigurationModule(), new RepositoryModule());
        App.setInjector(Guice.createInjector(module));
        App.setLocale(Locale.getDefault());

        Parent root = App.getFxmlLoader(View.MainView).load();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Injector getInjector() {
        if (App.injector == null) {
            Module module = Modules.combine(new ConfigurationModule(), new RepositoryModule());
            App.injector = Guice.createInjector(module);
        }

        return App.injector;
    }

    public static void setInjector(Injector injector) {
        App.injector = injector;
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
