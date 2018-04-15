package cisco_challenge;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class OrderTest {

	@Test
	void orderCreateTest() {
		Order ord = new Order();
		assertNotNull(ord);
		assertEquals(0,ord.getVegan());
		assertEquals(0,ord.getGlutenFree());
		assertEquals(0,ord.getRegular());
	}
	
	@Test
	void orderGetVeganTest() {
		Order ord = new Order(5,4,3);
		assertNotNull(ord);
		assertEquals(5,ord.getVegan());		
	}

	@Test
	void orderGetGlutenFreeTest() {
		Order ord = new Order(5,4,3);
		assertNotNull(ord);
		assertEquals(4,ord.getGlutenFree());
	}
	
	@Test 
	void orderGetRegularTest() {
		Order ord = new Order(5,4,3);
		assertNotNull(ord);
		assertEquals(3,ord.getRegular());
	}
	
	@Test
	void orderSetVeganTest() {
		Order ord = new Order(5,4,3);
		assertNotNull(ord);
		assertEquals(5,ord.getVegan());	
		ord.setVegan(15);
		assertEquals(15,ord.getVegan());
	}

	@Test
	void orderSetGlutenFreeTest() {
		Order ord = new Order(5,4,3);
		assertNotNull(ord);
		assertEquals(4,ord.getGlutenFree());
		ord.setGlutenFree(11);
		assertEquals(11,ord.getGlutenFree());
	}
	
	@Test 
	void orderSetRegularTest() {
		Order ord = new Order(5,4,3);
		assertNotNull(ord);
		assertEquals(3,ord.getRegular());
		ord.setRegular(21);
		assertEquals(21,ord.getRegular());
	}
	
	@Test
	void orderAddVegetarianMealTest() {
		Order ord = new Order(5,4,3);
		Meal m = new Vegetarian();
		assertNotNull(m);
		assertNotNull(ord);
		assertEquals(5,ord.getVegan());
		assertEquals(4,ord.getGlutenFree());
		assertEquals(3,ord.getRegular());
		ord.addMeal(m);
		assertEquals(6,ord.getVegan());
		assertEquals(4,ord.getGlutenFree());
		assertEquals(3,ord.getRegular());
		
	}
	
	@Test
	void orderAddGlutenFreeMealTest() {
		Order ord = new Order(5,4,3);
		Meal m = new GlutenFree();
		assertNotNull(m);
		assertNotNull(ord);
		assertEquals(5,ord.getVegan());
		assertEquals(4,ord.getGlutenFree());
		assertEquals(3,ord.getRegular());
		ord.addMeal(m);
		assertEquals(5,ord.getVegan());
		assertEquals(5,ord.getGlutenFree());
		assertEquals(3,ord.getRegular());		
	}
	
	@Test
	void orderAddRegularMealTest() {
		Order ord = new Order(5,4,3);
		Meal m = new Regular();
		assertNotNull(m);
		assertNotNull(ord);
		assertEquals(5,ord.getVegan());
		assertEquals(4,ord.getGlutenFree());
		assertEquals(3,ord.getRegular());
		ord.addMeal(m);
		assertEquals(5,ord.getVegan());
		assertEquals(4,ord.getGlutenFree());
		assertEquals(4,ord.getRegular());		
	}
	
	@Test
	void addNonExistentMealTest() {
		//Arrange
	    OutputStream outContent = new ByteArrayOutputStream();
	    PrintStream sysOut = new PrintStream(outContent);
	    System.setOut(sysOut);
	    
	    //Act
		Order ord = new Order(5,4,3);
		Meal m = new Regular();
		m.setType("Non Existent");
		
		//Assert
		assertNotNull(m);
		assertNotNull(ord);
		assertEquals(5,ord.getVegan());
		assertEquals(4,ord.getGlutenFree());
		assertEquals(3,ord.getRegular());
		ord.addMeal(m);
		assertEquals("Something is wrong"+System.getProperty("line.separator"), outContent.toString());
		
		System.setOut(System.out);
	}
	
	@Test
	void orderDecVeganMealTest() {	
		
		Order ord = new Order(5,4,3);
		Meal m = new Vegetarian();
		assertNotNull(m);
		assertNotNull(ord);
		assertEquals(5,ord.getVegan());
		assertEquals(4,ord.getGlutenFree());
		assertEquals(3,ord.getRegular());
		
		ord.decMeal(m);
		
		assertEquals(4,ord.getVegan());
		assertEquals(4,ord.getGlutenFree());
		assertEquals(3,ord.getRegular());
		
		
	}
	
	@Test
	void orderDecGlutenFreeMealTest() {
		
		Order ord = new Order(5,4,3);
		Meal m = new GlutenFree();
		assertNotNull(m);
		assertNotNull(ord);
		assertEquals(5,ord.getVegan());
		assertEquals(4,ord.getGlutenFree());
		assertEquals(3,ord.getRegular());
		ord.decMeal(m);
		assertEquals(5,ord.getVegan());
		assertEquals(3,ord.getGlutenFree());
		assertEquals(3,ord.getRegular());
		
	}
	
	@Test
	void orderDecRegularTest() {
	
		Order ord = new Order(5,4,3);
		Meal m = new Regular();
		assertNotNull(m);
		assertNotNull(ord);
		assertEquals(5,ord.getVegan());
		assertEquals(4,ord.getGlutenFree());
		assertEquals(3,ord.getRegular());
		ord.decMeal(m);
		assertEquals(5,ord.getVegan());
		assertEquals(4,ord.getGlutenFree());
		assertEquals(2,ord.getRegular());
	}
	

	@Test
	void orderDecNonExistentMealTest() {
		
		//Arrange
	    OutputStream outContent = new ByteArrayOutputStream();
	    PrintStream sysOut = new PrintStream(outContent);
	    System.setOut(sysOut);
	    
	    //Act
		Order ord = new Order(5,4,3);
		Meal m = new Regular();
		m.setType("Non Existent");
		
		//Assert
		assertNotNull(m);
		assertNotNull(ord);
		assertEquals(5,ord.getVegan());
		assertEquals(4,ord.getGlutenFree());
		assertEquals(3,ord.getRegular());
		ord.decMeal(m);
		assertEquals("Something is wrong"+System.getProperty("line.separator"), outContent.toString());
		
		System.setOut(System.out);
	}

}
