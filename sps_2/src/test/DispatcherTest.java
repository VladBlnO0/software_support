package test;

import main.Client;
import main.Contract;
import main.Dispatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DispatcherTest {
    Contract contract = new Contract("Consumer", "12", "Dispatch_Station", "Arrival_Station", "12.12", "01.01.2025");
    Client client = new Client("Company_Name", "Address", "Phone_Number","Second_Phone_Number", contract);

    @Test
    void testValidClientCreation() {
        Dispatcher disp = new Dispatcher("Company_Name", "Address", "Phone_Number", "Full_Name", "12", client);

        Assertions.assertEquals("Company_Name", disp.getCompany_Name());
    }

    @Test
    void testInvalidClientCreation() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Dispatcher(null, "Address", "Phone_Number", "Full_Name", "12", client);
        }, "The class should throw an exception");
    }

    @Test
    void testNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Dispatcher("", "Address", "Phone_Number", "Full_Name", "12", client);
        });
    }
}