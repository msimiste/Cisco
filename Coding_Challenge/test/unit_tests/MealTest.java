package unit_tests;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import cisco_challenge.*;

public class MealTest {

	@Test
	public void vegetarianCreateTest() {
		Vegetarian v = new Vegetarian();
		assertNotNull(v);
		
	}
	
	@Test
	public void glutenFreeCreateTest() {
		GlutenFree gf = new GlutenFree();
		assertNotNull(gf);
	}

	@Test
	public void regularCreateTest() {
		Regular reg = new Regular();
		assertNotNull(reg);
	}
	
	@Test
	public void regularTypeTest() {
		Regular reg = new Regular();
		assertEquals("Regular",reg.getType());
	}
	
	@Test
	public void getGlutenFreeTypeTest() {
		GlutenFree gf = new GlutenFree();
		assertEquals("GlutenFree",gf.getType());
	}
	
	@Test
	public void getVegetarianTypeTest() {
		Vegetarian v = new Vegetarian();
		assertEquals("Vegetarian",v.getType());
	}
	
	@Test
	public void setTypeTest() {
		Vegetarian v = new Vegetarian();
		v.setType("TestingThisMethod");
		assertEquals("TestingThisMethod",v.getType());
	}

}