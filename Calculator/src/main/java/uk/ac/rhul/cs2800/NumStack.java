package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * @author Khalid Mahamed
 * 
 *         A facade stack class that will hide most complicated code and let the stack class do its
 *         work. Made to hold floats only.
 *
 */
public class NumStack {
  private CalcStack ns = new CalcStack();

  /**
   * Adds to the stack
   * 
   * @param i float that will be added to the top of the stack.
   */
  public void push(float i) {
    ns.push(new CalcEntry(i));
  }

  /**
   * Size of the stack
   * 
   * @return The amount of symbols in the stack.
   */
  public int size() {
    return ns.size();
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
   * @return float on the top of the stack while also removing it.
   */
  public float pop() {
    if (isEmpty())
      throw new EmptyStackException();

    float answer = 0;

    try {
      answer = ns.pop().getFloat();
    } catch (Exception e) {
      System.out.println("This cannot occur");
    }
    return answer;
  }

}
