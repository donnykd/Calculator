package uk.ac.rhul.cs2800;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * 
 * @author Khalid Mahamed
 * 
 *         Entry point for the javafx framework.
 *
 */
public class Driver extends Application {

  /**
   * @param args command line arguments.
   */
  public static void main(String[] args) {
    launch(args);

  }

  /**
   * The beginning of the javaFX framework and setup.
   * 
   * @param primaryStage The stage used to attach to the scene created.
   *
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Pane pane = FXMLLoader.load(getClass().getResource("GuiView.fxml"));
    Scene scene = new Scene(pane, 500, 200);
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

}
