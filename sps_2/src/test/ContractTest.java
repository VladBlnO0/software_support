package test;

import main.Client;
import main.Contract;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContractTest {

    @Test
    void testValidClientCreation() {
        Contract contract = new Contract("Consumer", "12", "Dispatch_Station", "Arrival_Station", "12.1", "01.01.2025");
        Assertions.assertEquals("Arrival_Station", contract.getArrival_Station());
    }

    @Test
    void testInvalidClientCreation() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contract contract = new Contract("Consumer", "12", "Dispatch_Station", null, "12.1", "01.01.2025");
        }, "The class should throw an exception");
    }

    @Test
    void testNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contract("Consumer", "12", "Dispatch_Station", "", "12.1", "01.01.2025");
        });
    }
}