package test;

import main.Client;
import main.Contract;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ClientTest {
    Contract contract = new Contract("Consumer", "12", "Dispatch_Station", "Arrival_Station", "12.12", "01.01.2025");

    @Test
    void testValidClientCreation() {
        Client client = new Client("Company_Name", "Address", "Phone_Number","Second_Phone_Number", contract);

        Assertions.assertEquals("Company_Name", client.getCompany_Name());
    }

    @Test
    void testInvalidClientCreation() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Client client = new Client(null, "Address", "Phone_Number","Second_Phone_Number", contract);
        }, "The class should throw an exception");
    }

    @Test
    void testNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Client("", "Address", "Phone_Number", "Second_Phone_Number", contract);
        });
    }

}