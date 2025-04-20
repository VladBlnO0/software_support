package lab;

import java.util.concurrent.ConcurrentHashMap;

public class UserProfileManager {
    private ConcurrentHashMap<String, UserProfile> users = new ConcurrentHashMap<>();

    public void addUser(String username, String email) {
        users.put(username, new UserProfile(username, email));
    }

    public void updateEmail(String username, String newEmail) {
        if (users.containsKey(username)) {
            users.get(username).setEmail(newEmail);
        }
    }

    public void removeUser(String username) {
        users.remove(username);
    }

    public void printAllUsers() {
        users.values().forEach(System.out::println);
    }
}
