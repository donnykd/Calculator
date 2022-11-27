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
  void testEvaluate0() throws Exception {
    assertEquals(0, calc.evaluate(""), "Tests if an empty string returns a 0");
  }
  
  @Test
  void testEvaluateNumber() throws Exception {
    assertEquals(2, calc.evaluate("2"), "Tests if a number is returned if the string contains a character");
  }
  
  @Test
  void testEvaluateMoreNumbers() throws Exception {
    assertEquals(3455, calc.evaluate("3455"), "Tests if a number is returned if the string contains 2 numbers");
  }

  @Test
  void testEvaluateSpace() throws Exception {
    assertEquals(29, calc.evaluate("29  "), "Tests if space is skipped when evaluating answer");
  }
  
  @Test
  void testEvaluateSimpleAddition() throws Exception {
    assertEquals(5, calc.evaluate("2 3 +"), "Tests if it differentiates between two different numbers, and then add the 2 floats together");
  }
  
  @Test
  void testEvaluateNegativeSign() throws Exception {
    assertEquals(4, calc.evaluate("5 1 -"), "Tests if it will recognise the negative operand and do simple calculation");
  }
  
  @Test
  void testEvaluateMultiplySign() throws Exception {
    assertEquals(60, calc.evaluate("6 10 *"), "Tests if it will recognise the Multiply operand and do simple calculation");
  }
  
  @Test
  void testEvaluateDivideSign() throws Exception {
    assertEquals(2, calc.evaluate("4 2 /"), "Tests if it will recognise the Divide operand and do simple calculation");
  }
  
  @Test
  void testEvaluateMultipleOperands() throws Exception {
    assertEquals(3, calc.evaluate("4 2 + 3 -"), "Tests if longer expressions work");
    assertEquals(10, calc.evaluate("30 5 / 4 +"), "Tests if longer expressions work");
    assertEquals(255, calc.evaluate("100 2 + 2 / 5 *"), "Tests if longer expressions work");
  }
  
  @Test
  void testEvaluateError() throws Exception {
    Exception exception = assertThrows(Exception.class, () -> calc.evaluate("4 -"));
    assertEquals(exception.getMessage(), "Invalid Format");
  }
  
  @Test
  void testEvaluateComplexError() throws Exception {
    Exception exception = assertThrows(Exception.class, () -> calc.evaluate("4 * 4 - /"));
    assertEquals(exception.getMessage(), "Invalid Format");
  }
  
  @Test
  void testEvaluateExpressionError() throws Exception {
    Exception exception = assertThrows(Exception.class, () -> calc.evaluate("4 5 + 2 3 +"));
    assertEquals(exception.getMessage(), "Invalid Expression");
  }
  
  
}
