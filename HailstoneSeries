/** Takes a number from user and runs it through a predetermined while loop. 
 *  Programm outputs all the answers.
 * @version 20200211
 */
import java.util.Scanner;

public class HailstoneSeries {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a value: ");
		int n = Integer.parseInt(keyboard.nextLine());

		String output = "";
		int x;
		while (n > 0 && n != 1) {

			if (n % 2 == 0) {
				n = n / 2;
				System.out.print(n + " ");
			} else if(n==1) {
					System.out.print(",1");
			} else {
				n = (3 * n) + 1;
				System.out.print(n + ", ");
			}

		}

		keyboard.close();

	}

}
