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
  
  public float pop() throws Exception {
    if(isEmpty())
      throw new EmptyStackException();
    float answer = ns.stack.get(ns.stack.size() - 1).getFloat();
    ns.stack.remove(ns.stack.size() - 1);
    return answer;
    }
  
}
