

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	Property p1 ,p2,p3,p4,p5,p6;
			ManagementCompany mgmt;

	@Before
	public void setUp() throws Exception {
		//student create a management company
		
		//student add three properties, with plots, to mgmt co

		p1 = new Property ("Property 1", "Potomac", 600, "Cromwell Nzouakeu", 2, 1, 2, 2);
		p2 = new Property ("Property 2", "Rockville", 700, "Kennedy Nzouakeu", 4, 1, 2, 2);
		p3 = new Property ("Property 3", "Takoma Park", 800, "Meet Kevin", 6, 1, 2, 2);
		
		mgmt = new ManagementCompany("MGMT Company 1", "ABC123", 6);
	 
		mgmt.addProperty(p1);
		mgmt.addProperty(p2);
		mgmt.addProperty(p3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null 
		mgmt = null;  

	}

	@Test
	public void testAddPropertyDefaultPlot() {
		p4 = new Property ("Property 1", "Potomac", 888, "JC Tucker3",2,5,2,2);
		p5 = new Property ("Property 1", "Potomac", 999, "JC Tucker4",4,5,2,2);
		p6 = new Property ("Property 1", "Potomac", 111, "JC Tucker5",6,5,2,2);
		 
		assertEquals(mgmt.addProperty(p4),3,0);
		assertEquals(mgmt.addProperty(p5),4,0);
		assertEquals(mgmt.addProperty(p6),-1,0);  //exceeds the size of the array and can not be added, add property should return -1	

		
		//student should add property with 4 args & default plot (0,0,1,1)
		//student should add property with 8 args
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
	}
 
	@Test
	public void testMaxRentProp() {
		
		assertEquals(mgmt.maxRentProp(),800.0,0);
		//student should test if maxRentProp contains the maximum rent of properties
		
	}

	@Test
	public void testTotalRent() {
		assertEquals(mgmt.totalRent(),2100 ,0);
		//student should test if totalRent returns the total rent of properties
	}

 }