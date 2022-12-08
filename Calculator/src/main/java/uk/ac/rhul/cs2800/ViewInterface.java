package uk.ac.rhul.cs2800;

import java.util.function.Consumer;

/**
 * 
 * @author Khalid Mahamed
 * 
 *         Interface class created to define methods for the GuiView. The way we interact with our
 *         calculator.
 *
 */
public interface ViewInterface {

  /**
   * Method to get the expression as a string.
   * 
   * @return string of the expression.
   */
  public String getExpression();

  /**
   * Method to be able to set the answer.
   * 
   * @param str answer to be set.
   */
  public void setAnswer(String str);

  // Taken Dave's code in MVC-separated to create observer class
  /**
   * Observes a change between infix and revpolish
   * 
   * @param f will be observing.
   */
  public void addCalcObserver(Observer f);

  /**
   * observes the action to be made when calculating.
   * 
   * @param L will be observing.
   */
  public void AddTypeObserver(Consumer<OpType> L);

}
