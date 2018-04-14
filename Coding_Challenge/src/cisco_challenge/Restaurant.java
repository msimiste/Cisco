package cisco_challenge;


import java.util.ArrayList;
import java.util.Comparator;

public class Restaurant {
	private ArrayList <Meal> vList = new ArrayList<Meal> (0);
	private ArrayList <Meal> gfList = new ArrayList<Meal> (0);
	private ArrayList <Meal> rList = new ArrayList<Meal> (0);
	private int rating;
	
	private ArrayList<ArrayList<Meal>> mealsList = new ArrayList<ArrayList<Meal>>(3);
	
	public Restaurant(int rated, int vegan, int gf, int other) {
		setRating(rated);
		setMealsList();
		addMeals(vegan, "Vegetarian");
		addMeals(gf,"GlutenFree");
		addMeals(other,"Regular");		
	}
	public static Comparator<Restaurant> RatingComparator = new Comparator<Restaurant>() {

			public int compare(Restaurant r1, Restaurant r2) {
			   int rating1 = r1.getRating();
			   int rating2 = r2.getRating();

			   return rating2-rating1;
		    }};
	
	private void setMealsList() {
		mealsList.add(vList);
		mealsList.add(gfList);
		mealsList.add(rList);
	}
	
	public void setRating(int rate) {
		rating = rate;
	}
	
	public int getRating() {
		return rating;
	}
	
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
	
	private void addMeals(int num, String mType) {
		switch(mType) {
		case "Vegetarian": 
			for(int i = 0; i<num; i++) { mealsList.get(0).add(new Vegetarian(mType));}
			break;			
		case "GlutenFree": 
			for(int i = 0; i<num; i++) { mealsList.get(1).add(new GlutenFree(mType));}
			break;
		case "Regular":
			for(int i = 0; i<num; i++) { mealsList.get(2).add(new GlutenFree(mType));}
			break;
		default: System.out.print("Wrong Meal");
			break;			
		}
		
	}
	
	public ArrayList<ArrayList<Meal>> getMealsList(){
		return this.mealsList;
	}
}
