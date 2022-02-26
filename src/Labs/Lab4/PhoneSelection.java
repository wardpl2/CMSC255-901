package Labs.Lab4; /************************************
* Phone selection
*************************************
* Preston Ward
* 9/14/2021
* CMSC255-901
************************************/
import java.util.*;

public class PhoneSelection {
	public static void main(String[] args) {
		//initialize Scanner
		Scanner in = new Scanner(System.in);
		//ask for input
		System.out.println("Enter a single letter, and I will tell you what the corresponding digit is on the telephone");
		char letter = in.next().charAt(0);
		//lowerCase to upperCase
		char letterUpper = Character.toUpperCase(letter);
		//if/else if block to decide the outputs
		if (letterUpper == 'A' || letterUpper == 'B' || letterUpper == 'C') {
			System.out.println("The digit 2 corresponds to the letter " + letterUpper + " on the telephone.");
		}
		else if (letterUpper == 'D' || letterUpper == 'E' || letterUpper == 'F') {
			System.out.println("The digit 3 corresponds to the letter " + letterUpper + " on the telephone.");
		}
		else if (letterUpper == 'G' || letterUpper == 'H' || letterUpper == 'I') {
			System.out.println("The digit 4 corresponds to the letter " + letterUpper + " on the telephone.");
		}
		else if (letterUpper == 'J' || letterUpper == 'K' || letterUpper == 'L') {
			System.out.println("The digit 5 corresponds to the letter " + letterUpper + " on the telephone.");
		}
		else if (letterUpper == 'M' || letterUpper == 'N' || letterUpper == 'O') {
			System.out.println("The digit 6 corresponds to the letter " + letterUpper + " on the telephone.");
		}
		else if (letterUpper == 'P' || letterUpper == 'Q' || letterUpper == 'R' || letterUpper == 'S') {
			System.out.println("The digit 7 corresponds to the letter " + letterUpper + " on the telephone.");
		}
		else if (letterUpper == 'T' || letterUpper == 'U' || letterUpper == 'V') {
			System.out.println("The digit 8 corresponds to the letter " + letterUpper + " on the telephone.");
		}
		else if (letterUpper == 'W' || letterUpper == 'X' || letterUpper == 'Y' || letterUpper == 'Z') {
			System.out.println("The digit 9 corresponds to the letter " + letterUpper + " on the telephone.");
		}
	}
}