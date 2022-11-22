package uk.ac.rhul.cs2800;

import java.util.Scanner;

public class RevPolishCalc {
  private NumStack value = new NumStack();

  public float evaluate(String expression) {
    Scanner sc = new Scanner(expression);
    String next;
    float value1;
    float value2;

    while (sc.hasNext()) {
      next = sc.next();

      if (Character.isDigit(next.charAt(0))) {
        value.push(Float.parseFloat(next));
      }

      else if (next.equals("+")) {
        value.push(value.pop() + value.pop());
      }

      else if (next.equals("-")) {
        value1 = value.pop();
        value2 = value.pop();
        value.push(value2  - value1);
      }
      
      else if (next.equals("*")) {
        value.push(value.pop()  * value.pop());
      }
      
      else if (next.equals("/")) {
        value1 = value.pop();
        value2 = value.pop();
        value.push(value2  / value1);
      }

    }
    if (value.size() == 1)
      return value.pop();
    return 0;
  }

}
