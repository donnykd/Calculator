package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RevPolishCalcTest {
  RevPolishCalc calc;
  
  @BeforeEach
  public void setup() {
    calc = new RevPolishCalc();
  }

  @Test
  void testEvaluate0() {
    assertEquals(0, calc.evaluate(""), "Tests if an empty string returns a 0");
  }
  
  @Test
  void testEvaluateNumber() {
    assertEquals(2, calc.evaluate("2"), "Tests if a number is returned if the string contains a character");
  }
  
  @Test
  void testEvaluateMoreNumbers() {
    assertEquals(34, calc.evaluate("34"), "Tests if a number is returned if the string contains 2 numbers");
  }

}
