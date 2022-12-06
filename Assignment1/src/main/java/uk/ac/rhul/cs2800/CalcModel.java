package uk.ac.rhul.cs2800;

public class CalcModel {
  StandardCalc sc;
  RevPolishCalc rp;

  public float evaluate(String expression, boolean infix) throws Exception {
    if(infix) {
      sc = new StandardCalc();
      return sc.evaluate(expression);
    }
    else {
      rp = new RevPolishCalc();
      return rp.evaluate(expression);
    }
  }

}
