package Labs.Lab6;

/************************************
* Nested Loop Triangle
*************************************
* Preston Ward
* 9/28/2021
* CMSC255-901
************************************/
public class NestedLoopTriangle {
	public static void main(String[] args) {
	int temp = 1, temp2 = 9, rows = 10;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= temp; j++) {
				System.out.print("*");
			}
			temp += 2;
			System.out.println();
		}
		temp = 1;
		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j < temp2; j++) {
				System.out.print(" ");
			}
			temp2--;
			for (int k = 1; k <= temp; k++) {
				System.out.print("*");
			}
			temp += 2;
			System.out.println();
		}
	}
}
/**
 * 1,1
 * 2,3
 * 3,5
 * 4,7
 * 5,9
 * 6,11
 * 7,13
 * 8,15
 * 9,17
 * 10,19
 */