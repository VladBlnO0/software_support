package main;

public class Dispatcher {
    private String Company_Name, Address, Phone_Number;
    private String Full_Name;
    private int Work_Experience;
    Client client;

    Dispatcher(String Company_Name, String Address, String Phone_Number, String Full_Name, int Work_Experience, Client client) {
        this.Company_Name = Company_Name;
        this.Address = Address;
        this.Phone_Number = Phone_Number;
        this.Full_Name = Full_Name;
        this.Work_Experience = Work_Experience;
        this.client = client;
    }
}
