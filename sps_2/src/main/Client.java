package main;

public class Client {
    private final String Company_Name, Address, Phone_Number;
    private final String Second_Phone_Number;
    public Contract contr;

    public Client(String Company_Name, String Address, String Phone_Number, String Second_Phone_Number, Contract contr) {

        if (Company_Name == null || Company_Name.isEmpty() || Company_Name.length() > 500) {throw new IllegalArgumentException("Invalid data");}
        else {this.Company_Name = Company_Name;}

        if (Address == null || Address.isEmpty() || Address.length() > 500) {throw new IllegalArgumentException("Invalid data");}
        else {this.Address = Address;}

        if (Phone_Number == null || Phone_Number.isEmpty() || Phone_Number.length() > 500) {throw new IllegalArgumentException("Invalid data");}
        else if (Phone_Number.equals(Second_Phone_Number)) {throw new IllegalArgumentException("Equal Data");}
        else {this.Phone_Number = Phone_Number;}

        //TDD
        if (Second_Phone_Number == null || Second_Phone_Number.isEmpty() || Second_Phone_Number.length() > 500) {throw new IllegalArgumentException("Invalid data");}
        else if (Second_Phone_Number.equals(Phone_Number)) {throw new IllegalArgumentException("Invalid data");}
        else {this.Second_Phone_Number = Second_Phone_Number;}

        this.contr = contr;
    }

    public String getCompany_Name() {
        return Company_Name;
    }
    public String getSecond_Phone_Number() {
        return Second_Phone_Number;
    }


    void Info() {
        System.out.printf("%nPhone_Number: %sf", Phone_Number);
        System.out.printf("%nSecond_Phone_Number: %s", Second_Phone_Number);
        System.out.printf("%n--------------------------------");
    }
}
