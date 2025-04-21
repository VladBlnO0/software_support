package lab;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception  {
        UserProfileManager manager = new UserProfileManager();

        manager.addUser("alice", "alice@example.com", 28);
        manager.addUser("bob", "bob#email.com", 17); // неправильний email

        manager.printAllUsers();

        // Перевірка email
        System.out.println("alice valid: " + EmailValidator.isValid("alice@example.com"));
        System.out.println("bob valid: " + EmailValidator.isValid("bob#email.com"));


        String json =
                "[" +
                "{\"username\": \"Alice\",  \"email\":\"alice@example.com\",  \"age\":25}," +
                "{\"username\": \"Bob\",    \"email\":\"alice@example.com\",  \"age\":30}," +
                "{\"username\": \"Eve\",    \"email\":\"alice@example.com\",  \"age\":19}" +
                "]";

        JSON parser = new JSON();
        List<UserProfile> people = parser.parse(json);

        Filter filter = new Filter();
        filter.printOlderThan(people, 20);
    }
}
