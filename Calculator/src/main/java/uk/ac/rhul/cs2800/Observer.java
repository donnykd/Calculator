// Taken Dave's code in MVC-separated to create observer class
package uk.ac.rhul.cs2800;

/**
 * 
 * @author Khalid Mahamed
 * 
 *         Class made to notify the observer.
 *
 */
@FunctionalInterface
public interface Observer {

  /**
   * Mechanism used to notify the observer.
   */
  public void tell();
}
