package uk.ac.rhul.cs2800;
import java.util.Scanner;

public class RevPolishCalc {
  private NumStack values = new NumStack();
  
  public float evaluate(String expression) {
    Scanner sc = new Scanner(expression);
    while(sc.hasNext() != false)
      return Float.parseFloat(expression);
    return 0;
  }
}
