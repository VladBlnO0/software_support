package test;

import main.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ContractIDComparatorTest {
    @Test
    void SortedByContract() {
        Contract contract1 = new Contract("Consumer", "12", "Dispatch_Station", "Arrival_Station", "12.1", "01.01.2025");
        Contract contract2 = new Contract("Consumer", "12", "Dispatch_Station", "Arrival_Station", "12.1", "01.01.2025");
        contract1.setContract_Id(2);
        contract2.setContract_Id(1);

        Client client1 = new Client("Company_Name", "Address", "Phone_Number","Second_Phone_Number", contract1);
        Client client2 = new Client("Company_Name", "Address", "Phone_Number","Second_Phone_Number", contract2);

        Dispatcher d1 = new Dispatcher("Comp", "Addr", "Phone", "Full Name", "5", client1);
        Dispatcher d2 = new Dispatcher("Comp", "Addr", "Phone", "Full Name", "5", client2);

        ArrayList<Dispatcher> dispatchers = new ArrayList<>(List.of(d1, d2));

        new ContractIDComparator(dispatchers);

        Assertions.assertEquals(1, dispatchers.get(0).client.contr.getContract_Id());
        Assertions.assertEquals(2, dispatchers.get(1).client.contr.getContract_Id());
    }
}
