package Projects.Project4;

import java.util.Scanner;
/***************************
 * Moon Search
 ***************************
 *<p>This program uses multiple methods and parallel arrays to get data on moons</p>
 ***************************
 * @author Preston Ward
 * @version 10/8/2021
 * CMSC 255-901
 **************************/
public class MoonSearch {
    public static void main(String[] args) {
        //parallel arrays initialization
        final String[] moonNames = {"Phobus", "Deimos", "Adrastea", "Aitne", "Amalthea", "Ananke", "Aoede", "Arche"};
        final double[] radii = {11.3, 6.2, 68.9, 33.6, 71.2, 26.8, 255.9, 47.4};
        final double[] density = {1.8, 1.4, 14.2, 33.3, 16.4, 68.1, 121.3, 38.2};
        final double[] distanceFromMars = {3.7, 23.4, 550391.6, 227894.9, 778893.6, 143323.5, 287223.5, 449655.1};
        //Scanner variable
        Scanner in = new Scanner(System.in);
        //method calls
        System.out.printf("The average radius is: %.1f", calcAvg(radii));
        System.out.println();
        System.out.printf("The average density is: %.1f", calcAvg(density));
        System.out.println();
        System.out.printf("The highest radius is: %.1f", findHighValue(radii));
        System.out.println();
        System.out.printf("The lowest distance is: %.1f", findLeastValue(distanceFromMars));
        System.out.println();
        //use for-each loops to print each string in the returned array
        System.out.println("The highest two moons for radii are:");
        for (String s : findHighestTwo(moonNames, radii)) {
            System.out.println(s);
        }
        System.out.println("The lowest two moons for density are:");
        for (String s : findLowestTwo(moonNames, density)) {
            System.out.println(s);
        }
        //ask for input to use as an argument in the findMoon method
        System.out.println("Enter a moon:");
        String name = in.nextLine().trim();
        if (findMoon(moonNames, name)) {
            System.out.println(name + " is a moon in the array.");
        } else {
            System.out.println(name + " is not a moon in the array.");
        }
        //close Scanner
        in.close();
    }

    /**
     * calcAvg method
     * @param values an array of doubles
     * @return the average of all the values in the array of doubles
     */
    public static double calcAvg(double[] values) {
        double sum = 0;
        double avg;
        for (double value: values) {
            sum += value;
        }
        //calculate average and return
        avg = (sum / values.length);
        return avg;
    }

    /**
     * findHighValue method
     * @param values array of doubles
     * @return returns the largest value from the array of doubles passed into it
     */
    public static double findHighValue(double[] values) {
        double max = values[0];
        for (double value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * findLeastValue method
     * @param values array of doubles
     * @return returns the smallest value from the array of doubles passed into it.
     */
    public static double findLeastValue(double[] values) {
        double min = values[0];
        for (double value : values) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    /**
     * findHighestTwo method
     * @param names array of Strings
     * @param values array of doubles
     * @return finds the two largest values in the double array and returns the two Strings associated with the two double values as an array.
     */
    public static String[] findHighestTwo(String[] names, double[] values) {
        double max1 = values[0];
        double max2 = values[0];
        int max1Index = 0;
        int max2Index = 0;
        //finds the first highest value
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max1) {
                max1 = values[i];
                max1Index = i;
            }
        }
        //finds the second-highest value, skipping the first
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max2 && i != max1Index) {
                max2 = values[i];
                max2Index = i;
            }
        }
        //creates and returns an array of the corresponding moon names with the highest values; highest first
        return new String[]{names[max1Index], names[max2Index]};
    }

    /**
     * findLowestTwo method
     * @param names array of Strings
     * @param values array of doubles
     * @return finds the two smallest values in the double array and returns the two Strings associated with the two double values as an array.
     */
    public static String[] findLowestTwo(String[] names, double[] values) {
        double min1 = values[0];
        double min2 = values[0];
        int min1Index = 0;
        int min2Index = 0;
        //finds the lowest value
        for (int i = 0; i < values.length; i++) {
            if (values[i] < min1) {
                min1 = values[i];
                min1Index = i;
            }
        }
        //finds the second-lowest value, skipping the first
        for (int i = 0; i < values.length; i++) {
            if (values[i] < min2 && i != min1Index) {
                min2 = values[i];
                min2Index = i;
            }
        }
        //creates and returns an array of the corresponding moon names with the lowest values; lowest first
        return new String[]{names[min1Index], names[min2Index]};
    }

    /**
     *
     * @param names array of Strings
     * @param moon a String
     * @return will return true if a given String is present within the String array; false otherwise. (ignores case)
     */
    public static boolean findMoon(String[] names, String moon) {
        for (String w : names) {
            if (w.equalsIgnoreCase(moon)) {
                return true;
            }
        }
        return false;
    }
}
