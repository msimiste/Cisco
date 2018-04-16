package unit_tests;


import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

import cisco_challenge.*;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class RestaurantTest {

	@Test
	public void comparatorTest() {
		Restaurant r1 = new Restaurant(5,0,0,0, "r1");
		Restaurant r2 = new Restaurant(4,0,0,0,"r2");
		
		
		int result = Controller.RatingComparator.compare(r1, r2);
		Assert.assertTrue(result<0);
		
	}
	
	@Test 
	public void restaurantCreateTest(){
		Restaurant r1 = new Restaurant(5,0,0,0,"R1");
		assertNotNull(r1);
	}
	
	
	@Test 
	public void restaurantSetNameTest(){
		Restaurant r1 = new Restaurant(5,0,0,0,"R1");
		assertNotNull(r1.getName());
		assertEquals("R1",r1.getName());
		
		r1.setName("New Name");
		assertEquals("New Name",r1.getName());
		
	}
	@Test
	public void restaurantGetNameTest() {
		Restaurant r1 = new Restaurant (5,0,0,0,"Restaurant #1");
		assertEquals("Restaurant #1",r1.getName());
		
	}
	
	@Test
	public void restaurantGetOrderTest() {
		Restaurant r1 = new Restaurant(5,0,0,0,"R1");
		
		assertNotNull(r1.getOrder());
		
		assertEquals(0, r1.getOrder().getVegan());
		assertEquals(0, r1.getOrder().getGlutenFree());
		assertEquals(0, r1.getOrder().getRegular());
		
	}
	
	@Test 
	public void restaurtantSetOrderTest() {
		
		Restaurant r1 = new Restaurant(5,0,0,0,"R1");
		Order ord = new Order(5,4,3);
		assertEquals(0, r1.getOrder().getVegan());
		assertEquals(0, r1.getOrder().getGlutenFree());
		assertEquals(0, r1.getOrder().getRegular());
		
		r1.setOrder(ord);
		
		assertNotNull(r1.getOrder());
		assertEquals(5,r1.getOrder().getVegan());
		assertEquals(4, r1.getOrder().getGlutenFree());
		assertEquals(3, r1.getOrder().getRegular());
		
	}
	
	@Test
	public void restaurantHasMealVeganTest() {
		
		Restaurant r1 = new Restaurant(5,5,0,0,"R1");
		Meal m = new Vegetarian();
		
		boolean hasMeal = r1.hasMeal(m);
		
		assertTrue(hasMeal);
		
		
	}
	
	@Test
	public void restaurantHasMealGlutenFreeTest() {
		
		Restaurant r1 = new Restaurant(5,5,4,3,"R1");
		Meal m = new GlutenFree();
		
		boolean hasMeal = r1.hasMeal(m);
		
		assertTrue(hasMeal);
		
	}
	
	@Test
	public void restaurantHasMealRegularTest() {
		
		Restaurant r1 = new Restaurant(5,5,4,3,"R1");
		Meal m = new Regular();
		
		boolean hasMeal = r1.hasMeal(m);
		
		assertTrue(hasMeal);
		
	}
	
	@Test
	public void restaurantHasMealFalseTest() {
		
		Restaurant r1 = new Restaurant(5,0,0,3,"R1");
		Meal m = new Regular();
		Meal m2 = new Vegetarian();
		
		boolean hasMeal = r1.hasMeal(m);
		boolean hasVeganMeal = r1.hasMeal(m2);
		
		assertTrue(hasMeal);
		assertFalse(hasVeganMeal);	
	}
	
	@Test
	public void restaurantGetRatingTest() {
		Restaurant r1 = new Restaurant(5,0,0,0,"R1");
		
		int rating = r1.getRating();
		assertEquals(5,rating);
	}
	
	@Test
	public void restaurantSetRatingTest() {
		
		Restaurant r1 = new Restaurant(5,0,0,0,"R1");
		
		int rating = r1.getRating();
		assertEquals(5,rating);
		
		r1.setRating(4);
		rating = r1.getRating();
		assertEquals(4,rating);
	}
	
	@Test 
	public void restaurantDecMealVeganTest(){
		Restaurant r1 = new Restaurant(5,5,4,3,"R1");
		
		r1.decMeal(new Vegetarian());
		int veganMeals = r1.getMealsList().get(0).size();
		
		assertEquals(4,veganMeals);
		
	}
	
	@Test
	public void restaurantDecMealGlutenFreeTest() {
		
		Restaurant r1 = new Restaurant(5,5,4,3,"R1");
		
		r1.decMeal(new GlutenFree());
		int glutenFreeMeals = r1.getMealsList().get(1).size();
		
		assertEquals(3,glutenFreeMeals);
		
	}
	
	@Test
	public void restaurantDecMealRegularTest() {
		
		Restaurant r1 = new Restaurant(5,5,4,3,"R1");
		
		r1.decMeal(new Regular());
		int regularMeals = r1.getMealsList().get(2).size();
		
		assertEquals(2,regularMeals);
	}
	
	@Test
	public void restaurantDecMealNonExistentTest() {
		
		//Arrange
	    OutputStream outContent = new ByteArrayOutputStream();
	    PrintStream sysOut = new PrintStream(outContent);
	    System.setOut(sysOut);
	    Restaurant r1 = new Restaurant(5,5,4,3,"R1");
	    Meal m = new Regular();
	    m.setType("Non-Existent");
	   
	    
	    //Act
		r1.decMeal(m);
		
		//Assert
		assertEquals("Wrong Meal"+System.getProperty("line.separator"), outContent.toString());
		
		System.setOut(System.out);		
	}
	
	@Test
	public void restaurantGetMealsListTest() {
		
		 Restaurant r1 = new Restaurant(5,5,4,3,"R1");
		ArrayList<ArrayList<Meal>> testMealsList = r1.getMealsList();
		
		assertEquals(5,testMealsList.get(0).size());
		assertEquals(4,testMealsList.get(1).size());
		assertEquals(3,testMealsList.get(2).size());
		
	}

}
