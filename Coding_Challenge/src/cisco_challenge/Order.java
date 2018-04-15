package cisco_challenge;

public class Order {
	
	private int vegan = 0;
	private int gf = 0;
	private int reg = 0;
	
	public Order(int v, int g, int r) {
		vegan = v;
		gf = g;
		reg = r;
	}
	
	public Order() {}
	
	public int getVegan() {
		return vegan;
	}
	
	public int getGlutenFree() {
		return gf;
	}
	
	public int getRegular() {
		return reg;
	}
	
	public void setVegan(int n) {
		vegan = n;
	}
	public void setGlutenFree(int n) {
		gf = n;
	}
	public void setRegular(int n) {
		reg = n;
	}
	
	public void addMeal(Meal m) {
		switch(m.getType()) {
		case"Vegetarian": this.vegan++;
		break;
		case"GlutenFree": this.gf++;
		break;
		case"Regular": this.reg++;
		break;
		default: System.out.println("Something is wrong");
		break;
		}		
	}
	
	public void decMeal(Meal m) {
		switch(m.getType()) {
		case"Vegetarian": this.vegan--;
		break;
		case"GlutenFree": this.gf--;
		break;
		case"Regular": this.reg--;
		break;
		default: System.out.println("Something is wrong");
		break;
		}		
	}
}

