package uk.ac.rhul.cs2800;

import java.util.ArrayDeque;
import java.util.Scanner;

public class StandardCalc {
  private OpStack value = new OpStack();
  private RevPolishCalc rpcalc = new RevPolishCalc();
  private ArrayDeque<String> queue = new ArrayDeque<String>();

  public float evaluate(String expression) throws Exception {
    
    try (Scanner sc = new Scanner(expression)) {
      String next;

      while (sc.hasNext()) {
        next = sc.next();

        switch (next) {
          
          case "+":
            if (!(value.isEmpty())) {
              if (value.top().equals(Symbol.TIMES) || value.top().equals(Symbol.DIVIDE))
                queue.push(value.pop().toString() + " ");
            }
            value.push(Symbol.PLUS);
            break;

          case "-":
            if (!(value.isEmpty())) {
              if (value.top().equals(Symbol.TIMES) || value.top().equals(Symbol.DIVIDE))
                queue.push(value.pop().toString() + " ");
            }
            value.push(Symbol.MINUS);
            break;

          case "/":
            value.push(Symbol.DIVIDE);
            break;

          case "*":
            value.push(Symbol.TIMES);
            break;

          case "(":
            value.push(Symbol.LEFT_BRACKET);
            break;

          case ")":
            while (!(value.top().equals(Symbol.LEFT_BRACKET)))
              queue.push(value.pop().toString() + " ");
            break;
            
          default:
            queue.push(next + " ");
        }
      }
      while (!(value.isEmpty()))
        queue.push(value.pop().toString() + " ");
    }
    
    StringBuilder sb = new StringBuilder();
    
    while (!(queue.isEmpty())) 
      sb.append(queue.removeLast());

    return rpcalc.evaluate(sb.toString());
  }
}

