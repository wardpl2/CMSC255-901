package Projects.Project5;

import java.util.ArrayList;
import java.util.Arrays;

/***************************
 * Moon Samples
 ***************************
 *<p>This program uses multiple methods and 2D arrays to get data on moons</p>
 ***************************
 * @author Preston Ward
 * @version 10/25/2021
 * CMSC 255-901
 **************************/
public class MoonSamples {
    public static void main(String[] args) {
        String[] elements = getElements(args[0]);
        double[][] samples = getSamples(args[1]);
        System.out.println(Arrays.toString(searchForLife(samples)));
        System.out.println(searchHighestElements(samples, elements, 1));
        System.out.println(searchHighestSample(samples, elements, "water"));
    }


    /**
     * @param inputElementString String of comma separated values
     * @return String[]
     */
    public static String[] getElements(String inputElementString) {
        return inputElementString.split(",");
    }

    /**
     * @param inputSamplesString String of groups of comma separated values that are separated by the substring <>
     * @return double[][]
     */
    public static double[][] getSamples(String inputSamplesString) {
        String[] split = inputSamplesString.split("<>");
        double[][] returnArray = new double[split.length][split[0].split(",").length];

        for (int row = 0; row < split.length; row++) {
            String[] toDoubleArray = split[row].split(",");
            for (int col = 0; col < toDoubleArray.length; col++) {
                returnArray[row][col] = Double.parseDouble(toDoubleArray[col]);
            }
        }

        return returnArray;
    }

    /**
     * @param samples double[][]
     * @return int[]
     */
    public static int[] searchForLife(double[][] samples) {
        final double FORMULA = 300;
        ArrayList<Integer> intArray = new ArrayList<>();
        for (int i = 0; i < samples.length; i++) {
            double[] sample = samples[i];
            double total = 0;
            //       Carbon Dioxide       Magnesium       Sodium        Potassium      Chloride         Water
            total += ((8 * sample[0]) + (2 * sample[1]) + sample[2] + (4 * sample[3]) + sample[4] + (5 * sample[5]));
            if (total >= FORMULA) {
                intArray.add(i + 1);
            }
        }

        return intArray.stream().mapToInt(i -> i).toArray();
    }

    /**
     * @param samples double[][]
     * @param elements String[]
     * @param sampleNum int
     * @return String
     */
    public static String searchHighestElements(double[][] samples, String[] elements, int sampleNum) {
        double max1 = samples[sampleNum - 1][0];
        double max2 = samples[sampleNum - 1][0];
        int max1Index = 0;
        int max2Index = 0;

        for (int i = 0; i < samples[sampleNum - 1].length; i++) {
            if (samples[sampleNum - 1][i] > max1) {
                max1 = samples[sampleNum - 1][i];
                max1Index = i;
            }
        }
        for (int i = 0; i < samples[sampleNum - 1].length; i++) {
            if (samples[sampleNum - 1][i] > max2 && i != max1Index) {
                max2 = samples[sampleNum - 1][i];
                max2Index = i;
            }
        }

        return elements[max1Index] + " and " + elements[max2Index];
    }

    /**
     * @param samples double[][]
     * @param elements String[]
     * @param element String
     * @return int
     */
    public static int searchHighestSample(double[][] samples, String[] elements, String element) {
        int index = 0;
        int returnInt = 0;
        if (Arrays.asList(elements).contains(element)) {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i].equals(element)) {
                    index = i;
                }
            }
            double max = samples[0][index];
            for (int row = 0; row < samples.length; row++) {
                if (samples[row][index] > max) {
                    max = samples[row][index];
                    returnInt = row + 1;
                }
            }

            return returnInt;
        } else {
            return -1;
        }

    }
}
