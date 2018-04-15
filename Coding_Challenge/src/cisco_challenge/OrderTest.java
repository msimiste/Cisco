package cisco_challenge;

import static org.junit.jupiter.api.Assertions.*;

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
	
	
}
