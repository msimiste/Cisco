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

}
