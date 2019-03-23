package MasterMind.Gui;

import MasterMind.Loc;
import MasterMind.Ui;
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

public class PickLang extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MasterMind");
        primaryStage.setScene(scenePickLang());
        primaryStage.show();
    }

    public static Scene scenePickLang() {
        return new Scene(gridPickLang(), Ui.RESX, Ui.RESY);
    }

    public static GridPane gridPickLang() {


        return null;
    }
}