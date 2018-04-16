package cisco_challenge;


import java.util.ArrayList;

/***
 * 
 * @author simdevs
 *
 */
public class Restaurant {
	private ArrayList <Meal> vList = new ArrayList<Meal> (0);
	private ArrayList <Meal> gfList = new ArrayList<Meal> (0);
	private ArrayList <Meal> rList = new ArrayList<Meal> (0);
	private int rating;
	private String name;
	private Order order;
	
	private ArrayList<ArrayList<Meal>> mealsList = new ArrayList<ArrayList<Meal>>(3);
	
	/***
	 * 
	 * @param rated
	 * @param vegan
	 * @param gf
	 * @param other
	 * @param n
	 */
	public Restaurant(int rated, int vegan, int gf, int other, String n) {
		setName(n);
		setRating(rated);
		setMealsList();
		addMeals(vegan, "Vegetarian");
		addMeals(gf,"GlutenFree");
		addMeals(other,"Regular");
		order = new Order();
	}
	
	/***
	 * 
	 * @param n
	 */
	public void setName(String n) {
		
		name = n;
	}
	
	/***
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/***
	 * 
	 */
	private void setMealsList() {
		mealsList.add(vList);
		mealsList.add(gfList);
		mealsList.add(rList);
	}
	
	/***
	 * 
	 * @param rate
	 */
	public void setRating(int rate) {
		rating = rate;
	}
	
	/***
	 * 
	 * @return
	 */
	public int getRating() {
		return rating;
	}
	
	/***
	 * 
	 * @return
	 */
	public Order getOrder() {
		return order;
	}
	

	/***
	 * 
	 * @param o
	 */
	public void setOrder(Order o) {
		order = o;
	}
	
	/***
	 * @param meal
	 * @return
	 */
	public boolean hasMeal(Meal meal)
	{
		switch(meal.getType()) {
		case "Vegetarian": 
			return mealsList.get(0).size() > 0;
		case "GlutenFree": 
			return mealsList.get(1).size() > 0;
		case "Regular":
			return mealsList.get(2).size() > 0;
		default: return false;
		}			
	}
	
	/***
	 * 
	 * @param num
	 * @param mType
	 */
	private void addMeals(int num, String mType) {
		switch(mType) {
		case "Vegetarian": 
			for(int i = 0; i<num; i++) { mealsList.get(0).add(new Vegetarian());}
			break;			
		case "GlutenFree": 
			for(int i = 0; i<num; i++) { mealsList.get(1).add(new GlutenFree());}
			break;
		case "Regular":
			for(int i = 0; i<num; i++) { mealsList.get(2).add(new GlutenFree());}
			break;
		default: System.out.print("Wrong Meal");
			break;			
		}
		
	}
	
	/***
	 * 
	 * @param m
	 */
	public void decMeal(Meal m) {
		switch(m.getType()) {
		case "Vegetarian": 
			if(!mealsList.get(0).isEmpty()) {
				mealsList.get(0).remove(0);
				mealsList.get(0).trimToSize();
			}			
			break;			
		case "GlutenFree": 
			if(!mealsList.get(1).isEmpty()) {
				mealsList.get(1).remove(0);
				mealsList.get(1).trimToSize();
			}
			break;
		case "Regular":
			if(!mealsList.get(2).isEmpty()) {
				mealsList.get(2).remove(0);
				mealsList.get(2).trimToSize();
			}
			break;
		default: System.out.println("Wrong Meal");
			break;			
		}
		
	}
	
	/***
	 * 
	 * @return
	 */
	public ArrayList<ArrayList<Meal>> getMealsList(){
		return this.mealsList;
	}
}
