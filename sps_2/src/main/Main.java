package main;

import java.util.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ArrayList<Dispatcher> dispatchers = new ArrayList<>();

        Contract contract = new Contract("Consumer", 12, "Con_Dispatch_Station", "Con_Arrival_Station", 12.5, "Con_Date_of_Conclusion");
        Client client = new Client("Cli_Company_Name", "Cli_Address", "Cli_Phone_Number", contract);
        Dispatcher new_disp = new Dispatcher("Company", "D_Address", "D_Phone_Number", "D_Full_Name", 12, client);

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

