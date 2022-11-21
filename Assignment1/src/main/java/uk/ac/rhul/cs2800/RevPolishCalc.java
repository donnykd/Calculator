package uk.ac.rhul.cs2800;

import java.util.Scanner;

public class RevPolishCalc {
  private NumStack value = new NumStack();

  public float evaluate(String expression) {
    Scanner sc = new Scanner(expression);
    String next;
    float answer = 0;

    while (sc.hasNext()) {
      next = sc.next();

      if (Character.isDigit(next.charAt(0))) {
        value.push(Float.parseFloat(next));
      }
    }
    while (!(value.isEmpty()))
      answer = answer + value.pop();

    return answer;
  }
}
