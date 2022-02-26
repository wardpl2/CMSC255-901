package Labs.Lab5; /************************************
* Print Strings
*************************************
* Preston Ward
* 9/21/2021
* CMSC255-901
************************************/
import java.util.*;
public class PrintStrings {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String word1, word2;
		System.out.print("Word 1: ");
		word1 = in.next();
		System.out.print("Word 2: ");
		word2 = in.next();

		System.out.println(((word1.compareTo(word2) > 0) ? word1 : word2) + " is greater than " + ((word1.compareTo(word2) > 0) ? word2 : word1));
	}
}