import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTester {
  GradeBook g1, g2, g3, g4;

  @Before
  public void setUp() throws Exception {
    g1 = new GradeBook(5);
    g2 = new GradeBook(5);
    g3 = new GradeBook(5);
    g4 = new GradeBook(5);
    
    g1.addScore(88);
    g1.addScore(44);
    g1.addScore(20);
    g2.addScore(95);
    g2.addScore(54);
    
    /* TESTS BEYOND SCOPE OF LAB 6:
     * gb3 with just one element in scores: 
     *  -> test that Final Sum doesn't discard the only element
     *  
     * gb4 with empty scores array
     *  -> test that sum, minimum and finalSum will return 0 
     */
    g3.addScore(27);
  }

  @After
  public void tearDown() throws Exception {
    g1 = g2 = g3 = g4 = null;
  }

  @Test
  public void testAddScore() {
    assertTrue(g1.toString().equals("88.0 44.0 20.0 "));
    assertTrue(g2.toString().equals("95.0 54.0 "));
    assertTrue(g3.toString().equals("27.0 "));
    assertTrue(g4.toString().equals(""));
    
  }

  @Test
  public void testSum() {
    assertEquals(152, g1.sum(), .0001);
    assertEquals(149, g2.sum(), .0001);
    assertEquals(27, g3.sum(), .0001);
    assertEquals(0, g4.sum(), .0001);
  }

  @Test
  public void testMinimum() {
    assertEquals(20, g1.minimum(), .001);
    assertEquals(54, g2.minimum(), .001);
    assertEquals(27, g3.minimum(), .001);
    assertEquals(0, g4.minimum(), .001);
  }

  @Test
  public void testFinalScore() {
    assertEquals(132, g1.finalScore(), .0001);
    assertEquals(95, g2.finalScore(), .0001);
    assertEquals(27, g3.finalScore(), .0001);
    assertEquals(0, g4.finalScore(), .0001);
  }
}