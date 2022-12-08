package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * @author Khalid Mahamed
 * 
 *         This program creates a horizontal stack supporting CalcEntry objects that can be added
 *         and removed from an ArrayList as a stack.
 */
public class CalcStack {
  /**
   * An ArrayList created to store CalcEntry objects.
   */
  private ArrayList<CalcEntry> stack = new ArrayList<CalcEntry>();

  /*
   * Returns the size of the stack.
   * 
   * @return Size of the stack.
   */
  public int size() {
    return stack.size();
  }

  /*
   * Adds an object into the stack.
   * 
   * @param CalcEntry object i to be added into the stack.
   */
  public void push(CalcEntry i) {
    stack.add(i);
  }

  /*
   * Returns the CalcEntry object on top of the stack by calling the top() method while also
   * removing it from the stack.
   * 
   * @return CalcEntry object and removes it from the top of the stack.
   */
  public CalcEntry pop() {
    CalcEntry answer = this.top();
    stack.remove(stack.size() - 1);
    return answer;
  }

  /*
   * Returns the CalcEntry object on top of the stack if the stack is not empty, otherwise returns a
   * new EmptyStackException.
   * 
   * @return CalcEntry object that is on top of the stack.
   */
  public CalcEntry top() {
    if (stack.isEmpty()) {
      throw new EmptyStackException();
    }
    return stack.get(stack.size() - 1);
  }

}
