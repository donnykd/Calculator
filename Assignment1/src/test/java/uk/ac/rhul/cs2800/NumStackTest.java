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

}
