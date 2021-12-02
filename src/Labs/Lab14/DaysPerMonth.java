package Labs.Lab14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *   DaysPerMonth
 *   VCU - Computer Science Department
 *   A program that prompts the user for a month and year (both as integers)
 *   then displays the number of days in that month.
 **/

public class DaysPerMonth {

    public static void main(String[] args){
        File inputFile;
        File outputFile;
        if (args.length > 0) {
            inputFile = new File(args[0]);
            outputFile = new File(args[1]);
            processFile(inputFile, outputFile);
        } else {
            inputFile = new File(new Scanner(System.in).nextLine());
            outputFile = new File(new Scanner(System.in).nextLine());
        }
    }


    public static void processFile(File inputFile, File outputFile){
        int month;
        int year;
        try {
            Scanner input = new Scanner(inputFile);
            PrintWriter output = new PrintWriter(outputFile);
            while (input.hasNextLine()) {
                String[] temp = input.nextLine().split(",");
                try {

                    month = Integer.parseInt(temp[0]);
                    year = Integer.parseInt(temp[1]);
                    if (month <= 1 || month >= 12) {
                        output.println("Month must be between 1 and 12");
                    }
                    else if (year < 0) {
                        output.println("Year cannot be negative");
                    } else {
                        output.println("There are " + getDays(month,year) + " days in this month.");
                    }
                }
                catch (NumberFormatException exception) {
                    output.println("Not an integer");
                }
            }
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println("Bad File Name");
        }
    }

    /**
     * method to determine the days for the given month and year
     **/
    private static int getDays(int mon, int yr) {
        int numDays = 0;

        switch(mon) {
            case 2: // February
                numDays = 28;
                if (yr % 4 == 0) {
                    numDays = 29;
                    if (yr % 100 == 0 && yr % 400 != 0) {
                        numDays = 28;
                    }
                }
                break;

            case 4:   //April
            case 6:   // June
            case 9:   // September
            case 11:  // November
                numDays = 30;
                break;

            default: numDays = 31;  // all the rest
        }
        return numDays;
    }

}
