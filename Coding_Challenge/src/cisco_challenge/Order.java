package cisco_challenge;

public class Order {
	
	int vegan = 0;
	int gf = 0;
	int reg = 0;
	
	public Order(int v, int g, int r) {
		vegan = v;
		gf = g;
		reg = r;
	}
	
	public int getVegan() {
		return vegan;
	}
	
	public int getGlutenFree() {
		return gf;
	}
	
	public int getRegular() {
		return reg;
	}
	
	public void setVeganl(int n) {
		vegan = n;
	}
	public void setGlutenFree(int n) {
		gf = n;
	}
	public void setRegular(int n) {
		reg = n;
	}
}

