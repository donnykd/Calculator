package uk.ac.rhul.cs2800;

public class NumStack {
  private CalcStack ns = new CalcStack();

  public void push(float i) {
    ns.push(new CalcEntry(i));
  }
  
  public int size() {
    return ns.size();
  }
  
  public boolean isEmpty() {
    if (size() == 0)
      return true;
    return false;
  }
  
}
