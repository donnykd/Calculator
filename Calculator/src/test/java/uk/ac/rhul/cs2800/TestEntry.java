package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TestEntry {
  CalcEntry ce; // This was simply used as the main object throughout. There are instances used
                // where more than one CalcEntry object is created but to save space this was used
                // as the main one


  /*
   * Most of the tests have been edited throughout writing the code.
   * 
   * All of the Tests have comments on top show casing the order they have been created.
   * Descriptions of the test itself is within each test as the final string argument. Additional
   * information will be followed right after comments that show the order.
   */

  @Test // 1st test, Tests the constructor and the getter method for float. Was edited since it only
        // tested the constructor at first.
  void testFloat() throws Exception {
    ce = new CalcEntry((float) 12.1234);
    assertEquals(ce.getFloat(), (float) 12.1234,
        "Tests if the getFloat method returns the same float created");
  }

  @Test // 2nd test, Tests the constructor and the getter method for symbol. Was edited since it
        // only tested the constructor at first. Created the Symbol enum before continuing with
        // this.
  void testSymbol() throws Exception {
    ce = new CalcEntry(Symbol.LEFT_BRACKET);
    assertEquals(ce.getSymbol().toString(), Symbol.LEFT_BRACKET.toString(),
        "Tests if the returned value is the same one created");
  }

  @Test // 3th test, Had to create Type enum before continuing with this.
  void testException() {
    ce = new CalcEntry(Symbol.DIVIDE);
    assertThrows(Exception.class, () -> ce.getFloat(), "Tests if an exception is thrown");
  }

  @Test // 4th test, Tests minor differences between the CalcEntry entry
  void testEquals() {
    ce = new CalcEntry((float) 29.332);
    CalcEntry ce2 = new CalcEntry((float) 29.33);
    assertFalse(ce.equals(ce2), "Tests if the 2 objects are not equal");
  }



  @Test // 5th test, Tests if the same float will be equal.
  void testEquals3() {
    ce = new CalcEntry((float) 12);
    CalcEntry ce2 = new CalcEntry((float) 12);
    assertTrue(ce.equals(ce2), "Tests if the 2 objects are equal");
  }

  @Test // 6th test
  void testHash() {
    ce = new CalcEntry((float) 1);
    CalcEntry ce2 = new CalcEntry((float) 1);
    assertEquals(ce.hashCode(), ce2.hashCode(), "Tests if the 2 object have the same hashcode");
  }



}
