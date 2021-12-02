package Projects.Project7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*************************************************************************
 * Moon Study
 *************************************************************************
 * This program takes in a text file as a command line argument
 * and uses that file's contents to generate {@link Moon} objects.
 * Those objects are then used to generate data that is then outputted
 * to an output text file that is also read at the command line.
 *************************************************************************
 * @author Preston Ward
 * @version 12/3/21
 * CMSC 255-901
 */
public class MoonStudy {
    public static void main(String[] args) {
        //declare new input and output File objects and an ArrayList to put the input data into
        File inFile;
        File outFile = null;
        ArrayList<String> dataLineByLine = new ArrayList<>();

        //try to initialize input and output files and catch if the filenames
        //can't be found and separate the input data line-by-line
        try {
            inFile = new File(args[0]);
            outFile = new File(args[1]);
            System.out.println("Input file correct");
            dataLineByLine = openFile(inFile);
        }
        catch (FileNotFoundException ex) {
            System.out.println("Incorrect input filename");
        }

        //create the moons ArrayList with the input data that is separated line-by-line
        ArrayList<Moon> moons = createObjects(dataLineByLine);

        //Create data to be used to output
        double meanRadius = findMean(moons,MoonAttributes.RADIUS);
        double highestDensity = findHighValue(moons,MoonAttributes.DENSITY);
        Moon closestMoonToMeanRadius = findMeanMoon(moons,MoonAttributes.RADIUS,meanRadius);
        String lowestMoons = "";
        for (Moon M :findLowestMoons(moons,meanRadius,MoonAttributes.RADIUS)) {
             lowestMoons += (M.toString() + " ");
        }

        //try to output to file and catch if output file can't be found
        try {
            PrintWriter out = new PrintWriter(outFile);
            System.out.println("Output file correct");
            out.printf("The mean of radii is: %.2f", meanRadius);
            out.println();
            out.println();
            out.printf("The highest density value is: %.2f", highestDensity);
            out.println();
            out.println();
            out.println("The moon closest to the mean is: " + closestMoonToMeanRadius);
            out.println();
            out.println("The moons below the mean value of radii are: " + lowestMoons);
            out.println();

            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Incorrect output filename");
        }
    }

    /**
     * Takes in a multi-line text file and puts each line in an {@link ArrayList}
     * @param inputFile {@link File} to be read
     * @return {@link ArrayList} of Strings
     * @throws FileNotFoundException
     */
    public static ArrayList<String> openFile(File inputFile) throws FileNotFoundException {
        ArrayList<String> returnArrayList = new ArrayList<>();
        Scanner in = new Scanner(inputFile);
        while (in.hasNextLine()) {
            returnArrayList.add(in.nextLine());
        }
        return returnArrayList;
    }

    /**
     * Takes an {@link ArrayList} of Strings and takes each CSV and uses it to make a {@link Moon} object which is then added to an {@link ArrayList} of {@link Moon} objects.
     * Catches if a CSV is ill-formatted
     * @param lines {@link ArrayList} of Strings
     * @return {@link ArrayList} of Moon Objects
     */
    public static ArrayList<Moon> createObjects(ArrayList<String> lines) {
        ArrayList<Moon> returnArrayList = new ArrayList<>();
        String name;
        double radius;
        double density;
        double distance;
        for (String s : lines) {
            String[] temp = s.split("\t");
            name = temp[0];
            try {
                radius = Double.parseDouble(temp[1]);
                if (radius < 0) {
                    throw new IllegalStateException();
                }
            }
            catch (NumberFormatException | IllegalStateException e) {
                radius = 0.0;
            }

            try {
                density = Double.parseDouble(temp[2]);
                if (density < 0) {
                    throw new IllegalStateException();
                }
            }
            catch (NumberFormatException | IllegalStateException e) {
                density = 0.0;
            }

            try {
                distance = Double.parseDouble(temp[3]);
                if (distance < 0) {
                    throw new IllegalStateException();
                }
            }
            catch (NumberFormatException | IllegalStateException e) {
                distance = 0.0;
            }
            returnArrayList.add(new Moon(name,radius,density,distance));
        }
        return returnArrayList;
    }

    /**
     * Finds the mean for the given attribute in each {@link Moon} object in the {@link ArrayList}.
     * @param moons {@link ArrayList} of Moon Objects
     * @param attribute attribute from {@link MoonAttributes}
     * @return the mean of the given attribute for the moons as a double
     */
    public static double findMean(ArrayList<Moon> moons, MoonAttributes attribute) {
        double sum = 0;
        switch (attribute) {
            case RADIUS:
                for (Moon M : moons) {
                    sum += M.getRadius();
                }
                return sum / moons.size();
            case DENSITY:
                for (Moon M : moons) {
                    sum += M.getDensity();
                }
                return sum / moons.size();
            case DISTANCE:
                for (Moon M : moons) {
                    sum += M.getDistance();
                }
                return sum / moons.size();
            default:
                return -1;
        }
    }

