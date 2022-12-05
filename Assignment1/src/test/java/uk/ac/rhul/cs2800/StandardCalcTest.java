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
  void testEvaluate0() throws Exception {
    assertEquals(0, calc.evaluate(""), "Tests if an empty string returns a 0");
  }

  @Test
  void testEvaluateNumber() throws Exception {
    assertEquals(100, calc.evaluate("100"), "Tests if 100 is returned once expression is entered");
    assertEquals(26, calc.evaluate("26"), "Tests if 26 is returned once expression is entered");
    assertEquals(922, calc.evaluate("922"), "Tests if 922 is returned once expression is entered");
  }

  @Test
  void testEvaluateAddition() throws Exception {
    assertEquals(10, calc.evaluate("5 + 5"),
        "Tests if the result of a simple addition will be returned");
    assertEquals(20, calc.evaluate("19 + 1"),
        "Tests if the result of a simple addition will be returned");
    assertEquals(22, calc.evaluate("20 + 2"),
        "Tests if the result of a simple addition will be returned");
    assertEquals(2, calc.evaluate("1 + 1"),
        "Tests if the result of a simple addition will be returned");
  }

  @Test
  void testEvaluateSubtraction() throws Exception {
    assertEquals(3, calc.evaluate("5 - 2"),
        "Tests if the result of a simple subtraction will be returned");
    assertEquals(18, calc.evaluate("19 - 1"),
        "Tests if the result of a simple subtraction will be returned");
    assertEquals(18, calc.evaluate("20 - 2"),
        "Tests if the result of a simple subtraction will be returned");
    assertEquals(0, calc.evaluate("1 - 1"),
        "Tests if the result of a simple subtraction will be returned");
  }

  @Test
  void testEvaluateMultiply() throws Exception {
    assertEquals(20, calc.evaluate("2 * 10"),
        "Tests if the result of a simple multiply will be returned");
    assertEquals(9, calc.evaluate("2.25 * 4"),
        "Tests if the result of a simple multiply will be returned");
    assertEquals(120, calc.evaluate("120 * 1"),
        "Tests if the result of a simple multiply will be returned");
    assertEquals(1, calc.evaluate("0.001 * 1000"),
        "Tests if the result of a simple multiply will be returned");
  }

  @Test
  void testEvaluateDivide() throws Exception {
    assertEquals(20, calc.evaluate("100 / 5"),
        "Tests if the result of a simple divide will be returned");
    assertEquals(1, calc.evaluate("0.5 / 0.5"),
        "Tests if the result of a simple divide will be returned");
    assertEquals(5, calc.evaluate("25 / 5"),
        "Tests if the result of a simple divide will be returned");
    assertEquals(11, calc.evaluate("22 / 2"),
        "Tests if the result of a simple divide will be returned");
  }

  @Test
  void testShuntingAlgWithoutBrackets() throws Exception {
    assertEquals(15, calc.evaluate("5 + 5 * 2"),
        "Tests the priority checking of operators and calculates it");
    assertEquals(19.5, calc.evaluate("19 + 1 / 2"),
        "Tests the priority checking of operators and calculates it");
    assertEquals(20, calc.evaluate("20 * 2 / 2"),
        "Tests the priority checking of operators and calculates it");
    assertEquals(11, calc.evaluate("100 / 10 + 1"),
        "Tests the priority checking of operators and calculates it");
    assertEquals(-1, calc.evaluate("1 * 1 - 2"),
        "Tests the priority checking of operators and calculates it");
  }

  @Test
  void testShuntingAlgFully() throws Exception {
    assertEquals(1, calc.evaluate("( 1 + 1 ) - 1"),
        "Tests the priority checking of operators with brackets included");
    assertEquals(25, calc.evaluate("5 * ( 3 + 2 )"),
        "Tests the priority checking of operators with brackets included");
    assertEquals(0.5, calc.evaluate("( 1 + 1 ) / ( 2 + 2 )"),
        "Tests the priority checking of operators with brackets included");
    assertEquals(41616, calc.evaluate("( 100 + 2 ) * ( 2 + 2 ) * ( 100 + 2 )"),
        "Tests the priority checking of operators with brackets included");
  }


}
