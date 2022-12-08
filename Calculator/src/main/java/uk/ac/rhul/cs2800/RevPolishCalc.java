package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * @author Khalid Mahamed
 * 
 *         Calculates expressions as ReversePolish. Expression is read, numbers are then stored in a
 *         number stack while operators pop the numbers out and calculate them using the operator
 *         read. Stored back into the number stack.
 *
 */
public class RevPolishCalc {

  private NumStack value = new NumStack();

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

      try {
        while (sc.hasNext()) {
          next = sc.next();

          if (Character.isDigit(next.charAt(0))) {
            value.push(Float.parseFloat(next));
          }

          else if (next.equals(Symbol.PLUS.toString()))
            value.push(value.pop() + value.pop());

          else if (next.equals(Symbol.MINUS.toString()))

            // By setting the first popped value as negative and adding it to the second value, I am
            // essentially subtracting the second value from the first.
            value.push(-value.pop() + value.pop());

          else if (next.equals(Symbol.TIMES.toString()))
            value.push(value.pop() * value.pop());

          // By Dividing the first popped value by 1 and multiplying it to the second value, I am
          // essentially dividing the second value from the first.
          else if (next.equals(Symbol.DIVIDE.toString()))
            value.push(1 / value.pop() * value.pop());
        }
      } catch (EmptyStackException e) {
        // Specified this exception for an expression that failed the upper try bracket. Mostly
        // stack couldn't have popped twice.
        throw new Exception("Invalid Format");
      }
    }
    if (value.size() > 1)
      // Specified this exception for when there is more than a single value in the stack, this was
      // probably caused by an error of values and can't be computed.
      throw new Exception("Invalid Expression");
    if (value.size() == 1)
      return value.pop();
    return 0;
  }

}
