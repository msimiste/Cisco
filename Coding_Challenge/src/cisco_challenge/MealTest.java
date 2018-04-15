package cisco_challenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MealTest {

	@Test
	void vegetarianTest() {
		Vegetarian v = new Vegetarian();
		assertNotNull(v);
		
	}
	
	@Test
	void glutenFreeTest() {
		GlutenFree gf = new GlutenFree();
		assertNotNull(gf);
	}

	@Test
	void regularTest() {
		Regular reg = new Regular();
		assertNotNull(reg);
	}
	
	@Test
	void regularTypeTest() {
		Regular reg = new Regular();
		assertEquals("Regular",reg.getType());
	}
	
	@Test
	void getGlutenFreeTypeTest() {
		GlutenFree gf = new GlutenFree();
		assertEquals("GlutenFree",gf.getType());
	}
	
	@Test
	void getVegetarianTypeTest() {
		Vegetarian v = new Vegetarian();
		assertEquals("Vegetarian",v.getType());
	}
	
	@Test
	void setTypeTest() {
		Vegetarian v = new Vegetarian();
		v.setType("TestingThisMethod");
		assertEquals("TestingThisMethod",v.getType());
	}

}
