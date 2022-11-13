package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

public class NumStack {
  private CalcStack ns = new CalcStack();

  public void push(float i) {
    ns.push(new CalcEntry(i));
  }

  public int size() {
    return ns.size();
  }

  public boolean isEmpty() {
    if (size() > 0)
      return false;
    return true;
  }

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
