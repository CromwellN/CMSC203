import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	// Variables
	ManagementCompany mgmt;
	
	@Before
	public void setUp() throws Exception {
		// Variables
		mgmt = new ManagementCompany("MGMT Company 1", "ABC123", 6);
		
		// Add properties
		mgmt.addProperty("Property 1", "Potomac", 600, "JC Tucker0", 2, 1, 2, 2);
		mgmt.addProperty("Property 2", "Rockville", 700, "JC Tucker1", 4, 1, 2, 2);
		mgmt.addProperty("Property 3", "Rockville", 800, "JC Tucker2", 6, 1, 2, 2);			
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		mgmt = null;  
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		fail("STUDENT test not implemented yet");
		//student should add property with 4 args & default plot (0,0,1,1)
		//student should add property with 8 args
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
		assertEquals(mgmt.addProperty("Property 1", "Potomac", 888, "JC Tucker3"), 3); // 4 arguemnt
		assertEquals(mgmt.addProperty("Property 1", "Potomac", 999, "JC Tucker4", 2, 1, 2, 2), 4); // 8 argument
		assertEquals(mgmt.addProperty("Property 1", "Potomac", 111, "JC Tucker5"), -1); // out of bounds (6th one)	
	}
 
	@Test
	public void testMaxPropertyRent() {
		fail("STUDENT test not implemented yet");
		//student should test if maxRentProp contains the maximum rent of properties
		String info = mgmt.maxRentProp();
		assertTrue(info.contains("800"));
	}

	@Test
	public void testTotalRent() {
		fail("STUDENT test not implemented yet");
		//student should test if totalRent returns the total rent of properties
		assertEquals(mgmt.totalRent(), 2100, 0);
	}

 }