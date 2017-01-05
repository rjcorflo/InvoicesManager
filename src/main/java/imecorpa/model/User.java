package imecorpa.model;

import java.util.List;

/**
 * Created by Solus on 02/01/2017.
 */
abstract public class User implements UserInterface
{
    private int id;

    private NIF nif;

    private String firstName;

    private String firstLastName;

    private String secondLastName;

    private String email;

    private List<Address> addresses;

    private List<Phone> phones;

    private BankData bankData;

    public User(int id)
    {
        this.setId(id);
    }

    @Override
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public NIF getNif() {
        return nif;
    }

    @Override
    public void setNif(NIF nif) {
        this.nif = nif;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getFirstLastName() {
        return firstLastName;
    }

    @Override
    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    @Override
    public String getSecondLastName() {
        return secondLastName;
    }

    @Override
    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public List<Address> getAddresses() {
        return addresses;
    }

    @Override
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    @Override
    public List<Phone> getPhones() {
        return phones;
    }

    @Override
    public void addPhone(Phone phone) {
        this.phones.add(phone);
    }

    @Override
    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public BankData getBankData() {
        return bankData;
    }

    @Override
    public void setBankData(BankData bankData) {
        this.bankData = bankData;
    }
}
