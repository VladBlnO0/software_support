package main;

public class Dispatcher {
    private final String Company_Name, Address, Phone_Number;
    private final String Full_Name;

    public String getCompany_Name() {
        return Company_Name;
    }

    private final int Work_Experience;
    public Client client;

    public Dispatcher(String Company_Name, String Address, String Phone_Number, String Full_Name, String Work_Experience, Client client) {

        if (Company_Name == null || Company_Name.isEmpty() || Company_Name.length() > 500) {throw new IllegalArgumentException("Invalid data");}
        else {this.Company_Name = Company_Name;}

        if (Address == null || Address.isEmpty() || Address.length() > 500) {throw new IllegalArgumentException("Invalid data");}
        else {this.Address = Address;}

        if (Phone_Number == null || Phone_Number.isEmpty() || Phone_Number.length() > 500) {throw new IllegalArgumentException("Invalid data");}
        else {this.Phone_Number = Phone_Number;}

        if (Full_Name == null || Full_Name.isEmpty() || Full_Name.length() > 500) {throw new IllegalArgumentException("Invalid data");}
        else {this.Full_Name = Full_Name;}

        if (Work_Experience == null) {
            throw new IllegalArgumentException("Invalid data");
        }
        try {
            this.Work_Experience = Integer.parseInt(Work_Experience);
            if (this.Work_Experience < 1 || this.Work_Experience > 1e4) {
                throw new IllegalArgumentException("Invalid data");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid data");
        }

        this.client = client;
    }

}
