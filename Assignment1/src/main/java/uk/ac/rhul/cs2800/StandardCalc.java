package uk.ac.rhul.cs2800;

import java.util.ArrayDeque;
import java.util.Scanner;

public class StandardCalc {
  private OpStack value = new OpStack();
  RevPolishCalc rpcalc = new RevPolishCalc();
  ArrayDeque<String> queue = new ArrayDeque<String>();

  public float evaluate(String expression) throws Exception {
    try (Scanner sc = new Scanner(expression)) {
      String next;

      while (sc.hasNext()) {
        next = sc.next();

        if (Character.isDigit(next.charAt(0)))
          queue.push(next + " ");

        else if (next.equals(Symbol.PLUS.toString())) {
          if (!(value.isEmpty())) {
            if (value.top().equals(Symbol.TIMES) || value.top().equals(Symbol.DIVIDE)) {
              String temp = value.pop().toString();
              queue.push(temp + " ");
            }
          }
          value.push(Symbol.PLUS);
        }

        else if (next.equals(Symbol.MINUS.toString())) {
          if (!(value.isEmpty())) {
            if (value.top().equals(Symbol.TIMES) || value.top().equals(Symbol.DIVIDE)) {
              String temp = value.pop().toString();
              queue.push(temp + " ");
            }
          }
          value.push(Symbol.MINUS);
        }
        
        else if (next.equals(Symbol.DIVIDE.toString()))
          value.push(Symbol.DIVIDE);

        else if (next.equals(Symbol.TIMES.toString()))
          value.push(Symbol.TIMES);
        
        else if (next.equals(Symbol.LEFT_BRACKET.toString()))
          value.push(Symbol.LEFT_BRACKET);
        
        else if (next.equals(Symbol.RIGHT_BRACKET.toString())) {
          while(!(value.top().equals(Symbol.LEFT_BRACKET))) {
            String temp = value.pop().toString();
            queue.push(temp + " ");
          }
        }
      }
      while (!(value.isEmpty())) {
        String temp = value.pop().toString();
        queue.push(temp + " ");
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!(queue.isEmpty())) {
      sb.append(queue.removeLast());
    }

    return rpcalc.evaluate(sb.toString());
  }
}

