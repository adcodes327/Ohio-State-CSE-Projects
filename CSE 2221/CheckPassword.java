import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class CheckPassword {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CheckPassword() {
    }

    /**
     * Checks whether the given String satisfies the OSU criteria for a valid
     * password. Prints an appropriate message to the given output stream.
     *
     * @param s
     *            the String to check
     * @param out
     *            the output stream
     */
    private static void checkPassword(String s, SimpleWriter out) {
        int meetsRequirement = 0;

        // Requirement 1
        boolean length = s.length() >= 8;

        //Requirements 2
        boolean upperCase = containsUpperCaseLetter(s);
        if (upperCase) {
            ++meetsRequirement;
        }
        boolean lowerCase = containsLowerCaseLetter(s);
        if (lowerCase) {
            ++meetsRequirement;
        }

        boolean digit = containsDigits(s);
        if (digit) {
            ++meetsRequirement;
        }
        boolean specialChar = containsSpecialChar(s);
        if (specialChar) {
            ++meetsRequirement;
        }

        if (length && meetsRequirement >= 3) {
            out.print("Your password is valid");
        } else {
            out.print("Your password in invalid");
        }

    }

    /**
     * Checks if the given String contains an upper case letter.
     *
     * @param s
     *            the String to check
     * @return true if s contains an upper case letter, false otherwise
     */
    private static boolean containsUpperCaseLetter(String s) {
        int n = 0;
        boolean contains = false;
        for (int i = 0; i < s.length(); i++) {
            char check = s.charAt(i);
            boolean uppercase = Character.isUpperCase(check);
            if (uppercase) {
                ++n;
            }

        }
        if (n > 0) {
            contains = true;
        }
        return contains;

    }

    private static boolean containsLowerCaseLetter(String s) {
        int n = 0;
        boolean contains = false;
        for (int i = 0; i < s.length(); i++) {
            char check = s.charAt(i);
            boolean lowerCase = Character.isLowerCase(check);
            if (lowerCase) {
                ++n;
            }

        }
        if (n > 0) {
            contains = true;
        }
        return contains;

    }

    private static boolean containsDigits(String s) {
        int n = 0;
        boolean contains = false;
        for (int i = 0; i < s.length(); i++) {
            char check = s.charAt(i);
            if (check == '0' | check == '1' || check == '2' || check == '3'
                    || check == '4' || check == '5' || check == '6'
                    || check == '7' || check == '8' || check == '9') {
                ++n;
            }

        }
        if (n > 0) {
            contains = true;
        }
        return contains;

    }

    private static boolean containsSpecialChar(String s) {
        int n = 0;
        boolean contains = false;
        for (int i = 0; i < s.length(); i++) {
            char check = s.charAt(i);
            boolean uppercase = Character.isUpperCase(check);
            boolean lowercase = Character.isLowerCase(check);
            if (uppercase || lowercase) {
                ++n;
            }

        }
        if (s.length() - n != 0) {
            contains = true;
        }
        return contains;

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.print("Enter a password: ");
        String password = in.nextLine();
        checkPassword(password, out);

        // Close input and output streams

        in.close();
        out.close();
    }

}
