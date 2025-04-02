package main;

import java.util.concurrent.ThreadLocalRandom;

public class Contract {
    private final double Insurance_Amount, Cost, Weight;
    private final int Delivery_Time, Contract_Id;
    private final String Type_of_Cargo, Dispatch_Station, Arrival_Station, Date_of_Conclusion;

    Contract(String Type_of_Cargo, int Delivery_Time, String Dispatch_Station,
             String Arrival_Station, double Weight, String Date_of_Conclusion) {
        this.Type_of_Cargo = Type_of_Cargo;
        this.Delivery_Time = Delivery_Time;
        this.Dispatch_Station = Dispatch_Station;
        this.Arrival_Station = Arrival_Station;
        this.Weight = Weight;
        this.Cost = Weight * 1.5;
        this.Insurance_Amount = switch (Type_of_Cargo) {
            case "Consumer" -> Cost / 25;
            case "Special" -> Cost / 35;
            case "Hazardous" -> Cost / 50;
            default -> Cost / 15;
        };
        this.Contract_Id = ThreadLocalRandom.current().nextInt(1000, 8000 + 1);

        this.Date_of_Conclusion = Date_of_Conclusion;
    }
    public String getArrival_Station() {return Arrival_Station;}
    public int getDelivery_Time() {return Delivery_Time;}
    public int getContract_Id() {return Contract_Id;}

    void Info() {
        System.out.printf("%nInsurance amount: %4.2f", Insurance_Amount);
        System.out.printf("%nType of Cargo: %s", Type_of_Cargo);
        System.out.printf("%nDelivery time: %d", Delivery_Time);
        System.out.printf("%nDispatch station: %s", Dispatch_Station);
        System.out.printf("%nArrival station: %s", Arrival_Station);
        System.out.printf("%nCost: %4.2f", Cost);
        System.out.printf("%nWeight: %4.2f", Weight);
        System.out.printf("%nDate of Conclusion: %s", Date_of_Conclusion);
        System.out.printf("%nContract Id: %d", Contract_Id);
        System.out.printf("%n--------------------------------");
    }
}
