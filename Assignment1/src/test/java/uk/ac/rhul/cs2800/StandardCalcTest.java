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
    assertEquals(100, calc.evaluate("100"), "Tests if a number is returned once expression is entered");
  }

}
