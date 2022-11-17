import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class GuiView {
  private String expression;
  private String answer;

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

}
