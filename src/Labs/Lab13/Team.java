package Labs.Lab13;

public class Team {
    private String name;
    private int numGoals;
    private int numShots;

    public Team() {
        name = "";
        numGoals = 0;
        numShots = 0;
    }

    public Team(String name, int numGoals, int numShots) {
        this.name = name;
        this.numGoals = numGoals;
        this.numShots = numShots;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumGoals() {
        return numGoals;
    }
    public void setNumGoals(int numGoals) {
        this.numGoals = numGoals;
    }
    public int getNumShots() {
        return numShots;
    }
    public void setNumShots(int numShots) {
        this.numShots = numShots;
    }
}
