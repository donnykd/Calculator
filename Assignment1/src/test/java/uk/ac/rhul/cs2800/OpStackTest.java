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

  @Test // Test 1, created a size method to make sure I can test the size of the array once I push.
  void testPush() {
    Ops.push(Symbol.PLUS);
    assertEquals(Ops.size(), 1, "Tests if the size of the array is increased if pushed");
  }


}
