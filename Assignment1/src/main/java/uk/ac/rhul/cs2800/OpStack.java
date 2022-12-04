package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

public class OpStack {
  private CalcStack os = new CalcStack();

  public void push(Symbol i) {
    os.push(new CalcEntry(i));
  }

  public int size() {
    return os.size();
  }
  
  public boolean isEmpty() {
    if (size() > 0)
      return false;
    return true;
  }
  
  public Symbol pop() {
    if (isEmpty())
      throw new EmptyStackException();
    Symbol answer = null;
    
    try {
      answer = os.pop().getSymbol();
    } catch (Exception e) {
      System.out.println("This cannot occur");
    }
    return answer;
  }

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
