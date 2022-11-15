package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

public class StrStack {
  private CalcStack ss = new CalcStack();

  public void push(String i) {
    ss.push(new CalcEntry(i));
  }
  
  public int size() {
    return ss.size();
  }
  
  public boolean isEmpty() {
    if (size() > 0)
      return false;
    return true;
  }
  
  public String pop() {
    if (isEmpty())
      throw new EmptyStackException();
    String answer = null;
    
    try {
      answer = ss.pop().getString();
    } catch (Exception e) {
      System.out.println("This cannot occur");
    }
    return answer;
  }

}
