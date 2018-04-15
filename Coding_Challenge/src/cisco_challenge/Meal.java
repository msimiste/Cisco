package cisco_challenge;

/***
 * 
 * @author simdevs
 *
 */
public abstract class Meal {

	private String mealType;
	
	/***
	 * 
	 * @param mealType
	 */
	public Meal(String mealType) {
		setType(mealType);
	}
	
	/***
	 * 
	 * @return
	 */
	public String getType() {
		return mealType;
	}
	
	/***
	 * 
	 * @param meal
	 */
	public void setType(String meal) {
		this.mealType = meal;
	}
}

