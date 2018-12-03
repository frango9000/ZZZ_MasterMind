package MasterMind;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import MasterMind.Gui.*;




public class Ui extends Application {
    public static final int RESX =500;
    public static final int RESY =500;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("MasterMind");
        stage.setScene(MasterMind.Gui.Intro.sceneIntro());
        stage.show();
    }
}
