package uk.ac.rhul.cs2800;

/**
 * @author Khalid Mahamed
 * 
 *         Creates either a Plus, Minus, Times, Divide, Left bracket, Right Brackets sign enum
 *         entity. Has a toString method that returns a string of the name of each entity.
 *
 */
public enum Symbol {
  PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/"), LEFT_BRACKET("("), RIGHT_BRACKET(")"), INVALID(
      "Invalid");

  private String print; // used to initialise and store the string of each enum.

  private Symbol(String string) {
    print = string;
  }

  /**
   * Returns the string of each enum.
   */
  @Override
  public String toString() {
    return print;
  }
}
