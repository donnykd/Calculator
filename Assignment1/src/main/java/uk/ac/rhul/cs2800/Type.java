package uk.ac.rhul.cs2800;

/**
 * @author Khalid Mahamed
 *
 *         Creates either a Number, Symbol or String enum entity. Has a toString method that returns
 *         a string of the name of each entity.
 */
public enum Type {
  NUMBER("Number"), SYMBOL("Symbol"), STRING("String"), INVALID("Invalid");

  private String print; // used to initialise and store the string of each enum.

  private Type(String s) {
    print = s;
  }

  /**
   * Returns the string of each enum.
   */
  @Override
  public String toString() {
    return print;
  }
}
