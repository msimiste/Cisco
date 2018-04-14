package cisco_challenge;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller {
	private ArrayList <Restaurant> restaurants = new ArrayList<Restaurant>(0);
	private Order order;
	private HashMap<String, int[]> orderResult = new HashMap<String,int[]>();
	
	public Controller(Order o, ArrayList <Restaurant> rest ) {
		this.order = o;
		this.restaurants = rest;
	}
	
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
		
	}
}
