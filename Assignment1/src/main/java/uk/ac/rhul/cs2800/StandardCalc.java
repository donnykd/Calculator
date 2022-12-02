package uk.ac.rhul.cs2800;

import java.util.Scanner;

public class StandardCalc {
  private NumStack value = new NumStack();

  public float evaluate(String expression) {
    try (Scanner sc = new Scanner(expression)) {
      String next;
      while (sc.hasNext()) {
        next = sc.next();
        if (Character.isDigit(next.charAt(0))) 
          value.push(Float.parseFloat(next));
      }
    }
    if(value.size() > 0)
      return value.pop();
    else
      return 0;
  }

}
