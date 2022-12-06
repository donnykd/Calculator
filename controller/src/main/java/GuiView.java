import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class GuiView {
  private String expression = "";

  @FXML
  private Button calculateButton;

  @FXML
  private TextField field;

  @FXML
  private Pane mainPane;

  @FXML
  private RadioButton reversePolish;

  @FXML
  void isValid(KeyEvent event) {
    char current = event.getCharacter().charAt(0);


    if ((Character.isDigit(current)) || current == ('.') || current == ('(') || current == (')')
        || current == ('+') || current == ('-') || current == ('/') || current == ('*') || current == (32)) {
      expression = expression + Character.toString(current);
    }
    else if (current == ('\b')) {
      if (expression.length() != 0)
        expression = expression.substring(0, expression.length() - 1);
    }
    field.setText(expression);
    field.positionCaret(field.getCaretPosition() + 2000);
  }

}
