package test;

import main.Client;
import main.Contract;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContractTest {
    @Test
    void testValidClientCreation() {
        Contract contract = new Contract("Consumer", "12", "Con_Dispatch_Station", "Con_Arrival_Station", "12.5", "2024-04-01");

        assertEquals("Con_Arrival_Station", contract.getArrival_Station());
    }

    @Test
    void testClassCreationWithValidData() {
        Contract contract = new Contract("Consumer", "12", "Con_Dispatch_Station", "Con_Arrival_Station", "12.5", "2024-04-01");

        assertNotNull(contract, "The class should be created successfully");
    }

    @Test
    void testClassCreationWithInvalidData() {
        assertThrows(IllegalArgumentException.class, () -> {
            Contract contract = new Contract("Consumer", "12", "Con_Dispatch_Station", "Con_Arrival_Station", "12.5", "2024-04-01");
        }, "The class should throw an exception when created with invalid data");
    }

    @Test
    void testClassCreationWithNullData() {
        assertThrows(IllegalArgumentException.class, () -> {
            Contract contract = new Contract("Consumer", "12", "Con_Dispatch_Station", "Con_Arrival_Station", "12.5", "2024-04-01");

        }, "The class should throw an exception when created with invalid data");
    }
    @Test
    void getArrival_Station() {
    }

    @Test
    void getDelivery_Time() {
    }

    @Test
    void getContract_Id() {
    }

    @Test
    void info() {
    }


//
//    @Test
//    void testClassCreationWithValidData() {
//        Client client = new Client("Cli_Company_Name", null, "Cli_Phone_Number","2Cli_Phone_Number", contract);
//
//        assertNotNull(client, "The class should be created successfully");
//    }
//
//    @Test
//    void testClassCreationWithInvalidData() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            Client client = new Client("Cli_Company_Name", null, "Cli_Phone_Number","2Cli_Phone_Number", contract);
//
//        }, "The class should throw an exception when created with invalid data");
//    }
//
//    @Test
//    void testClassCreationWithNullData() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            Client client = new Client("Cli_Company_Name", null, "Cli_Phone_Number","2Cli_Phone_Number", contract);
//
//        }, "The class should throw an exception when created with invalid data");
//    }
//
//    @Test
//    void testInvalidWeightInput() {
//        assertThrows(NumberFormatException.class, () -> {
//            Double.parseDouble("notANumber");
//        });
//    }
}