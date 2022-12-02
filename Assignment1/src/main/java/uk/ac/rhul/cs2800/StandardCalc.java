package uk.ac.rhul.cs2800;

import java.util.Scanner;

public class StandardCalc {
  private NumStack value = new NumStack();
  private OpStack operands = new OpStack();

  public float evaluate(String expression) {
    try (Scanner sc = new Scanner(expression)) {
      String next;
      while (sc.hasNext()) {
        next = sc.next();
        if (Character.isDigit(next.charAt(0)))
          value.push(Float.parseFloat(next));
        else if (next.equals(Symbol.PLUS.toString()))
          operands.push(Symbol.PLUS);
        else if (next.equals(Symbol.MINUS.toString()))
          operands.push(Symbol.MINUS);
        else if (next.equals(Symbol.TIMES.toString()))
          operands.push(Symbol.TIMES);
        else if (next.equals(Symbol.DIVIDE.toString()))
          operands.push(Symbol.DIVIDE);
      }
    }
    if (value.size() > 1 && operands.size() > 0) {
      while (operands.size() != 0) {
        Symbol operand = operands.pop();
        if (operand.toString().equals("+"))
          value.push(value.pop() + value.pop());
        else if (operand.toString().equals("-"))
          value.push(-value.pop() + value.pop());
        else if (operand.toString().equals("*"))
          value.push(value.pop() * value.pop());
        else if (operand.toString().equals("/"))
          value.push(1 / value.pop() * value.pop());
      }
      return value.pop();
    } else if (value.size() == 1)
      return value.pop();
    else
      return 0;
  }
}
