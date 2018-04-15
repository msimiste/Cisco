package cisco_challenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class RestaurantCompareTest {

	@SuppressWarnings("deprecation")
	@Test
	void comparatorTest() {
		Restaurant r1 = new Restaurant(5,0,0,0, "r1");
		Restaurant r2 = new Restaurant(4,0,0,0,"r2");
		
		
		int result = Controller.RatingComparator.compare(r1, r2);
		Assert.assertTrue(result<0);
		
	}

}
