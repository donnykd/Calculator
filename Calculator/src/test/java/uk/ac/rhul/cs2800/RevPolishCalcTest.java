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
  
  /*
   * All of the Tests have comments on top show casing the order they have been created.
   * Descriptions of the test itself is within each test as the final string argument. Additional
   * information will be followed right after comments that show the order.
   * 
   */

  @Test //1st test
  void testEvaluate0() throws Exception {
    assertEquals(0, calc.evaluate(""), "Tests if an empty string returns a 0");
  }
  
  @Test //2nd test
  void testEvaluateNumber() throws Exception {
    assertEquals(2, calc.evaluate("2"), "Tests if a number is returned if the string contains a character");
  }
  
  @Test //3rd test
  void testEvaluateMoreNumbers() throws Exception {
    assertEquals(3455, calc.evaluate("3455"), "Tests if a number is returned if the string contains 2 numbers");
  }

  @Test //4th test
  void testEvaluateSpace() throws Exception {
    assertEquals(29, calc.evaluate("29  "), "Tests if space is skipped when evaluating answer");
  }
  
  @Test //5th test
  void testEvaluateSimpleAddition() throws Exception {
    assertEquals(5, calc.evaluate("2 3 +"), "Tests if it differentiates between two different numbers, and then add the 2 floats together");
  }
  
  @Test //6th test
  void testEvaluateNegativeSign() throws Exception {
    assertEquals(4, calc.evaluate("5 1 -"), "Tests if it will recognise the negative operand and do simple calculation");
  }
  
  @Test //7th test
  void testEvaluateMultiplySign() throws Exception {
    assertEquals(60, calc.evaluate("6 10 *"), "Tests if it will recognise the Multiply operand and do simple calculation");
  }
  
  @Test //8th test
  void testEvaluateDivideSign() throws Exception {
    assertEquals(2, calc.evaluate("4 2 /"), "Tests if it will recognise the Divide operand and do simple calculation");
  }
  
  @Test //9th test
  void testEvaluateMultipleOperands() throws Exception {
    assertEquals(3, calc.evaluate("4 2 + 3 -"), "Tests if longer expressions work");
    assertEquals(10, calc.evaluate("30 5 / 4 +"), "Tests if longer expressions work");
    assertEquals(255, calc.evaluate("100 2 + 2 / 5 *"), "Tests if longer expressions work");
  }
  
  @Test //10th test
  void testEvaluateError() throws Exception {
    Exception exception = assertThrows(Exception.class, () -> calc.evaluate("4 -"));
    assertEquals(exception.getMessage(), "Invalid Format");
  }
  
  @Test //11th test
  void testEvaluateComplexError() throws Exception {
    Exception exception = assertThrows(Exception.class, () -> calc.evaluate("4 * 4 - /"));
    assertEquals(exception.getMessage(), "Invalid Format");
  }
  
  @Test //12th test
  void testEvaluateExpressionError() throws Exception {
    Exception exception = assertThrows(Exception.class, () -> calc.evaluate("4 5 + 2 3 +"));
    assertEquals(exception.getMessage(), "Invalid Expression");
  }
  
  
}
