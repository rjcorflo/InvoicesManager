package imecorpa.configuration;

/**
 * Created by RJ Corchero on 10/01/2017.
 */
public enum View
{
    MainView("/imecorpa/app/MainView.fxml"),
    InformationView("/imecorpa/app/information/InformationView.fxml"),
    SearchView("/views/SearchView.fxml"),
    ClientView("/imecorpa/app/client/ClientView.fxml"),
    ListClientView("/imecorpa/app/client/data/list/ListClientView.fxml"),
    EditClientView("/imecorpa/app/client/data/edit/EditClientView.fxml"),
    ProviderView("/imecorpa/app/provider/ProviderView.fxml");

    private String location;

    View(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }
}
