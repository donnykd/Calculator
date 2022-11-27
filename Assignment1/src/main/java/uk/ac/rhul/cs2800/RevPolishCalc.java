package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;
import java.util.Scanner;

public class RevPolishCalc {
  private NumStack value = new NumStack();

  public float evaluate(String expression) throws Exception {
    try (Scanner sc = new Scanner(expression)) {
      String next;
      
      try {
        while (sc.hasNext()) {
          next = sc.next();

          if (Character.isDigit(next.charAt(0))) {
            value.push(Float.parseFloat(next));
          }

          else if (next.equals(Symbol.PLUS.toString()))
            value.push(value.pop() + value.pop());

          else if (next.equals(Symbol.MINUS.toString()))
            value.push(- value.pop() + value.pop());

          else if (next.equals(Symbol.TIMES.toString()))
            value.push(value.pop() * value.pop());

          else if (next.equals(Symbol.DIVIDE.toString()))
            value.push(1 / value.pop() * value.pop());
        }
      } catch (EmptyStackException e) {
        throw new Exception("Invalid Format");
      }
    }
    if (value.size() > 1)
      throw new Exception("Invalid Expression");
    if (value.size() == 1)
      return value.pop();
    return 0;
  }

}
