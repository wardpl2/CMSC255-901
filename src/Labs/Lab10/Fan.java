package Labs.Lab10;

public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    private int speed;
    private boolean on;
    private double radius;
    private String color;

    /**
     * @param speed integer
     * @param on boolean
     * @param radius double
     * @param color String
     */
    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    /**
     * Default constructor
     */
    public Fan() {
        this(SLOW, false, 5, "blue");
    }

    //getters and setters for instance variables

    /**
     * @return current speed (int)
     */
    public int getSpeed() {
        return speed;
    }
    /**
     * @param speed integer
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    /**
     * @return if on (boolean)
     */
    public boolean isOn() {
        return on;
    }
    /**
     * @param on boolean
     */
    public void setOn(boolean on) {
        this.on = on;
    }
    /**
     * @return current radius (double)
     */
    public double getRadius() {
        return radius;
    }
    /**
     * @param radius double
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
    /**
     * @return current color (String)
     */
    public String getColor() {
        return color;
    }
    /**
     * @param color String
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return fields of Fan class formatted to a String
     */
    public String toString() {
        if (isOn()) {
            return String.format("fan is %d, %s, and size %.1f", getSpeed(), getColor(), getRadius());
        } else {
            return "fan is off";
        }
    }
}
