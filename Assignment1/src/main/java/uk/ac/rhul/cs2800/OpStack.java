package uk.ac.rhul.cs2800;

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

}
