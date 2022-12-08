package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpStackTest {

  OpStack Ops;

  @BeforeEach
  public void setup() {
    Ops = new OpStack();
  }
  
  /*
   * All of the Tests have comments on top show casing the order they have been created.
   * Descriptions of the test itself is within each test as the final string argument. Additional
   * information will be followed right after comments that show the order.
   * 
   */

  @Test // Test 1, created a size method to make sure I can test the size of the array once I push.
  void testPush() {
    Ops.push(Symbol.PLUS);
    assertEquals(Ops.size(), 1, "Tests if the size of the array is increased if pushed");
  }
  
  @Test //Test 2 
  void testIsEmpty(){
    assertTrue(Ops.isEmpty(), "Checks if the ArrayList is empty");
    Ops.push(Symbol.DIVIDE);
    assertFalse(Ops.isEmpty(), "Checks if the ArrayList is not empty");
  }
  
  @Test //Test 3, tests all methods and checks if they work together well.
  void testPop() throws Exception {
    Ops.push(Symbol.LEFT_BRACKET);
    assertEquals(Ops.pop(), Symbol.LEFT_BRACKET, "Tests if the value popped is equal to the value pushed");
    assertTrue(Ops.isEmpty(), "Test to make sure that pop method removes the value pushed in");
  }
  
  @Test //Test 4, Made during standardCalc class
  void testTop(){
    Ops.push(Symbol.LEFT_BRACKET);
    assertEquals(Ops.top(), Symbol.LEFT_BRACKET, "Tests if the value popped is equal to the value pushed");
    assertFalse(Ops.isEmpty(), "Test to make sure that pop method does not remove the value pushed in");
  }




}
