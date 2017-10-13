import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class CSC1016STest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** A getNameTest to test the getName() method. **/
   @Test public void getNameTest() {
     CSC1016S tiro = new CSC1016S();
     tiro.setName("Tiro");
     String result = tiro.getName();
     Assert.assertEquals("Tiro", result);
   }

   /** An all zero mark test **/
   @Test public void getFinalZeroTest() {
     CSC1016S tiro = new CSC1016S();
     tiro.setMark("pracs", 0);
     tiro.setMark("practests", 0);
     tiro.setMark("tests", 0);
     tiro.setMark("exam", 0);
     float result = tiro.getFinal();
     Assert.assertEquals(0.0f, result, 0.0002);
   }

   /** An all hundred mark test **/
   @Test public void getFinalHundredTest() {
     CSC1016S tiro = new CSC1016S();
     tiro.setMark("pracs", 100);
     tiro.setMark("practests", 100);
     tiro.setMark("tests", 100);
     tiro.setMark("exam", 100);
     float result = tiro.getFinal();
     Assert.assertEquals(100.0f, result, 0.0002);
   }

   /** An all hundred mark test **/
   @Test public void getFinalRandomMarksTest() {
     CSC1016S tiro = new CSC1016S();
     tiro.setMark("pracs", 93);
     tiro.setMark("practests", 95);
     tiro.setMark("tests", 65);
     tiro.setMark("exam", 40);
     float result = tiro.getFinal();
     Assert.assertEquals(57.0f, result, 0.0002);
   }
}
