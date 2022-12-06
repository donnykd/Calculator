import java.util.function.Consumer;

public interface ViewInterface {
  
  public String getExpression();
  public void setAnswer(String str);
  //Influenced by Dave's code to create observer class
  public void addCalcObserver(Observer f);
  public void AddTypeObserver(Consumer <OpType> L);

}
