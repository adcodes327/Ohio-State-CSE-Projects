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
 */
public final class ABCDGuesser2 {

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

        while (!check) { // only executes if input is not valid
            out.print("Enter a positve real value for μ: ");
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

        while (!check && !input.equals("1.0")) { // only executes if input is not a double or 1.0
            out.print(
                    "Enter a positve real number (not 1.0) that is personal to you: ");
            input = in.nextLine();
            check = FormatChecker.canParseDouble(input);
        }
        double num = Double.parseDouble(input);

        return num;

    }

    /**
     * Finds the error between the calculated number and the number that is
     * attempting to be matched by the program.
     *
     * @param mu
     *            number chosen by user
     * @param out
     *            number calculated by Jager exponents from personal numbers
     * @return error value for every possible combination of exponents
     */
    private static double getError(double μ, double estimate) {
        double error = Math.abs(μ - estimate) / μ;
        return error;
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
                0.333333, 0.5, 1, 2, 3, 4, 5 }; // Jager exponents
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
        double percentError = 0;

// The following loops run through every possible combination of exponents
        for (d = 0; d < 17; d++) {
            for (c = 0; c < 17; c++) {
                for (b = 0; b < 17; b++) {
                    for (a = 0; a < 17; a++) {
                        // estimates the number with each exponent combination
                        estimate = Math.pow(w, jager[a]) * Math.pow(x, jager[b])
                                * Math.pow(y, jager[c]) * Math.pow(z, jager[d]);

                        error = getError(μ, estimate); // calculates the error
                        if (error < minError) { // only executes for best possible combination
                            minError = error;
                            exponents[0] = jager[a];
                            exponents[1] = jager[b];
                            exponents[2] = jager[c];
                            exponents[3] = jager[d];
                            finalEstimate = estimate;
                            finalError = error * 1000;
                            percentError = Math.round(finalError);

                        }

                    }

                    a = 0;
                    // estimates the number with each exponent combination
                    estimate = (Math.pow(w, jager[a])) * (Math.pow(x, jager[b]))
                            * (Math.pow(y, jager[c])) * (Math.pow(z, jager[d]));
                    error = getError(μ, estimate); // calculates the error

                }

                a = 0;
                b = 0;
                // estimates the number with each exponent combination
                estimate = (Math.pow(w, jager[a])) * (Math.pow(x, jager[b]))
                        * (Math.pow(y, jager[c])) * (Math.pow(z, jager[d]));

                error = getError(μ, estimate); // calculates the error

            }

            a = 0;
            b = 0;
            c = 0;
            // estimates the number with each exponent combination
            estimate = (Math.pow(w, jager[a])) * (Math.pow(x, jager[b]))
                    * (Math.pow(y, jager[c])) * (Math.pow(z, jager[d]));

            error = getError(μ, estimate); // calculates the error

        }

        // Printing results
        boolean scientific = false;
        out.println("The estimate of your number is: " + finalEstimate);
        String values = Arrays.toString(exponents);
        out.println("The values of the exponents used: " + values);
        out.println("The error value is: " + percentError + "%");
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
