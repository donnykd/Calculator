package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumStackTest {
  NumStack ns;
  
  @BeforeEach
  public void setup() {
   ns = new NumStack();
  }

  @Test //Test 1, created a size method to make sure I can test the size of the array once I push.
  void testPush() {
    ns.push((float)11.2);
    assertEquals(ns.size(), 1, "Tests if the size of the array is increased if pushed");
  }
  
  @Test //Test 2 
  void testIsEmpty(){
    assertTrue(ns.isEmpty(), "Checks if the ArrayList is empty");
    ns.push((float)1);
    assertFalse(ns.isEmpty(), "Checks if the ArrayList is not empty");
  }
  
  @Test //Test 3, 
  void testPop() throws Exception {
    ns.push((float)20);
    assertEquals(ns.pop(), (float)20, "Tests if the value popped is equal to the value pushed");
    assertTrue(ns.isEmpty(), "Test to make sure that pop method removes the value pushed in");
  }

}
