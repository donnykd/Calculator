package uk.ac.rhul.cs2800;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * @author Khalid Mahamed
 * 
 *         Calculates expressions as infix. Operators are stored in an Operator Stack while the
 *         numerical values are stored in a queue. Further sent to ReversePolishCalculator to do all
 *         calculations.
 *
 */
public class StandardCalc {

  // Operator Stack
  private OpStack value = new OpStack();
  private RevPolishCalc rpcalc = new RevPolishCalc();

  // Array queue with both sides accessible, used for storing numerical values and operators with
  // less priority in the operator stack
  private ArrayDeque<String> queue = new ArrayDeque<String>();

  /**
   * Computes the expression and returns the answer as float.
   * 
   * 
   * @param expression, mathematical expression that the user inputed to be solved as a string.
   * @return answer to the expression in float.
   * @throws Exception, thrown when invalid format or invalid expression.
   */
  public float evaluate(String expression) throws Exception {

    try (Scanner sc = new Scanner(expression)) {
      String next;

      while (sc.hasNext()) {
        next = sc.next();

        switch (next) {

          case "+":
            if (!(value.isEmpty())) {
              // Checks to see if there is a higher priority operator inside the operator stack
              if (value.top().equals(Symbol.TIMES) || value.top().equals(Symbol.DIVIDE))

                // Space is added to meet a standard requirement to calculate the expression.
                queue.push(value.pop().toString() + " ");
            }
            value.push(Symbol.PLUS);
            break;

          case "-":
            if (!(value.isEmpty())) {
              // Checks to see if there is a higher priority operator inside the operator stack
              if (value.top().equals(Symbol.TIMES) || value.top().equals(Symbol.DIVIDE))

                // Space is added to meet a standard requirement to calculate the expression.
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

              // Space is added to meet a standard requirement to calculate the expression.
              queue.push(value.pop().toString() + " ");
            break;

          default:

            // Space is added to meet a standard requirement to calculate the expression.
            queue.push(next + " ");
        }
      }
      // removes all the operators top to bottom in order needed for RevPolishCalculator
      while (!(value.isEmpty()))

        // Space is added to meet a standard requirement to calculate the expression.
        queue.push(value.pop().toString() + " ");
    }
    // Used to create the string that is parsed into the ReversePolishCalculator
    StringBuilder sb = new StringBuilder();

    // Builds the expression needed for RevPolishCalculator, by emptying the queue and making it all
    // a string.
    while (!(queue.isEmpty()))
      sb.append(queue.removeLast());

    return rpcalc.evaluate(sb.toString());
  }
}

