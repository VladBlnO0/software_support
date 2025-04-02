package main;

public class Dispatcher {
    Client client;

    Dispatcher(String Company_Name, String Address, String Phone_Number, String Full_Name, int Work_Experience, Client client) {
        this.client = client;
    }
}
