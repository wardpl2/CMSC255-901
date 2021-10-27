package Labs.Lab7;

import java.util.Scanner;

public class Lab7Debug {

    public static void main(String[] args){
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter two integers
        System.out.print("Enter first integer: ");
        int n1 = input.nextInt();
        System.out.print("Enter second integer: ");
        int n2 = input.nextInt();

        int gcd = GCD(n1,n2);

        System.out.println("The greatest common divisor for " + n1 + " and " + n2 + " is " + gcd);
    }

    public static int GCD(int num1, int num2){

        int gcd = 1;
        int k = 2;
        while (k <= num1 && k <= num2) {
            if (num1 % k == 0 && num2 % k == 0) {
                gcd = k;
            }
            k++;
        }

        return gcd;
    }

}
