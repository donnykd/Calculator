package uk.ac.rhul.cs2800;

/**
 * @author Khalid Mahamed
 * 
 *         Chooses with a boolean, if the expression shall be solved using either an infix
 *         calculator or a reverse polish calculator.
 *
 */
public class CalcModel {
  // Instance of my infix calculator
  private StandardCalc sc;
  // Instance of my reverse polish calculator
  private RevPolishCalc rp;

  /**
   * Chooses StandardCalc to evaluate expression if boolean is true, else chooses RevPolishCalc
   * 
   * @param expression, mathematical expression that the user inputed to be solved as a string.
   * @param infix, boolean to determine how the expression is going to be calculated,
   * @return answer to the expression in float.
   * @throws Exception, thrown when invalid format or invalid expression.
   */
  public float evaluate(String expression, boolean infix) throws Exception {
    if (infix) {
      sc = new StandardCalc();
      return sc.evaluate(expression);
    } else {
      rp = new RevPolishCalc();
      return rp.evaluate(expression);
    }
  }

}
