package imecorpa.model;

import java.util.List;

/**
 * Created by Solus on 02/01/2017.
 */
public interface UserInterface
{
    int getId();

    void setNif(NIF nif);

    public NIF getNif();

    void setFirstName(String firstName);

    String getFirstName();

    void setFirstLastName(String firstLastName);

    String getFirstLastName();

    void setSecondLastName(String secondLastName);

    String getSecondLastName();

    void setEmail(String email);

    String getEmail();

    void addAddress(Address address);

    void setAddresses(List<Address> addresses);

    List<Address> getAddresses();

    void addPhone(Phone phone);

    void setPhones(List<Phone> phones);

    List<Phone> getPhones();

    void setBankData(BankData bankData);

    BankData getBankData();
}
