package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStack {
  CalcStack cs;

  @BeforeEach
  public void setup() {
    cs = new CalcStack();
  }

  /*
   * All of the Tests have comments on top show casing the order they have been created.
   * Descriptions of the test itself is within each test as the final string argument. Additional
   * information will be followed right after comments that show the order.
   */

  @Test // 1st test, Simple test on the size.
  void testSize() {
    assertEquals(cs.size(), 0, "Tests the stack to see if it equals 0");
  }

  @Test // 2nd test, Tests if size and push work together work well together.
  void testPush() {
    CalcEntry f = new CalcEntry((float) 2);
    cs.push(f);
    assertEquals(cs.size(), 1,
        "Tests if the stack size will equal to 1 after pushing in a CalcEntry object");
  }

  @Test // 3rd test, making sure it the stack can take more than 1 object.
  void testPushMore() {
    CalcEntry f = new CalcEntry((float) 10);
    CalcEntry f2 = new CalcEntry((float) 9);
    cs.push(f);
    cs.push(f2);
    assertEquals(cs.size(), 2,
        "Tests if the stack size will equal to 2 after pushing in 2 CalcEntry objects");
  }

  @Test // 4th test, Testing to see if an exception was thrown.
  void testPopEmpty() {
    assertThrows(EmptyStackException.class, () -> cs.pop(), "Cannot pop from an empty stack");
  }

  @Test // 5th test, Tests if pop and push work together work well together.
  void testPushThenPop() {
    CalcEntry f = new CalcEntry((float) 2);
    cs.push(f);
    assertEquals(cs.pop(), f,
        "Tests if the value popped is equal to the value of the CalcEntry object pushed");
    assertEquals(cs.size(), 0, "Tests if the size of the stack is now 0 after popping");
    assertThrows(EmptyStackException.class, () -> cs.pop(), "Cannot pop from an empty stack");
  }

  @Test // 6th test, Similar to the previous test but with variation.
  void testPushThenPopMult() {
    CalcEntry f = new CalcEntry((float) 2);
    CalcEntry f2 = new CalcEntry((float) 5);
    cs.push(f);
    cs.push(f2);
    assertEquals(cs.pop(), f2,
        "Tests if the value popped is equal to the value of the CalcEntry object last pushed");
    assertEquals(cs.pop(), f,
        "Tests if the value popped is equal to the value of the CalcEntry object pushed before the previous one");
    assertEquals(cs.size(), 0, "Tests if the size of the stack is now 0 after popping twice");
    assertThrows(EmptyStackException.class, () -> cs.pop(), "Cannot pop from an empty stack");
  }

  @Test // 7th test, Similar to the test, testPopEmpty. In the class, at first I coded both of them
        // separately instead of implementing the top() method onto the pop() method. Hence the same
        // exact test for different methods.
  void testTopEmpty() {
    assertThrows(EmptyStackException.class, () -> cs.top(), "Nothing is on top of the empty stack");
  }

  @Test // 8th test, I would call this the ultimate test. Combines all the methods in the CalcStack
        // class with different scenarios throughout.
  void testTop() {
    CalcEntry s = new CalcEntry(Symbol.DIVIDE);
    CalcEntry s2 = new CalcEntry(Symbol.LEFT_BRACKET);
    CalcEntry f = new CalcEntry((float) 3);
    cs.push(s);
    cs.push(s2);
    cs.push(f);
    assertEquals(cs.top(), f,
        "Tests if the value on top is equal to the value of the CalcEntry object last pushed");
    CalcEntry f2 = new CalcEntry((float) 99);
    cs.push(f2);
    assertEquals(cs.top(), f2,
        "Tests if the value on top is equal to the value of the CalcEntry object last pushed");
    for (int i = 0; i < 4; i++) { // done to remove all the objects pushed instead of calling the
                                  // pop method one by one
      cs.pop();
    }
    assertThrows(EmptyStackException.class, () -> cs.top(), "Nothing is on top of the empty stack");
  }

}
