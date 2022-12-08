package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SymbolTest {
  Symbol symbol;

  @Test
  void testSymbol() {
    symbol = Symbol.PLUS;
  }

  @Test
  void testSymbolEqual() {
    symbol = Symbol.PLUS;
    assertEquals(symbol.toString(), "+", "checks if toString method returns the correct string");
  }


}
