import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 *
 */
public final class XMLTreeIntExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeIntExpressionEvaluator() {
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
    private static int evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";
        int value = 0;
        if (exp.isTag() && exp.label().equals("number")) { // Converting String to int
            value = Integer.parseInt(exp.attributeValue("value"));
        } else {
            XMLTree left = exp.child(0); // left tree of child 0 of parent
            XMLTree right = exp.child(1); // right tree of child 1 of parent
            if (exp.label().equals("number")) {
                value = evaluate(left);
            } else if (exp.label().equals("divide")) { // evaluating division
                value = evaluate(left) / evaluate(right);
            } else if (exp.label().equals("times")) { // evaluating multiplication
                value = evaluate(left) * evaluate(right);
            } else if (exp.label().equals("minus")) { // evaluating subtraction
                value = evaluate(left) - evaluate(right);
            } else if (exp.label().equals("plus")) { // evaluating addition
                value = evaluate(left) + evaluate(right);
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
