/**
* Program to reverse a String entered by a user.
* @version 20200225
*
*/
import java.util.Scanner;

public class ReverseStrings {

/**
* Prompts the user for input repeatedly until the user enters a non-empty
* String.
*
* @param in
* the Scanner object to be used to read user input
* @return the String entered by the user
*/
public static String getUserInput(Scanner in)
{
 String input; 
while(true){
   System.out.print("Enter a string: ");
   input=in.nextLine();
   if(input.length()==0){
       System.out.print("Enter a string: ");
   }
return input;
}

}

/**
* Returns the reverse of the input String inString.
*
* @param inString
* the String to be reversed
* @return the reverse of inString
*/
public static String reverse(String inString)
{
   String reverse = "";
   for(int i = inString. length() - 1; i >= 0; i--) {
   reverse = reverse + inString. charAt(i); }
return reverse;
}

public static void main(String[] args) {
// Set up the scanner
Scanner inScanner = new Scanner(System.in);
// Prompt the user for input
String input = getUserInput(inScanner);

// Reverse the user's input
String reversed = reverse(input);
// Display the result
System.out.println("You typed: " + input);
System.out.println("In the mirror, that is " + reversed);
inScanner.close();
}

}
