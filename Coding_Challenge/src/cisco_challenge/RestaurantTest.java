package cisco_challenge;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
class RestaurantTest {

	@Test
	void comparatorTest() {
		Restaurant r1 = new Restaurant(5,0,0,0, "r1");
		Restaurant r2 = new Restaurant(4,0,0,0,"r2");
		
		
		int result = Controller.RatingComparator.compare(r1, r2);
		Assert.assertTrue(result<0);
		
	}
	
	@Test 
	void restaurantCreateTest(){
		Restaurant r1 = new Restaurant(5,0,0,0,"R1");
		assertNotNull(r1);
	}
	
	
	@Test 
	void restaurantSetNameTest(){
		Restaurant r1 = new Restaurant(5,0,0,0,"R1");
		assertNotNull(r1.getName());
		assertEquals("R1",r1.getName());
		
		r1.setName("New Name");
		assertEquals("New Name",r1.getName());
		
	}
	@Test
	void restaurantGetNameTest() {
		Restaurant r1 = new Restaurant (5,0,0,0,"Restaurant #1");
		assertEquals("Restaurant #1",r1.getName());
		
	}
	
	@Test
	void restaurantGetOrderTest() {
		Restaurant r1 = new Restaurant(5,0,0,0,"R1");
		
		assertNotNull(r1.getOrder());
		
		assertEquals(0, r1.getOrder().getVegan());
		assertEquals(0, r1.getOrder().getGlutenFree());
		assertEquals(0, r1.getOrder().getRegular());
		
	}
	
	@Test 
	void restaurtantSetOrderTest() {
		
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
	void restaurantHasMealVeganTest() {
		
		Restaurant r1 = new Restaurant(5,5,0,0,"R1");
		Meal m = new Vegetarian();
		
		boolean hasMeal = r1.hasMeal(m);
		
		assertTrue(hasMeal);
		
		
	}
	
	@Test
	void restaurantHasMealGlutenFreeTest() {
		
		Restaurant r1 = new Restaurant(5,5,4,3,"R1");
		Meal m = new GlutenFree();
		
		boolean hasMeal = r1.hasMeal(m);
		
		assertTrue(hasMeal);
		
	}
	
	@Test
	void restaurantHasMealRegularTest() {
		
		Restaurant r1 = new Restaurant(5,5,4,3,"R1");
		Meal m = new Regular();
		
		boolean hasMeal = r1.hasMeal(m);
		
		assertTrue(hasMeal);
		
	}
	
	@Test
	void restaurantHasMealFalseTest() {
		
		Restaurant r1 = new Restaurant(5,0,0,3,"R1");
		Meal m = new Regular();
		Meal m2 = new Vegetarian();
		
		boolean hasMeal = r1.hasMeal(m);
		boolean hasVeganMeal = r1.hasMeal(m2);
		
		assertTrue(hasMeal);
		assertFalse(hasVeganMeal);	
	}
	
	@Test
	void restaurantGetRatingTest() {
		Restaurant r1 = new Restaurant(5,0,0,0,"R1");
		
		int rating = r1.getRating();
		assertEquals(5,rating);
	}
	
	@Test
	void restaurantSetRatingTest() {
		
		Restaurant r1 = new Restaurant(5,0,0,0,"R1");
		
		int rating = r1.getRating();
		assertEquals(5,rating);
		
		r1.setRating(4);
		rating = r1.getRating();
		assertEquals(4,rating);
	}
	

}
