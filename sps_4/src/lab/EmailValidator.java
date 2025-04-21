package lab;

import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailValidator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
    );

    public static boolean isValid(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        boolean result = matcher.matches();

        if (!result) {
            logInvalidEmail(email);
        }

        return result;
    }

    private static void logInvalidEmail(String email) {
        try (FileWriter writer = new FileWriter("invalid_emails.log", true)) {
            writer.write("Invalid email: " + email + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
