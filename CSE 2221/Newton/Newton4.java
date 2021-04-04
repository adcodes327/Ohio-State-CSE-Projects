import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program estimates the square root of a positive doubles and 0. User is able
 * to set their own error value and quits when a negative number is entered.
 *
 *
 */
public final class Newton4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton4() {
    }

    /**
     * Computes estimate of square root of x to within relative error chosen by
     * the user. Also works if the user attempts to find the square root of 0.
     *
     * @param x
     *            positive number or 0 to compute square root of
     * @param error
     *            determines range of accuracy for estimated square root
     *
     * @return estimate of square root
     */
    private static double sqrt(double x, double error) {

        double r = x;
        double zero = .0001;

        if (r < zero) {
            r = 0.0;
        } else {
            r = (r + (x / r)) / 2;

            while (((r * r) - x) / x > error) {
                r = (r + (x / r)) / 2;
            }
        }

        return r;
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
        double error = 0.0;

        out.print("Would you like to calculate a square root? ");
        String choice = in.nextLine();
        if (choice.equals("y")) {
            out.print("Enter an error value: ");
            error = Double.parseDouble(in.nextLine());

            out.print("Enter a positive number: ");
            double num = Double.parseDouble(in.nextLine());

            while (num >= 0) {
                double squareRoot = sqrt(num, error);
                out.println("The square root of " + num + " is " + squareRoot);
                out.print("Enter a new value:  ");
                num = Double.parseDouble(in.nextLine());
            }
        }

        in.close();
        out.close();
    }

}
