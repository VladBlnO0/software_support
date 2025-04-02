package main;

public class Client {
    private final String Company_Name, Address, Phone_Number;
    private final String Second_Phone_Number;
    Contract contr;

    Client(String Company_Name, String Address, String Phone_Number, String Second_Phone_Number, Contract contr) {
        this.Company_Name = Company_Name;
        this.Address = Address;
        this.Phone_Number = Phone_Number;

        //TDD
        this.Second_Phone_Number = Second_Phone_Number;


        this.contr = contr;
    }
    void Info() {
        System.out.printf("%nPhone_Number: %sf", Phone_Number);
        System.out.printf("%nSecond_Phone_Number: %s", Second_Phone_Number);
        System.out.printf("%n--------------------------------");
    }
}
