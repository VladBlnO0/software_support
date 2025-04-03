package main;

public class Client {
    private final String Company_Name, Address, Phone_Number;
    private final String Second_Phone_Number;
    Contract contr;

    public Client(String Company_Name, String Address, String Phone_Number, String Second_Phone_Number, Contract contr) {

        if (Company_Name == null || Company_Name.length() < 1 || Company_Name.length() > 500) {throw new IllegalArgumentException("Invalid data");}
        else {this.Company_Name = Company_Name;}

        if (Address == null || Address.length() < 1 || Address.length() > 500) {throw new IllegalArgumentException("Invalid data");}
        else {this.Address = Address;}

        if (Phone_Number == null || Phone_Number.length() < 1 || Phone_Number.length() > 500) {throw new IllegalArgumentException("Invalid data");}
        else {this.Phone_Number = Phone_Number;}

        //TDD
        if (Second_Phone_Number == null || Second_Phone_Number.length() < 1 || Second_Phone_Number.length() > 500) {throw new IllegalArgumentException("Invalid data");}
        else if (this.Phone_Number = Second_Phone_Number) {throw new IllegalArgumentException("Invalid data");}
        else {this.Second_Phone_Number = Second_Phone_Number;}

        this.contr = contr;
    }

    public String getCompany_Name() {
        return Company_Name;
    }

    void Info() {
        System.out.printf("%nPhone_Number: %sf", Phone_Number);
        System.out.printf("%nSecond_Phone_Number: %s", Second_Phone_Number);
        System.out.printf("%n--------------------------------");
    }
}
