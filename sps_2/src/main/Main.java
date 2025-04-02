package main;

import java.util.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String D_Company_Name = "Company";
        String D_Address = "D_Address";
        String D_Phone_Number = "D_Phone_Number";
        String D_Full_Name = "D_Full_Name";
        int D_Work_Experience = Integer.parseInt("12");
        String Cli_Company_Name = "Cli_Company_Name";
        String Cli_Address = "Cli_Address";
        String Cli_Phone_Number = "Cli_Phone_Number";
        String Con_Type_of_Cargo = "Consumer";
        int Con_Delivery_Time = Integer.parseInt("12");
        String Con_Dispatch_Station = "Con_Dispatch_Station";
        String Con_Arrival_Station = "Con_Arrival_Station";
        double Con_Weight = Double.parseDouble("12.5");
        String Con_Date_of_Conclusion = "Con_Date_of_Conclusion";

        ArrayList<Dispatcher> dispatchers = new ArrayList<>();

        Contract contract = new Contract(Con_Type_of_Cargo, Con_Delivery_Time, Con_Dispatch_Station, Con_Arrival_Station, Con_Weight, Con_Date_of_Conclusion);
        Client client = new Client(Cli_Company_Name, Cli_Address, Cli_Phone_Number, contract);
        Dispatcher new_disp = new Dispatcher(D_Company_Name, D_Address, D_Phone_Number, D_Full_Name, D_Work_Experience, client);

        dispatchers.add(new_disp);
        //dispatchers.remove(new_disp);

        Scanner input = new Scanner(System.in);

        int ch;
        do {
            System.out.println("\n");

            ch = input.nextInt();
            switch (ch) {
                case 0:
                    //List of contracts
                    ListContracts(dispatchers);
                    break;
                case 1:
                    //List of arrival stations
                    ListStations(dispatchers);
                    break;
                case 2:
                    //List of customer companies
                    ListCompanies(dispatchers);
                    break;
                case 3:
                    //The longest delivery time
                    LongestTime(dispatchers);
                    break;
                case 4:
                    //Arrival station with the highest demand
                    HighestDemand(dispatchers);
                    break;
                case 5:
                    //Average delivery time
                    AverageTime(dispatchers);
                    break;
            }
        } while (ch!=9);

    }
    private static void ListContracts(ArrayList <Dispatcher> dispatchers) {
        for (Dispatcher value : dispatchers) {
            System.out.printf("%n%n%nContract Id: %d", value.client.contr.getContract_Id());
            value.client.contr.Info();
        }
    }
    private static void ListStations (ArrayList <Dispatcher> dispatchers) {
        for (Dispatcher value : dispatchers) {
            System.out.printf("%n%n%nContract Id: %d", value.client.contr.getContract_Id());
            System.out.printf("%nArrival Station: %s", value.client.contr.getArrival_Station());
        }
    }
    private static void ListCompanies (ArrayList <Dispatcher> dispatchers) {
        for (Dispatcher value : dispatchers) {
            System.out.printf("%n%n%nContract Id: %d", value.client.contr.getContract_Id());
            System.out.printf("%nCustomer Companies: %s", value.client.contr.getContract_Id());
        }
    }
    private static void LongestTime (ArrayList <Dispatcher> dispatchers) {
        int max = dispatchers.getFirst().client.contr.getDelivery_Time();
        for (Dispatcher value : dispatchers) {
            if (value.client.contr.getDelivery_Time() > max)
                max = value.client.contr.getDelivery_Time();
        }
        System.out.printf("%n%n%nThe longest delivery time: %d", max);
    }
    private static void HighestDemand (ArrayList <Dispatcher> dispatchers) {
        ArrayList<String> arr = new ArrayList<>();
        for (Dispatcher value : dispatchers) {
            arr.add(value.client.contr.getArrival_Station());
        }
        int max_count = 0;
        String highest = "-";
        for (int i = 0; i < dispatchers.size(); i++) {
            int count = 0;
            for (int j = 0; j < dispatchers.size(); j++) {
                if (Objects.equals(arr.get(i), arr.get(j))) {
                    count++;
                }
            }
            if (count > max_count) {
                max_count = count;
                highest = arr.get(i);
            }
        }
        System.out.printf("%n%n%nArrival station with the highest demand: %s", highest);
    }
    private static void AverageTime(ArrayList <Dispatcher> dispatchers) {
        double sum = 0;
        for (Dispatcher dispatcher : dispatchers) {
            sum += dispatcher.client.contr.getDelivery_Time();
        }
        double ave = (sum / dispatchers.size());
        System.out.printf("%n%n%nAverage delivery time: %8.2f", ave);
    }
}

