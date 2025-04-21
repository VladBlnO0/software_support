package lab;

public class UserProfile {
    private String username;
    private String email;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserProfile() {}

    public UserProfile(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserProfile{ username= " + username + ", email= " + email + ", age= " + age;
    }
}
