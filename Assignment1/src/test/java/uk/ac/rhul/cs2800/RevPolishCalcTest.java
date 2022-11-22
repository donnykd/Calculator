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
    assertEquals(3455, calc.evaluate("3455"), "Tests if a number is returned if the string contains 2 numbers");
  }

  @Test
  void testEvaluateSpace() {
    assertEquals(29, calc.evaluate("29  "), "Tests if space is skipped when evaluating answer");
  }
  
  @Test
  void testEvaluateSimpleAddition() {
    assertEquals(5, calc.evaluate("2 3 +"), "Tests if it differentiates between two different numbers, and then add the 2 floats together");
  }
  
  @Test
  void testEvaluateNegativeSign() {
    assertEquals(4, calc.evaluate("5 1 -"), "Tests if it will recognise the negative operand and do simple calculation");
  }
}
