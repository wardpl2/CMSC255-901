package Labs.Lab5; /******************
 * Test runs
 * 
 * Run1:
 * str1 = aa
 * str2 = aaa
 * str3 = aaaa
 * output = aaa
 * Run2:
 * str1 = happy
 * str2 = Happy
 * str3 = HAPPY
 * output = Happy
*******************/
/************************************
* Middle String
*************************************
* Preston Ward
* 9/21/2021
* CMSC255-901
************************************/
import java.util.Scanner;

public class MiddleString {
	public static void main(String [] args) {
		Scanner scnr = new Scanner(System.in);

		System.out.println("Enter three strings:");
		String str1 = scnr.next();
		String str2 = scnr.next();
		String str3 = scnr.next();

		if (str1.compareTo(str2) >= 0 && str1.compareTo(str3) <= 0) {
			System.out.println(str1);
		}
		else if (str1.compareTo(str2) <= 0 && str1.compareTo(str3) >= 0) {
			System.out.println(str1);
		} 
		else if (str2.compareTo(str1) >= 0 && str2.compareTo(str3) <= 0) {
			System.out.println(str2);
		}
		else if (str2.compareTo(str1) <= 0 && str2.compareTo(str3) >= 0) {
			System.out.println(str2);
		} else {
			System.out.println(str3);
		}

		scnr.close();
	}
}