package lab;

public class Main {
    public static void main(String[] args) {
        UserProfileManager manager = new UserProfileManager();

        manager.addUser("alice", "alice@example.com");
        manager.addUser("bob", "bob#email.com"); // неправильний email

        manager.printAllUsers();

        // Перевірка email
        System.out.println("alice valid: " + EmailValidator.isValid("alice@example.com"));
        System.out.println("bob valid: " + EmailValidator.isValid("bob#email.com"));
    }
}
