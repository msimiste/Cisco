package cisco_challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Controller {
	private ArrayList <Restaurant> restaurants = new ArrayList<Restaurant>(0);
	private Order order;
	private HashMap<String, Order> orderResult = new HashMap<String,Order>();
	
	public Controller(Order o, ArrayList <Restaurant> rest ) {
		this.order = o;
		this.restaurants = rest;
	}
	
	public static Comparator<Restaurant> RatingComparator = new Comparator<Restaurant>() {

		public int compare(Restaurant r1, Restaurant r2) {
		   int rating1 = r1.getRating();
		   int rating2 = r2.getRating();

		   return rating2-rating1;
	}};
	
	public boolean isOrderPossible() {
		int totalV = 0;
		int totalGF = 0;
		int totalReg = 0;
		
		for (Restaurant r:restaurants) {
			totalV += r.getMealsList().get(0).size();
			totalGF += r.getMealsList().get(1).size();
			totalReg += r.getMealsList().get(2).size();
		}
		
		if(totalV < order.getVegan() || totalGF < order.getGlutenFree() || totalReg < order.getRegular()) {
			return false;
		}
		return true;
	}
	
	public void processOrder() {
		for(Restaurant r:restaurants) {
			while((order.getVegan() > 0) && (r.hasMeal(new Vegetarian()))) {
				processMeal(r,new Vegetarian());
			}
			while((order.getGlutenFree() > 0) && (r.hasMeal(new GlutenFree()))) {
				processMeal(r,new GlutenFree());
			}
			while((order.getRegular() > 0) && (r.hasMeal(new Regular()))) {
				processMeal(r, new Regular());
			}
		}		
	}
	
	public void compileOrder() {
		for(Restaurant r:restaurants ) {
			orderResult.put(r.getName(), r.getOrder());
		}		
	}
	
	public HashMap<String, Order> getResult(){
		return orderResult;
	}
	
	private void processMeal(Restaurant r, Meal m) {
			r.decMeal(m);
			order.decMeal(m);
			r.getOrder().addMeal(m);		
	}
}
