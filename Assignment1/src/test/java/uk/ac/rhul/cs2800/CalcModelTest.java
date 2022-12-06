package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalcModelTest {
  CalcModel cm;
  
  @BeforeEach
  void setup(){
    cm = new CalcModel();
  }

  @Test
  void testInfix() throws Exception {
    assertEquals(20, cm.evaluate("5 + 15", true), "This test checks if the boolean will trigger the calculator to choose infix and evaluate the expression");
  }
  
  

}
