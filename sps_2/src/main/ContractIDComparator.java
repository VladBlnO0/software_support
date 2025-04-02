package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ContractIDComparator {
    public ContractIDComparator(ArrayList<Dispatcher> dispatchers) {
        dispatchers.sort(Comparator.comparing(dispatcher -> dispatcher.client.contr.getContract_Id()));
        dispatchers.forEach(dispatcher -> dispatcher.client.contr.Info());
    }
}
