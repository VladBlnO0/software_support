package lab;

import java.util.List;

public class Filter {
    public void printOlderThan(List<UserProfile> people, int minAge) {
        people.stream()
                .filter(p -> p.getAge() > minAge)
                .forEach(p -> System.out.println(p.getUsername() + ": " + p.getAge()));
    }
}
