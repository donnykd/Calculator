package uk.ac.rhul.cs2800;

/**
 * @author Khalid Mahamed
 * 
 *         A facade stack class that will hide most complicated code and let the stack class do its
 *         work. Made to hold symbols only.
 *
 */
public class OpStack {
  private CalcStack os = new CalcStack();

  /**
   * Adds to the stack
   * 
   * @param i symbol that will be added to the top of the stack.
   */
  public void push(Symbol i) {
    os.push(new CalcEntry(i));
  }

  /**
   * Size of the stack
   * 
   * @return The amount of symbols in the stack.
   */
  public int size() {
    return os.size();
  }

  /**
   * @return boolean value depending if the value is empty or not.
   */
  public boolean isEmpty() {
    if (size() > 0)
      return false;
    return true;
  }

  /**
   * Removes top value from Stack
   * 
   * @return symbol on the top of the stack while also removing it.
   */
  public Symbol pop() {
    Symbol answer = null;

    try {
      // done to get symbol specifically
      answer = os.pop().getSymbol();
    } catch (Exception e) {
      System.out.println("This cannot occur");
    }
    return answer;
  }

  /**
   * Returns top value from Stack
   * 
   * @return symbol on the top of the stack without removing it.
   */
  public Symbol top() {
    Symbol answer = null;

    try {
      answer = os.top().getSymbol();
    } catch (Exception e) {
      System.out.println("This cannot occur");
    }
    return answer;
  }


}
