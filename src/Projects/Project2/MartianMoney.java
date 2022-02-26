package Projects.Project2;
/************************************
* Martian Money
*************************************
* Preston Ward
* 9/16/2021
* CMSC255-901
************************************/
import java.util.*;
public class MartianMoney {
	public static void main(String[] args) {
		//variable initialization
		Scanner in = new Scanner(System.in);

		double tintina, tintinaRemainder, sutton, suttonRemainder, knorr, knorrRemainder, wernicke;
		int dollars, choice;

		//ask for input
		System.out.println("Would you like to randomly enter a dollar amount (1) or enter it yourself (2)?");
		choice = in.nextInt();
		if (choice == 1) {
			//random number block
			dollars = (80 + (int)(Math.random() * 999921));
			System.out.println(dollars);

			//calculate conversion and separate decimal remainder
			tintina = (dollars / 80.0);
			tintinaRemainder = (tintina - ((int) tintina));

			sutton = (tintinaRemainder * 5);
			suttonRemainder = (sutton - ((int) sutton));

			knorr = (suttonRemainder * 2);
			knorrRemainder = (knorr - ((int) knorr));

			wernicke = Math.round((knorrRemainder * 8));

			System.out.println((int) (dollars) + " is " + ((int) tintina) + " tintina " + ((((int) sutton) != 0) ? (((int) sutton)  + " sutton ") : "") + ((((int) knorr) != 0) ? (((int) knorr) + " knorr ") : "") + ((((int) wernicke) != 0) ? (((int) wernicke) + " wernicke") : ""));
		}
		else if (choice == 2) {
			//user input block
			System.out.println("Enter a dollar amount between $80 and $10,000,000.");
			dollars = in.nextInt();

			if (dollars >= 80 && dollars <= 10000000) {
				//calculate conversion and separate decimal remainder
				tintina = (dollars / 80.0);
				tintinaRemainder = (tintina - ((int) tintina));

				sutton = (tintinaRemainder * 5);
				suttonRemainder = (sutton - ((int) sutton));

				knorr = (suttonRemainder * 2);
				knorrRemainder = (knorr - ((int) knorr));

				wernicke = Math.round((knorrRemainder * 8));
				if (((int) wernicke) == 8) {
					knorr += 1;
					wernicke = 0;
				}

				System.out.println((int) (dollars) + " is " + ((int) tintina) + " tintina " + ((((int) sutton) != 0) ? (((int) sutton)  + " sutton ") : "") + ((((int) knorr) != 0) ? (((int) knorr) + " knorr ") : "") + ((((int) wernicke) != 0) ? (((int) wernicke) + " wernicke") : ""));
			} else {
				//dollar amount too high or too low
				System.out.println("Incorrect input\n");
			}
		} else {
			//choice wasn't 1 or 2
			System.out.println("Incorrect input\n");
		}
		in.close();
	}
}