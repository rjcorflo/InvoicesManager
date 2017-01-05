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
abstract public class User implements UserInterface
{
    private SimpleIntegerProperty id = new SimpleIntegerProperty();

    private SimpleObjectProperty<NIF> nif = new SimpleObjectProperty<NIF>();

    private SimpleStringProperty firstName = new SimpleStringProperty();

    private SimpleStringProperty firstLastName = new SimpleStringProperty();

    private SimpleStringProperty secondLastName = new SimpleStringProperty();

    private SimpleStringProperty email = new SimpleStringProperty();

    private SimpleListProperty<Address> addresses  = new SimpleListProperty<Address>();

    private SimpleListProperty<Phone> phones  = new SimpleListProperty<Phone>();

    private SimpleObjectProperty<BankData> bankData = new SimpleObjectProperty<BankData>();

    public User(int id)
    {
        this.setId(id);
    }

    @Override
    public int getId() {
        return id.get();
    }

    @Override
    public SimpleIntegerProperty idProperty() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id.set(id);
    }

    @Override
    public NIF getNif() {
        return nif.get();
    }

    @Override
    public SimpleObjectProperty<NIF> nifProperty() {
        return nif;
    }

    @Override
    public void setNif(NIF nif) {
        this.nif.set(nif);
    }

    @Override
    public String getFirstName() {
        return firstName.get();
    }

    @Override
    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    @Override
    public String getFirstLastName() {
        return firstLastName.get();
    }

    @Override
    public SimpleStringProperty firstLastNameProperty() {
        return firstLastName;
    }

    @Override
    public void setFirstLastName(String firstLastName) {
        this.firstLastName.set(firstLastName);
    }

    @Override
    public String getSecondLastName() {
        return secondLastName.get();
    }

    @Override
    public SimpleStringProperty secondLastNameProperty() {
        return secondLastName;
    }

    @Override
    public void setSecondLastName(String secondLastName) {
        this.secondLastName.set(secondLastName);
    }

    @Override
    public String getEmail() {
        return email.get();
    }

    @Override
    public SimpleStringProperty emailProperty() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email.set(email);
    }

    @Override
    public ObservableList<Address> getAddresses() {
        return addresses.get();
    }

    @Override
    public SimpleListProperty<Address> addressesProperty() {
        return addresses;
    }

    @Override
    public void setAddresses(ObservableList<Address> addresses) {
        this.addresses.set(addresses);
    }

    @Override
    public ObservableList<Phone> getPhones() {
        return phones.get();
    }

    @Override
    public SimpleListProperty<Phone> phonesProperty() {
        return phones;
    }

    @Override
    public void setPhones(ObservableList<Phone> phones) {
        this.phones.set(phones);
    }

    @Override
    public BankData getBankData() {
        return bankData.get();
    }

    @Override
    public SimpleObjectProperty<BankData> bankDataProperty() {
        return bankData;
    }

    @Override
    public void setBankData(BankData bankData) {
        this.bankData.set(bankData);
    }
}
