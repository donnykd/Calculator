package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StrStackTest {
  StrStack Strs;

  @BeforeEach
  public void setup() {
    Strs = new StrStack();
  }

  @Test // Test 1, created a size method to make sure I can test the size of the array once I push.
  void testPush() {
    Strs.push("hello");
    assertEquals(Strs.size(), 1, "Tests if the size of the array is increased if pushed");
  }
  
  @Test //Test 2 
  void testIsEmpty(){
    assertTrue(Strs.isEmpty(), "Checks if the ArrayList is empty");
    Strs.push("hello");
    assertFalse(Strs.isEmpty(), "Checks if the ArrayList is not empty");
  }
}
