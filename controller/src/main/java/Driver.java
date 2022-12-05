import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Driver extends Application{

  public static void main(String[] args) {
    launch(args);

  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Pane pane = FXMLLoader.load(getClass().getResource("GuiView.fxml"));
    Scene scene = new Scene(pane, 500, 200);
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

}
