package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StandardCalcTest {
  StandardCalc calc;

  @BeforeEach
  public void setup() {
    calc = new StandardCalc();
  }

  @Test
  void testEvaluate0() {
    assertEquals(0, calc.evaluate(""), "Tests if an empty string returns a 0");
  }
  
  @Test
  void testEvaluateNumber() {
    assertEquals(100, calc.evaluate("100"), "Tests if 100 is returned once expression is entered");
    assertEquals(26, calc.evaluate("26"), "Tests if 26 is returned once expression is entered");
    assertEquals(922, calc.evaluate("922"), "Tests if 922 is returned once expression is entered");
  }
  
  @Test
  void testEvaluateSimpleAddition() {
    assertEquals(10, calc.evaluate("5 + 5"), "Tests if the result of a simple addition will be returned");
  }

}
