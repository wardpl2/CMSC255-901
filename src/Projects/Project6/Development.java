package Projects.Project6;

import java.util.ArrayList;

/***************************
 * Development
 ***************************
 *<p>This program has information on developments on Mars and has a specialized toString method that shows its, and the houses it contains', information</p>
 ***************************
 * @author Preston Ward
 * @version 11/5/2021
 * CMSC 255-901
 **************************/
public class Development {
    /**
     * Instance Variables
     */
    private String name;
    private String location;
    private int yearEst;
    private int numLots;
    private final ArrayList<House> houses;

    /**
     * Parameterized Constructor
     * @param name String
     * @param location String
     * @param yearEst int
     * @param numLots int
     */
    public Development(String name, String location, int yearEst, int numLots) {
        this.name = name;
        this.location = location;
        this.yearEst = yearEst;
        this.numLots = numLots;
        houses = new ArrayList<>();
    }

    /**
     * Default Constructor
     */
    public Development() {
        name = "";
        location = "";
        yearEst = 0;
        numLots = 0;
        houses = new ArrayList<>();
    }

    //Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getYearEst() {
        return yearEst;
    }
    public void setYearEst(int yearEst) {
        this.yearEst = yearEst;
    }
    public int getNumLots() {
        return numLots;
    }
    public void setNumLots(int numLots) {
        this.numLots = numLots;
    }


    /**
     * Adds a House object to the houses ArrayList
     * @param H House
     */
    public void addHouse(House H) {
        houses.add(H);
    }

    /**
     * @return The length of the houses ArrayList as an int
     */
    public int getNumHouses() {
        return houses.size();
    }

    /**
     * @return The ArrayList of houses
     */
    public ArrayList<House> getHouses() {
        return houses;
    }

    /**
     * toString method specifically for {@link Development}
     * @return String formatted with all the details of a Development object which includes all the details of a House object
     */
    @Override
    public String toString() {
        String returnString = "";
        String developmentString = String.format(
                "%s\n" +
                "%s\n" +
                "%d\n" +
                "%d\n" +
                "Houses:\n", name, location, yearEst, numLots);
        returnString += developmentString;
        for (House H : houses) {
            returnString += H.toString();
        }

        return returnString;
    }
}
