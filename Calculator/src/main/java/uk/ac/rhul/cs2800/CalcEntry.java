package uk.ac.rhul.cs2800;

import java.util.Objects;

/**
 * @author Khalid Mahamed
 * 
 *         Stores and constructs a string, float or a symbol. It has its respective getters and also
 *         methods to identify its uniqueness.
 *
 */
public class CalcEntry {
  private float f;
  private Symbol symbol;
  /**
   * Set inside the constructor to determine the value of the object created.
   * 
   * Type is set automatically depending on the parameters of the constructor.
   */
  Type type;

  /*
   * Public constructor that takes in float number and sets the type to a number.
   * 
   * @param i value used to create the CalcEntry object.
   */
  public CalcEntry(float i) {
    this.f = i;
    type = Type.NUMBER;
  }

  /*
   * Public constructor that takes in a symbol and sets the type to a number.
   * 
   * @param s value used to create the CalcEntry object.
   */
  public CalcEntry(Symbol s) {
    this.symbol = s;
    type = Type.SYMBOL;
  }


  /*
   * Checks if a float constructed object calls the method and returns the float if it does.
   * Otherwise it returns a BadType Exception.
   * 
   * @return Float if the type matches.
   * 
   * @throws Exception when object constructed with wrong type tries to call this method.
   * 
   */
  public float getFloat() throws Exception {
    if (this.type.toString().equals("Number")) {
      return this.f;
    }
    throw new Exception("Bad Type");
  }

  /*
   * Checks if a Symbol constructed object calls the method and returns the Symbol if it does.
   * Otherwise it returns a BadType Exception.
   * 
   * @return Symbol if the type matches.
   * 
   * @throws Exception when object constructed with wrong type tries to call this method.
   */
  public Symbol getSymbol() throws Exception {
    if (this.type.toString().equals("Symbol")) {
      return this.symbol;
    }
    throw new Exception("Bad Type");
  }


  /*
   * Returns a unique hash for every contained type.
   *
   */
  @Override
  public int hashCode() {
    return Objects.hash(f, symbol);
  }

  /*
   * Returns true if an object has the same type and value as the parameters. Otherwise returns
   * false.
   *
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CalcEntry other = (CalcEntry) obj;
    return Float.floatToIntBits(f) == Float.floatToIntBits(other.f) && symbol == other.symbol
        && type == other.type;
  }
}
