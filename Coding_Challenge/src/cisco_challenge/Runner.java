package cisco_challenge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		
		int count = in.nextInt();
		int teamTotal = in.nextInt();
		int teamVegan = in.nextInt();
		int teamGF = in.nextInt();
		int teamOther = in.nextInt();
		
		ArrayList <Restaurant> restaurants = new ArrayList<Restaurant>(count); 
		
		if(teamVegan + teamGF + teamOther != teamTotal) {
			System.out.print("Invalid Input");
			System.exit(0);
		}
		
		while(count-- > 0) {
			restaurants.add(new Restaurant(in.nextInt(),in.nextInt(), in.nextInt(), in.nextInt()));
		}
		
		Collections.sort(restaurants, Restaurant.RatingComparator);
		
		for(int i = 0; i < restaurants.size(); i++) {
			System.out.println(restaurants.get(i).getRating());
		}
		
	}
}