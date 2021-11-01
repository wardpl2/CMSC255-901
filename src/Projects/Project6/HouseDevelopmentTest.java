package Projects.Project6;

/***************************
 * House Development Test
 ***************************
 *<p>This program uses 2 classes (House and Development) and 3 enums (Bedrooms, Baths, Color) to give information about houses and developments on Mars</p>
 ***************************
 * @author Preston Ward
 * @version 11/11/2021
 * CMSC 255-901
 **************************/
public class HouseDevelopmentTest {
    public static void main(String[] args) {
        House house1 = new House("Preston Ward",1,2500,Bedrooms.ONE_BEDROOM,Baths.ONE,Color.BLUE);
        House house2 = new House();
        House house3 = new House("Zach Whitten",1,2000,Bedrooms.TWO_BEDROOM,Baths.ONE,Color.BRICK);

        Development development1 = new Development("Development1","Richmond, VA",2021,5);

        development1.addHouse(house1);
        development1.addHouse(house2);
        development1.addHouse(house3);

        System.out.println(development1.toString());
    }
}
