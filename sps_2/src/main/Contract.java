package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Contract {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    private static final Date MIN_DATE, MAX_DATE;
    static {
        try {
            MIN_DATE = DATE_FORMAT.parse("01.01.1970");
            MAX_DATE = DATE_FORMAT.parse("01.01.2040");
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format in static initializer", e);
        }
    }

    private final double Insurance_Amount;
    private final double Weight, Cost;

    private final int Contract_Id, Delivery_Time;
    private final String Type_of_Cargo, Dispatch_Station, Arrival_Station;
    private final Date Date_of_Conclusion;

    public Contract(String Type_of_Cargo, String Delivery_Time, String Dispatch_Station,
                    String Arrival_Station, String Weight, String Date_of_Conclusion) {
        this.Type_of_Cargo = Type_of_Cargo;

        if (Delivery_Time == null) {
            throw new IllegalArgumentException("Invalid data");
        }
        try {
            this.Delivery_Time = Integer.parseInt(Delivery_Time);
            if (this.Delivery_Time < 1 || this.Delivery_Time > 1e4) {
                throw new IllegalArgumentException("Invalid data");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid data");
        }

        if (Dispatch_Station == null || Dispatch_Station.length() < 1 || Dispatch_Station.length() > 500) {throw new IllegalArgumentException("Invalid data");}
        else if (Dispatch_Station == Arrival_Station) {throw new IllegalArgumentException("Equal Data");}
        else {this.Dispatch_Station = Dispatch_Station;}


        if (Arrival_Station == null || Arrival_Station.length() < 1 || Arrival_Station.length() > 500) {throw new IllegalArgumentException("Invalid data");}
        else if (Arrival_Station == Dispatch_Station) {throw new IllegalArgumentException("Equal Data");}
        else {this.Arrival_Station = Arrival_Station;}

        if (Weight == null) {
            throw new IllegalArgumentException("Data is invalid");
        }
        try {
            this.Weight = Double.parseDouble(Weight);
            if (this.Weight < 1 || this.Weight > 1e5) {
                throw new IllegalArgumentException("Invalid weightCargo value");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid data provided: ");
        }

        this.Cost = this.Weight * 1.5;
        this.Insurance_Amount = switch (Type_of_Cargo) {
            case "Consumer" -> this.Cost / 25;
            case "Special" -> this.Cost / 35;
            case "Hazardous" -> this.Cost / 50;
            default -> this.Cost / 15;
        };

        this.Contract_Id = ThreadLocalRandom.current().nextInt(1000, 8000 + 1);

        if (Date_of_Conclusion == null) {
            throw new IllegalArgumentException("Invalid data");
        }
        try {
            this.Date_of_Conclusion = DATE_FORMAT.parse(Date_of_Conclusion);
            if (this.Date_of_Conclusion.before(MIN_DATE) || this.Date_of_Conclusion.after(MAX_DATE)) {
                throw new IllegalArgumentException("Invalid data");
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid data");
        }

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
