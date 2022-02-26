package Labs.Lab6; /************************************
* Count Loop
*************************************
* Preston Ward
* 9/28/2021
* CMSC255-901
************************************/
import java.util.Scanner;
public class CountLoop {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("enter a number to compute 1+2+...n: ");
		int end = in.nextInt();
		//method calls
		whileLoop(end);
		doWhileLoop(end);
		forLoop(end);
		
	}
	//method for while loop
	public static void whileLoop(int n) {
		int sum, count;
		sum = count = 0;
		while (count <= n) {
			sum += count;
			count++;
		}
		System.out.println("While loop: " + sum);
	}

	//method for do-while loop
	public static void doWhileLoop(int n) {
		int sum, count;
		sum = count = 0;
		do {
			sum += count;
			count++;
		} while (count <= n);
		System.out.println("Do While loop: " + sum);
	}

	//method for for loop
	public static void forLoop(int n) {
		int sum = 0;
		for (int count = 0; count <= n; count++) {
			sum += count;
		}
		System.out.println("For loop: " + sum);
	}
}