    /**
     * finds the greatest value for the given attribute in each {@link Moon} object in the {@link ArrayList}.
     * @param moons {@link ArrayList} of {@link Moon} objects
     * @param attribute attribute from {@link MoonAttributes}
     * @return the highest value for the given attribute as a double
     */
    public static double findHighValue(ArrayList<Moon> moons, MoonAttributes attribute) {
        double max = 0;
        switch (attribute) {
            case RADIUS:
                for (Moon M : moons) {
                    if (M.getRadius() > max) {
                        max = M.getRadius();
                    }
                }
                return max;
            case DENSITY:
                for (Moon M : moons) {
                    if (M.getDensity() > max) {
                        max = M.getDensity();
                    }
                }
                return max;
            case DISTANCE:
                for (Moon M : moons) {
                    if (M.getDistance() > max) {
                        max = M.getDistance();
                    }
                }
                return max;
            default:
                return -1;
        }
    }

    /**
     * Finds the {@link Moon} object whose given attribute is closest to the given meanValue
     * @param moons an {@link ArrayList} of {@link Moon} objects
     * @param attribute an attribute from {@link MoonAttributes}
     * @param meanValue a mean value from a certain {@link Moon} as a double
     * @return the {@link Moon} that is the closest to mean value for the given attribute
     */
    public static Moon findMeanMoon(ArrayList<Moon> moons, MoonAttributes attribute, double meanValue) {
        int idx = 0;
        double dist = 0;
        switch (attribute) {
            case RADIUS:
                idx = 0;
                dist = Math.abs(moons.get(0).getRadius() - meanValue);
                for (int i = 1; i < moons.size(); i++) {
                    double cDist = Math.abs(moons.get(i).getRadius() - meanValue);

                    if (cDist < dist) {
                        idx = i;
                        dist = cDist;
                    }
                }
                return moons.get(idx);
            case DENSITY:
                idx = 0;
                dist = Math.abs(moons.get(0).getDensity() - meanValue);
                for (int i = 1; i < moons.size(); i++) {
                    double cDist = Math.abs(moons.get(i).getDensity() - meanValue);

                    if (cDist < dist) {
                        idx = i;
                        dist = cDist;
                    }
                }
                return moons.get(idx);
            case DISTANCE:
                idx = 0;
                dist = Math.abs(moons.get(0).getDistance() - meanValue);
                for (int i = 1; i < moons.size(); i++) {
                    double cDist = Math.abs(moons.get(i).getDistance() - meanValue);

                    if (cDist < dist) {
                        idx = i;
                        dist = cDist;
                    }
                }
                return moons.get(idx);
            default:
                return new Moon();
        }
    }

    /**
     * Finds the {@link Moon} objects whose given attribute's value is less than the given value and adds them to an {@link ArrayList}
     * @param moons an {@link ArrayList} of {@link Moon} objects
     * @param value a value to search (double)
     * @param attribute an attribute from {@link MoonAttributes}
     * @return an {@link ArrayList} of {@link Moon} objects whose given attribute's value is less than the given value
     */
    public static ArrayList<Moon> findLowestMoons(ArrayList<Moon> moons, double value, MoonAttributes attribute) {
        ArrayList<Moon> returnArrayList = new ArrayList<>();
        switch (attribute) {
            case RADIUS:
                for (Moon M : moons) {
                    if (M.getRadius() < value) {
                        returnArrayList.add(M);
                    }
                }
                return returnArrayList;
            case DENSITY:
                for (Moon M :
                        moons) {
                    if (M.getDensity() < value) {
                        returnArrayList.add(M);
                    }
                }
                return returnArrayList;
            case DISTANCE:
                for (Moon M :
                        moons) {
                    if (M.getDistance() < value) {
                        returnArrayList.add(M);
                    }
                }
                return returnArrayList;
            default:
                return new ArrayList<>();
        }
    }

    /**
     * Method to write a message followed by each {@link Moon} object in an {@link ArrayList} on one line to a file
     * @param outputMessage a String
     * @param moons an {@link ArrayList} of {@link Moon}s
     * @param out a {@link PrintWriter} to write to a file
     */
    public static void outputToFile(String outputMessage, ArrayList<Moon> moons, PrintWriter out) {
        //to print an ArrayList of values
        out.print(outputMessage);
        for (Moon M : moons) {
            out.print(M.toString() + " ");
        }
        out.println("\n");
    }

    /**
     * Method to write a message followed by the given {@link Moon} object on one line to a file
     * @param outputMessage a String
     * @param moon {@link Moon} object
     * @param out {@link PrintWriter} to write to a file
     */
    public static void outputToFile(String outputMessage, Moon moon, PrintWriter out) {
        //to print one Moon object
        out.println(outputMessage + moon.toString());
        out.println();
    }

    /**
     * Method to write a message followed by a value on one line to a file
     * @param outputMessage a String
     * @param value a double
     * @param out {@link PrintWriter} to write to a file
     */
    public static void outputToFile(String outputMessage, double value, PrintWriter out) {
        //to print a double value
        out.println(String.format("%s%.2f\n",outputMessage,value));
    }
}
