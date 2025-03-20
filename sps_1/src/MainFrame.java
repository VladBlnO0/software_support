//Deleted not used import
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MainFrame extends JFrame {
    //Grouped by type
    private JTabbedPane Create_DeletePane;
    private JTextField D_Phone_NumberTextField,
            D_Full_NameTextField,
            D_Company_NameTextField,
            D_AddressTextField,
            D_Work_ExperienceTextField,
            Con_WeightTextField,
            Cli_Company_NameTextField,
            Cli_AddressTextField,
            Cli_Phone_NumberTextField;
    private JComboBox Con_Type_of_CargoComboBox,
            Classes_ComboBox,
            Requests_ComboBox;
    private JTextField Con_Delivery_TimeTextField,
            Con_Dispatch_StationTextField,
            Con_Arrival_StationTextField,
            Con_Date_of_ConclusionTextField;
    private JButton CreateButton,
            DeleteButton,
            RequestButton,
            ShowButton;
    private JPanel myFrame;

    interface Printable {
        void Show(Person obj);
    }

    //Deleted Cost_Calc

    static class Insurance_Amount_Calc {
        private String[] Cargo_List = {"Consumer", "Special", "Hazardous"};

        public double Insurance_Calc(String cargo, double cost) {
            return switch (cargo) {
                case "Consumer" -> cost / 25;
                case "Special" -> cost / 35;
                case "Hazardous" -> cost / 50;
                default -> cost / 15;
            };
        }
    }

    abstract class Person {
        private String Company_Name;

        public String getCompany_Name() {
            return Company_Name;
        }

        private String Address;

        public String getAddress() {
            return Address;
        }

        private String Phone_Number;

        public String getPhone_Number() {
            return Phone_Number;
        }

        Person(String Company_Name, String Address, String Phone_Number) {
            this.Company_Name = Company_Name;
            this.Address = Address;
            this.Phone_Number = Phone_Number;
        }
    }

    class Dispatcher extends Person implements Printable {
        private Client client;
        private String Full_Name;
        private int Work_Experience;

        Dispatcher(String D_Company_Name,
                   String D_Address,
                   String D_Phone_Number,
                   String Full_Name,
                   int Work_Experience,
                   String C_Company_Name,
                   String C_Address,
                   String C_Phone_Number,
                   String Type_of_Cargo,
                   int Delivery_Time,
                   String Dispatch_Station,
                   String Arrival_Station,
                   double Weight,
                   String Date_of_Conclusion) {
            super(D_Company_Name, D_Address, D_Phone_Number);
            this.Full_Name = Full_Name;
            this.Work_Experience = Work_Experience;
            this.client = new Client(C_Company_Name,
                    C_Address,
                    C_Phone_Number,
                    Type_of_Cargo,
                    Delivery_Time,
                    Dispatch_Station,
                    Arrival_Station,
                    Weight,
                    Date_of_Conclusion);
        }

        public void Show(Person obj) {
            System.out.printf("%n%nDispatcher%nCompany name: %s", obj.getCompany_Name());
            System.out.printf("%nDispatcher name: %s", Full_Name);
            System.out.printf("%nAddress: %s", obj.getAddress());
            System.out.printf("%nPhone number: %s", obj.getPhone_Number());
            System.out.printf("%nWork experience: %s", Work_Experience);
            client.Show(obj);
        }
    }

    class Client extends Person implements Printable {
        private Contract contr;
        public int Contract_Id;

        Client(String Company_Name,
               String Address,
               String Phone_Number,
               String Type_of_Cargo,
               int Delivery_Time,
               String Dispatch_Station,
               String Arrival_Station,
               double Weight,
               String Date_of_Conclusion) {
            super(Company_Name, Address, Phone_Number);
            this.Contract_Id = ThreadLocalRandom.current().nextInt(1000, 8000 + 1);
            this.contr = new Contract(Type_of_Cargo,
                    Delivery_Time,
                    Dispatch_Station,
                    Arrival_Station,
                    Weight,
                    Date_of_Conclusion,
                    Contract_Id);
        }

        @Override
        public void Show(Person obj) {
            System.out.printf("%n%nClient%nCompany name: %s", obj.getCompany_Name());
            System.out.printf("%nAddress: %s", obj.getAddress());
            System.out.printf("%nPhone number: %s", obj.getPhone_Number());
            System.out.printf("%nContract Id: %d", Contract_Id);
            contr.Info();
        }

        public int getContract_Id() {
            return Contract_Id;
        }
    }

    class Contract {
        private double Insurance_Amount;
        private String Type_of_Cargo;
        private int Delivery_Time;
        private String Dispatch_Station;
        private String Arrival_Station;
        private double Cost;
        private double Weight;
        private String Date_of_Conclusion;
        public int Contract_Id;

        public Contract(String Type_of_Cargo, int Delivery_Time, String Dispatch_Station,
                        String Arrival_Station, double Weight, String Date_of_Conclusion, int Contract_Id) {
            Insurance_Amount_Calc calc2 = new Insurance_Amount_Calc();
            this.Type_of_Cargo = Type_of_Cargo;
            this.Delivery_Time = Delivery_Time;
            this.Dispatch_Station = Dispatch_Station;
            this.Arrival_Station = Arrival_Station;
            this.Weight = Weight;
            this.Cost = Weight * 1.5;
            this.Insurance_Amount = calc2.Insurance_Calc(Type_of_Cargo, this.Cost);
            this.Date_of_Conclusion = Date_of_Conclusion;
            this.Contract_Id = Contract_Id;
        }

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

        public String getArrival_Station() {
            return Arrival_Station;
        }

        public int getDelivery_Time() {
            return Delivery_Time;
        }
    }

    ArrayList<Dispatcher> dispatchers = new ArrayList<>();

    public MainFrame() {
        setContentPane(myFrame);
        setTitle("Rail Transport");
        setSize(500, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        CreateButton.addActionListener(e -> {
            String D_Company_Name = D_Company_NameTextField.getText();
            String D_Address = D_AddressTextField.getText();
            String D_Phone_Number = D_Phone_NumberTextField.getText();
            String D_Full_Name = D_Full_NameTextField.getText();
            int D_Work_Experience = Integer.parseInt(D_Work_ExperienceTextField.getText());
            String Cli_Company_Name = Cli_Company_NameTextField.getText();
            String Cli_Address = Cli_AddressTextField.getText();
            String Cli_Phone_Number = Cli_Phone_NumberTextField.getText();
            String Con_Type_of_Cargo = String.valueOf(Con_Type_of_CargoComboBox.getSelectedItem());
            int Con_Delivery_Time = Integer.parseInt(Con_Delivery_TimeTextField.getText());
            String Con_Dispatch_Station = Con_Dispatch_StationTextField.getText();
            String Con_Arrival_Station = Con_Arrival_StationTextField.getText();
            double Con_Weight = Double.parseDouble(Con_WeightTextField.getText());
            String Con_Date_of_Conclusion = Con_Date_of_ConclusionTextField.getText();
            Dispatcher new_disp = new Dispatcher(D_Company_Name, D_Address, D_Phone_Number, D_Full_Name, D_Work_Experience,
                    Cli_Company_Name, Cli_Address, Cli_Phone_Number,
                    Con_Type_of_Cargo, Con_Delivery_Time, Con_Dispatch_Station, Con_Arrival_Station, Con_Weight, Con_Date_of_Conclusion);
            dispatchers.add(new_disp);
            String name = new_disp.client.getContract_Id() + ".txt";
            try (FileWriter writer = new FileWriter(name, false)) {
                writer.write("\nContract Id: " + new_disp.client.getContract_Id());
                writer.write("\n\tDispatcher");
                writer.write("\nCompany Name: " + D_Company_Name);
                writer.write("\nAddress: " + D_Address);
                writer.write("\nPhone Number: " + D_Phone_Number);
                writer.write("\nFull Name: " + D_Full_Name);
                writer.write("\nWork Experience: " + String.valueOf(D_Work_Experience));
                writer.write("\n\tClient");
                writer.write("\nCompany Name: " + Cli_Company_Name);
                writer.write("\nAddress: " + Cli_Address);
                writer.write("\nPhone Number: " + Cli_Phone_Number);
                writer.write("\n\tContract");
                writer.write("\nType of Cargo: " + Con_Type_of_Cargo);
                writer.write("\nDelivery Time: " + Con_Delivery_Time);
                writer.write("\nDispatch Station: " + Con_Dispatch_Station);
                writer.write("\nArrival Station: " + Con_Arrival_Station);
                writer.write("\nWeight: " + Con_Weight);
                writer.write("\nDate of Conclusion: " + Con_Date_of_Conclusion);
                writer.flush();
            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }
            Classes_ComboBox.addItem(new_disp.client.getContract_Id());
        });
        DeleteButton.addActionListener(e -> {
            String Filename = String.valueOf(dispatchers.get(Classes_ComboBox.getSelectedIndex()).client.getContract_Id()) + ".txt";
            File file = new File(Filename);
            file.delete();
            dispatchers.remove(Classes_ComboBox.getSelectedIndex());
            Classes_ComboBox.removeItem(Classes_ComboBox.getSelectedItem());
        });
        ShowButton.addActionListener(e -> {
            String Filename = dispatchers.get(Classes_ComboBox.getSelectedIndex()).client.getContract_Id() + ".txt";
            File file = new File(Filename);
            try {
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();
            } catch (FileNotFoundException e1) {
                System.out.println("An error occurred.");
            }
        });
        RequestButton.addActionListener(e -> {
            int ch = Requests_ComboBox.getSelectedIndex();
            switch (ch) {
                case 0:
                    //List of contracts
                    for (Dispatcher value : dispatchers) {
                        System.out.printf("%n%n%nContract Id: %d", value.client.getContract_Id());
                        value.client.contr.Info();
                    }
                    break;
                case 1:
                    //List of arrival stations
                    for (Dispatcher value : dispatchers) {
                        System.out.printf("%n%n%nContract Id: %d", value.client.getContract_Id());
                        System.out.printf("%nArrival Station: %s", value.client.contr.getArrival_Station());
                    }
                    break;
                case 2:
                    //List of customer companies
                    for (Dispatcher value : dispatchers) {
                        System.out.printf("%n%n%nContract Id: %d", value.client.getContract_Id());
                        System.out.printf("%nCustomer Companies: %s", value.client.getCompany_Name());
                    }
                    break;
                case 3:
                    //The longest delivery time
                    int max = dispatchers.get(0).client.contr.getDelivery_Time();
                    for (Dispatcher value : dispatchers) {
                        if (value.client.contr.getDelivery_Time() > max)
                            max = value.client.contr.getDelivery_Time();
                    }
                    System.out.printf("%n%n%nThe longest delivery time: %d", max);
                    break;
                case 4:
                    //Arrival station with the highest demand
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
                    break;
                case 5:
                    //Average delivery time
                    double sum = 0;
                    for (Dispatcher dispatcher : dispatchers) {
                        sum += dispatcher.client.contr.getDelivery_Time();
                    }
                    double ave = (sum / dispatchers.size());
                    System.out.printf("%n%n%nAverage delivery time: %8.2f", ave);
                    break;
            }
        });
    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
    }
}