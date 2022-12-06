import java.util.function.Consumer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class GuiView implements ViewInterface {
  private String expression = "";
  
  @FXML
  private Label answer;
  
  @FXML
  private Button calculateButton;

  @FXML
  private TextField field;

  @FXML
  private RadioButton infix;

  @FXML
  private Pane mainPane;

  @FXML
  private RadioButton reversePolish;

  @FXML
  private ToggleGroup type;

  @FXML
  void isValid(KeyEvent event) {
    char current = event.getCharacter().charAt(0);


    if ((Character.isDigit(current)) || current == ('.') || current == ('(') || current == (')')
        || current == ('+') || current == ('-') || current == ('/') || current == ('*')
        || current == (32)) {
      expression = expression + Character.toString(current);
    } else if (current == ('\b')) {
      if (expression.length() != 0)
        expression = expression.substring(0, expression.length() - 1);
    }
    field.setText(expression);
    field.positionCaret(field.getCaretPosition() + 2000);
  }

  @Override
  public String getExpression() {
    return this.expression;
  }

  @Override
  public void setAnswer(String str) {
    answer.setText(str);
  }

  @Override
  public void addCalcObserver(final Observer f) {
    calculateButton.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        f.tell();
      }
    });
  }

  @Override
  public void AddTypeObserver(final Consumer<OpType> L) {
    type.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      @Override
      public void changed(ObservableValue<? extends Toggle> observable, Toggle from, Toggle to) {
        L.accept(to == infix ? OpType.INFIX : OpType.POSTFIX);
      }
    });
  }

}
