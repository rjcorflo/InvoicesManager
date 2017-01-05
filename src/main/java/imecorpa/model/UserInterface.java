package imecorpa.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 * Created by Solus on 02/01/2017.
 */
public interface UserInterface
{
    int getId();

    IntegerProperty idProperty();

    void setId(int id);

    NIF getNif();

    ObjectProperty<NIF> nifProperty();

    void setNif(NIF nif);

    String getFirstName();

    StringProperty firstNameProperty();

    void setFirstName(String firstName);

    String getFirstLastName();

    StringProperty firstLastNameProperty();

    void setFirstLastName(String firstLastName);

    String getSecondLastName();

    StringProperty secondLastNameProperty();

    void setSecondLastName(String secondLastName);

    String getEmail();

    StringProperty emailProperty();

    void setEmail(String email);

    ObservableList<Address> getAddresses();

    ListProperty<Address> addressesProperty();

    void setAddresses(ObservableList<Address> addresses);

    ObservableList<Phone> getPhones();

    ListProperty<Phone> phonesProperty();

    void setPhones(ObservableList<Phone> phones);

    BankData getBankData();

    ObjectProperty<BankData> bankDataProperty();

    void setBankData(BankData bankData);
}