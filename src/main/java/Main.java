import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import di.App;
import di.module.ConfigurationModule;
import di.module.RepositoryModule;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.repositories.RepositoryClient;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception {
        final Injector injector = App.getInjector();
        //final Injector injector = Guice.createInjector(Modules.combine(new ConfigurationModule(), new RepositoryModule()));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/MainView.fxml"));
        // In Java 8, replace the above with
        loader.setControllerFactory(injector::getInstance);
        //Parent root = FXMLLoader.load(getClass().getResource("views/MainView.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
