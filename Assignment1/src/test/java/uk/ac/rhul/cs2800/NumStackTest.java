package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumStackTest {
  NumStack nums;
  
  @BeforeEach
  public void setup() {
   nums = new NumStack();
  }

  @Test //Test 1, created a size method to make sure I can test the size of the array once I push.
  void testPush() {
    nums.push((float)11.2);
    assertEquals(nums.size(), 1, "Tests if the size of the array is increased if pushed");
  }
  
  @Test //Test 2 
  void testIsEmpty(){
    assertTrue(nums.isEmpty(), "Checks if the ArrayList is empty");
    nums.push((float)1);
    assertFalse(nums.isEmpty(), "Checks if the ArrayList is not empty");
  }
  
  @Test //Test 3, tests all methods and checks if they work together well.
  void testPop() throws Exception {
    nums.push((float)20);
    assertEquals(nums.pop(), (float)20, "Tests if the value popped is equal to the value pushed");
    assertTrue(nums.isEmpty(), "Test to make sure that pop method removes the value pushed in");
  }
  

}
