package Projects.Project3;
/************************************
* Martian Houses
*************************************
* Preston Ward
* 9/29/2021
* CMSC255-901
************************************/
import java.util.Scanner;
public class MartianHouses {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		double s, areaFloorRoof, areaWall, totalSurfaceArea, housePrice;
		final double COST_PER_SF = 14.50;
		String name = "", cont = "yes";

		while (!(cont.equals("no"))) {
			System.out.println("Enter the settler's name: ");
			name = in.nextLine();

			System.out.println("Enter the length of a side of the house: ");
			s = in.nextDouble();

			areaFloorRoof = 2 * s * s * (1 + Math.sqrt(2));
			areaWall = 8 * 12 * s;
			totalSurfaceArea = (2 * areaFloorRoof) + areaWall;
			housePrice = totalSurfaceArea * COST_PER_SF;

			System.out.printf("%s has a house surface area of %,.2f and cost of $%,.2f", name, totalSurfaceArea, housePrice);
			System.out.println("\nWould you like to enter another house? Enter no to exit. ");
			in.nextLine();
			cont = in.nextLine().trim().toLowerCase();
		}
		in.close();
	}
}