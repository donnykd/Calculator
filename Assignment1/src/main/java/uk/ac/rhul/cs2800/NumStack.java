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
  
}
