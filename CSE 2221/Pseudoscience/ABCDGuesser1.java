import java.util.Arrays;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Program takes 17 exponents and attempts to estimate any number using 4 other
 * numbers assigned with exponents in the Jager set within a .01 error.
 *
 *
 * @author 
 *
 */
public final class ABCDGuesser1 {

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        out.print("Enter a positve real value for μ: ");
        String input = in.nextLine();
        boolean check = FormatChecker.canParseDouble(input);

        while (!check) { // loop runs if input is not a double
            out.print("Enter only a positve real value for μ: ");
            input = in.nextLine();
            check = FormatChecker.canParseDouble(input);
        }
        double μ = Double.parseDouble(input);

        return μ;

    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        out.print(
                "Enter a positve real number that is personal to you (not 1.0): ");
        String input = in.nextLine();
        boolean check = FormatChecker.canParseDouble(input);
        double num = Double.parseDouble(input);

        while (!check || (num > 0.99 && num < 1.001)) { // loop runs if input is not a double or is 1.0
            out.print(
                    "Enter only a positve real number (not 1.0) that is personal to you: ");
            input = in.nextLine();
            num = Double.parseDouble(input);
            check = FormatChecker.canParseDouble(input);
        }

        return num;

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
        double[] jager = { -5, -4, -3, -2, -1, -0.5, -0.333333, -0.25, 0, 0.25,
                0.333333, 0.5, 1, 2, 3, 4, 5 }; // possible exponent values
        double[] exponents = new double[4];

        double μ = getPositiveDouble(in, out);
        double w = getPositiveDoubleNotOne(in, out);
        double x = getPositiveDoubleNotOne(in, out);
        double y = getPositiveDoubleNotOne(in, out);
        double z = getPositiveDoubleNotOne(in, out);

        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        double error = 1;
        double minError = .01;
        double estimate = 0;
        double finalEstimate = 0;
        double finalError = 0;
// The following loops run through all possible combinations of the Jager exponents
        while (d < 17) {
            while (c < 17) {
                while (b < 17) {
                    while (a < 17) {
                        // estimates the number with each exponent combination
                        estimate = Math.pow(w, jager[a]) * Math.pow(x, jager[b])
                                * Math.pow(y, jager[c]) * Math.pow(z, jager[d]);

                        error = Math.abs(μ - estimate) / μ; // calculates the error
                        if (error < minError) { //executes when the best exponents are found
                            minError = error;
                            exponents[0] = jager[a];
                            exponents[1] = jager[b];
                            exponents[2] = jager[c];
                            exponents[3] = jager[d];
                            finalEstimate = estimate;
                            finalError = error;

                        }
                        a = a + 1;
                    }

                    a = 0;
                    // estimates the number with each exponent combination
                    estimate = (Math.pow(w, jager[a])) * (Math.pow(x, jager[b]))
                            * (Math.pow(y, jager[c])) * (Math.pow(z, jager[d]));
                    error = Math.abs(μ - estimate) / μ; // calculates the error
                    b = b + 1;

                }

                a = 0;
                b = 0;
                // estimates the number with each exponent combination
                estimate = (Math.pow(w, jager[a])) * (Math.pow(x, jager[b]))
                        * (Math.pow(y, jager[c])) * (Math.pow(z, jager[d]));
                error = Math.abs(μ - estimate) / μ; //calculates the error
                c = c + 1;

            }

            a = 0;
            b = 0;
            c = 0;
            // estimates the number with each exponent combination
            estimate = (Math.pow(w, jager[a])) * (Math.pow(x, jager[b]))
                    * (Math.pow(y, jager[c])) * (Math.pow(z, jager[d]));

            error = Math.abs(μ - estimate) / μ; //calculates the error
            d = d + 1;
        }

        // Printing Results
        boolean scientific = false;
        out.println("The estimate of your number is: " + finalEstimate);
        String values = Arrays.toString(exponents);
        out.println("The values of the exponents used: " + values);
        out.print("The error value is: ");
        out.print(finalError, 2, scientific);
        out.print("%");

        /*
         * Put your main program code here
         */
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
