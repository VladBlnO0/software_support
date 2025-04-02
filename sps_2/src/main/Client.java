package main;

public class Client {
    private String Company_Name, Address, Phone_Number;
    Contract contr;

    Client(String Company_Name, String Address, String Phone_Number, Contract contr) {
        this.Company_Name = Company_Name;
        this.Address = Address;
        this.Phone_Number = Phone_Number;
        this.contr = contr;
    }
}
