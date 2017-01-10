package imecorpa.configuration;

/**
 * Created by RJ Corchero on 10/01/2017.
 */
public enum View
{
    MainView("/views/MainView.fxml"),
    InformationView("/views/InformationView.fxml"),
    SearchView("/views/SearchView.fxml"),
    ClientView("/views/clients/ClientView.fxml"),
    ProviderView("/views/providers/ProviderView.fxml");

    private String location;

    View(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }
}
