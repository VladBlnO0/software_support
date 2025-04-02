package test;

import main.Client;
import main.Contract;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class ClientTest {
    @Test
    void testValidClientCreation() {
        Contract contract = new Contract("Consumer", "12", "Con_Dispatch_Station", "Con_Arrival_Station", "12.5", "2024-04-01");
        Client client = new Client("Cli_Company_Name", "Cli_Address", "Cli_Phone_Number","2Cli_Phone_Number", contract);

        assertEquals("Cli_Company_Name", client.getCompany_Name());
        assertEquals("Cli_Company_Name", client.getCompany_Name());
    }

    @Test
    void testNegativeDeliveryTime() {
        Contract contract = new Contract("Cargo", null, "Start", "End", 100.5, "2024-04-01");
        assertTrue(contract.getDelivery_Time() < 0); // or test exception if you throw one
    }
//
//    @Test
//    void testInvalidWeightInput() {
//        assertThrows(NumberFormatException.class, () -> {
//            Double.parseDouble("notANumber");
//        });
//    }
}