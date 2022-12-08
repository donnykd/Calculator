package uk.ac.rhul.cs2800;

/**
 * 
 * 
 * @author Khalid Mahamed
 * 
 *         Way in which Calculator chooses which arithmetic method to choose.
 *
 */
public enum OpType {
  /**
   * Standard Calculator i.e. ( 2 + 2 )
   */
  INFIX,
  /**
   * Reverse Polish i.e. ( 2 2 + )
   */
  POSTFIX
}
