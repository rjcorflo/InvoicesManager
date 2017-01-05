package imecorpa.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by Solus on 02/01/2017.
 */
public interface UserInterface
{
    int getId();

    SimpleIntegerProperty idProperty();

    void setId(int id);

    NIF getNif();

    SimpleObjectProperty<NIF> nifProperty();

    void setNif(NIF nif);

    String getFirstName();

    SimpleStringProperty firstNameProperty();

    void setFirstName(String firstName);

    String getFirstLastName();

    SimpleStringProperty firstLastNameProperty();

    void setFirstLastName(String firstLastName);

    String getSecondLastName();

    SimpleStringProperty secondLastNameProperty();

    void setSecondLastName(String secondLastName);

    String getEmail();

    SimpleStringProperty emailProperty();

    void setEmail(String email);

    ObservableList<Address> getAddresses();

    SimpleListProperty<Address> addressesProperty();

    void setAddresses(ObservableList<Address> addresses);

    ObservableList<Phone> getPhones();

    SimpleListProperty<Phone> phonesProperty();

    void setPhones(ObservableList<Phone> phones);

    BankData getBankData();

    SimpleObjectProperty<BankData> bankDataProperty();

    void setBankData(BankData bankData);
}