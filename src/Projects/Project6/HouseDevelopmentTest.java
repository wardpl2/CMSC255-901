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
        House house1 = new House("Caroline Budwell",15,2754.99,Bedrooms.TWO_BEDROOM,Baths.TWO,Color.GREEN);
        House house2 = new House("Sam Zu",2,2500,Bedrooms.THREE_BEDROOM,Baths.THREE,Color.WHITE);
        House house3 = new House("Zach Whitten",27,789.45,Bedrooms.STUDIO,Baths.ONE,Color.GRAY);

        Development development1 = new Development("Freeze Zone","North Polar Ice Cap",2023,2);
        Development development2 = new Development("Crater Field","Korolev crater",100,1);

        development1.addHouse(house1);
        development1.addHouse(house2);

        development2.addHouse(house3);

        System.out.println(development1.toString());

        System.out.println(development2.toString());
    }
}
