package Projects.Project6;

public class House {
    private String owner;
    private int lotNumber;
    private double squareFootage;
    private Bedrooms bedrooms;
    private Baths baths;
    private Color color;

    /**
     * Parameterized Constructor
     * @param owner String
     * @param lotNumber int
     * @param squareFootage double
     * @param bedrooms enum Bedrooms
     * @param baths enum Baths
     * @param color enum Color
     */
    public House(String owner, int lotNumber, double squareFootage, Bedrooms bedrooms, Baths baths, Color color) {
        this.owner = owner;
        this.lotNumber = lotNumber;
        this.squareFootage = squareFootage;
        this.bedrooms = bedrooms;
        this.baths = baths;
        this.color = color;
    }

    /**
     * Default Constructor
     */
    public House() {
        owner = "";
        lotNumber = 1;
        squareFootage = 500.00;
        bedrooms = Bedrooms.ONE_BEDROOM;
        baths = Baths.ONE;
        color = Color.WHITE;
    }

    //Getters and Setters
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public int getLotNumber() {
        return lotNumber;
    }
    public void setLotNumber(int lotNumber) {
        this.lotNumber = lotNumber;
    }
    public double getSquareFootage() {
        return squareFootage;
    }
    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }
    public Bedrooms getBedrooms() {
        return bedrooms;
    }
    public void setBedrooms(Bedrooms bedrooms) {
        this.bedrooms = bedrooms;
    }
    public Baths getBaths() {
        return baths;
    }
    public void setBaths(Baths baths) {
        this.baths = baths;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return String formatted with all the details of a House object
     */
    @Override
    public String toString() {
        return String.format("\n" +
                "\t%s\n" +
                "\t%d\n" +
                "\t%.2f\n" +
                "\t%s\n" +
                "\t%s\n" +
                "\t%s\n",owner, lotNumber, squareFootage, bedrooms, baths, color);
    }
}
