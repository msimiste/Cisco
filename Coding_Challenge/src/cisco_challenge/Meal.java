package cisco_challenge;

public abstract class Meal {

	private String mealType;
	
	public Meal(String mealType) {
		setType(mealType);
	}
	
	public String getType() {
		return mealType;
	}
	public void setType(String meal) {
		this.mealType = meal;
	}
}

