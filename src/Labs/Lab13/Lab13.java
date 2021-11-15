package Labs.Lab13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab13 {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File(args[0]);
        File output = new File(args[1]);
        processFile(input, output);
    }

    public static void processFile(File inputFile, File outputFile) {
        try {
            Scanner input = new Scanner(inputFile);
            PrintWriter output = new PrintWriter(outputFile);
            ArrayList<Team> teamArrayList = new ArrayList<>();
            while (input.hasNextLine()) {
                String[] temp = input.nextLine().split(",");
                teamArrayList.add(new Team(temp[0],Integer.parseInt(temp[1]),Integer.parseInt(temp[2])));
            }
            //find maxGoalsScored
            String maxName = "";
            int maxGoalsScored = teamArrayList.get(0).getNumGoals();
            for (Team T : teamArrayList) {
                if (T.getNumGoals() > maxGoalsScored) {
                    maxGoalsScored = T.getNumGoals();
                    maxName = T.getName();
                }
            }
            output.println("Maximum goals Scored: " + maxName + " " + maxGoalsScored);

            //find minGoalsScored
            String minName = "";
            int minGoalsScored = teamArrayList.get(0).getNumGoals();
            for (Team T : teamArrayList) {
                if (T.getNumGoals() < minGoalsScored) {
                    minGoalsScored = T.getNumGoals();
                    minName = T.getName();
                }
            }
            output.println("Minimum goals Scored: " + minName + " " + minGoalsScored);

            //find average shots
            double average;
            double sum = 0;
            for (Team T : teamArrayList) {
                sum += T.getNumShots();
            }
            average = sum / teamArrayList.size();
            output.printf("Average shots per game: %.3f", average);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
