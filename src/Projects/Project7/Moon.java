package Projects.Project7;

/****************************
 * Moon
 ****************************
 * The {@link Moon} program that is used to create moon objects in {@link MoonStudy}
 ****************************
 * @author Preston Ward
 * @version 12/3/2021
 * CMSC 255-901
 */
public class Moon {

    private String name;
    private double radius;
    private double density;
    private double distance;

    //Default Constructor
    public Moon() {
        name = "";
        radius = 0.0;
        density = 0.0;
        distance = 0.0;
    }

    //Parameterized Constructor
    public Moon(String name, double radius, double density, double distance) {
        this.name = name;
        this.radius = radius;
        this.density = density;
        this.distance = distance;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getDensity() {
        return density;
    }
    public void setDensity(double density) {
        this.density = density;
    }
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.2f %.2f",name,radius,density,distance);
    }
}
