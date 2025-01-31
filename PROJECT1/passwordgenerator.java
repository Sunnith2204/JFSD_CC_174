import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include digits? (y/n): ");
        boolean includeDigits = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("y");

        String password = generatePassword(length, includeUppercase, includeLowercase, includeDigits, includeSpecial);
        System.out.println("Generated Password: " + password);
    }

    private static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase,
                                           boolean includeDigits, boolean includeSpecial) {
        StringBuilder characterSet = new StringBuilder();

        if (includeLowercase) {
            characterSet.append(LOWERCASE);
        }
        if (includeUppercase) {
            characterSet.append(UPPERCASE);
        }
        if (includeDigits) {
            characterSet.append(DIGITS);
        }
        if (includeSpecial) {
            characterSet.append(SPECIAL_CHARACTERS);
        }

        if (characterSet.length() == 0) {
            throw new IllegalArgumentException("At least one character type must be selected.");
        }

        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(index));
        }

        return password.toString();
    }
}
