import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program estimates the square root of a positive double.
 *
 *
 */
public final class Newton1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton1() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        double r = x;
        r = (r + (x / r)) / 2;
        final double ERROR = .0001;

        while (((r * r) - x) / x > ERROR) {
            r = (r + (x / r)) / 2;
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

        out.print("Would you like to calculate a square root? ");
        String choice = in.nextLine();

        // Loops until user would not like to compute another sqrt then quits
        while (choice.equals("y")) {
            out.print("Enter a positive number: ");
            double num = Integer.parseInt(in.nextLine());
            double squareRoot = sqrt(num);
            out.println("The square root of " + num + " is " + squareRoot);
            out.print("Would you like to calculate another square root? ");
            choice = in.nextLine();
        }

        in.close();
        out.close();
    }

}
