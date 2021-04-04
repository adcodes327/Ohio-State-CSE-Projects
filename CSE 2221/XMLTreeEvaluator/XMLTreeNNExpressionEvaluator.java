import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code NaturalNumber}.
 *
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        NaturalNumber value = new NaturalNumber2(0);
        if (exp.isTag() && exp.label().equals("number")) { // String to NaturalNumber
            value = new NaturalNumber2(exp.attributeValue("value"));
        } else {
            XMLTree left = exp.child(0); // left tree of child 0 of parent
            XMLTree right = exp.child(1); // right tree of child 1 of parent
            if (exp.label().equals("number")) {
                value = evaluate(left);
            } else if (exp.label().equals("divide")) { // evaluating division
                if (evaluate(right).isZero()) { // divide by zero error
                    components.utilities.Reporter
                            .fatalErrorToConsole("Divide by zero error.");
                }
                value.add(evaluate(left));
                value.divide(evaluate(right));
            } else if (exp.label().equals("times")) { // evaluating multiplication
                value.add(evaluate(left));
                value.multiply(evaluate(right));
            } else if (exp.label().equals("minus")) { // evaluating subtraction
                if (evaluate(right).compareTo(evaluate(left)) > 0) {
                    components.utilities.Reporter
                            .fatalErrorToConsole("Negative NN error.");
                }
                value.add(evaluate(left));
                value.subtract(evaluate(right));
            } else if (exp.label().equals("plus")) { // evaluating addition
                value.add(evaluate(left));
                value.add(evaluate(right));
            }

        }

        return value;

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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}
