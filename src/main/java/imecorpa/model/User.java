package imecorpa.model;

import javafx.beans.property.*;
import javafx.collections.ObservableList;

/**
 * Created by Solus on 02/01/2017.
 */
abstract public class User implements UserInterface
{
    private IntegerProperty id = new SimpleIntegerProperty();

    private ObjectProperty<NIF> nif = new SimpleObjectProperty<>();

    private StringProperty firstName = new SimpleStringProperty();

    private StringProperty firstLastName = new SimpleStringProperty();

    private StringProperty secondLastName = new SimpleStringProperty();

    private StringProperty email = new SimpleStringProperty();

    private ListProperty<Address> addresses  = new SimpleListProperty<>();

    private ListProperty<Phone> phones  = new SimpleListProperty<>();

    private ObjectProperty<BankData> bankData = new SimpleObjectProperty<>();

    public User(int id)
    {
        this.setId(id);
    }

    @Override
    public int getId() {
        return id.get();
    }

    @Override
    public IntegerProperty idProperty() {
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
    public ObjectProperty<NIF> nifProperty() {
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
    public StringProperty firstNameProperty() {
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
    public StringProperty firstLastNameProperty() {
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
    public StringProperty secondLastNameProperty() {
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
    public StringProperty emailProperty() {
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
    public ListProperty<Address> addressesProperty() {
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
    public ListProperty<Phone> phonesProperty() {
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
    public ObjectProperty<BankData> bankDataProperty() {
        return bankData;
    }

    @Override
    public void setBankData(BankData bankData) {
        this.bankData.set(bankData);
    }
}
