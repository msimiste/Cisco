package cisco_challenge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/***
 * 
 * @author simdevs
 *
 */
public class Runner {

	/***
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		
		//get initial order values
		int count = in.nextInt();
		int teamTotal = in.nextInt();
		int teamVegan = in.nextInt();
		int teamGF = in.nextInt();
		int teamOther = in.nextInt();
		
		//validate team + order info
		if(teamVegan + teamGF + teamOther != teamTotal) {
			System.out.print("Invalid Input");
			System.exit(0);
		}
		
		Order order = new Order(teamVegan,teamGF,teamOther);
		
		ArrayList <Restaurant> restaurants = new ArrayList<Restaurant>(count);
		
		char name = '@';//Starting value for restaurant Name, first will be "A", then "B"...
			
		//get restaurant(s) and info from stdin
		while(count-- > 0) {
			restaurants.add(new Restaurant(in.nextInt(),in.nextInt(), in.nextInt(), in.nextInt(), (char)((name++)+1)+""));
		}
		
		
		Collections.sort(restaurants, Controller.RatingComparator);//in order to sort by rating, high to low
		
		/*for(int i = 0; i < restaurants.size(); i++) {
			System.out.println("Name: " +restaurants.get(i).getName() +"\tRating: " + restaurants.get(i).getRating());
		}*/
		
		Controller c = new Controller(order, restaurants);
		
		if(c.isOrderPossible()) {
			c.processOrder();
			c.compileOrder();
			for(HashMap.Entry<String,Order> entry:c.getResult().entrySet()) {
				String n = entry.getKey();
				Order ord = entry.getValue();
				System.out.println("Restaurant: "+ n + "\tVegan:"+ ord.getVegan()+"\tGluten Free:"+ord.getGlutenFree()+"\tRegular:"+ord.getRegular());
			}	
		}
		else {
			System.out.print("This order can not be filled, there are more meals requested than available");
		}
		in.close();
	}
}