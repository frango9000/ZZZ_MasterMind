package MasterMind.Gui;

import MasterMind.Loc;
import MasterMind.Rules;
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

public class Intro extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Loc.eng();
        primaryStage.setTitle("Mastermind");
        primaryStage.setScene(sceneIntro());
        primaryStage.show();
    }

    public static Scene sceneIntro() {
        return new Scene(gridIntro(), Ui.RESX, Ui.RESY);
    }

    public static GridPane gridIntro() {
        GridPane grid = Ui.uiGridPane();

        Text finish = new Text(Loc.intro);                                       //Game Over
        finish.setFont(Font.font("Tahoma", FontWeight.NORMAL, 8));
        grid.add(finish, 0, 2);

//        Text format = new Text("Hecho por Franisco J Sanchez T\nfrango9000@gmail.com");      //Log
//        format.setFont(Font.font("Tahoma", FontWeight.NORMAL, 5));
//        grid.add(format, 0, 3);


        Button okButton = new Button("OK");
        HBox hbOkButton = Ui.uiButton(10, okButton);
        grid.add(hbOkButton, 0, 14);

        okButton.setOnAction(actionEvent -> {
            Rules.defaultRules();
            Stage stage = (Stage) grid.getScene().getWindow();
            stage.setScene(PickRules.scenePickRules());
        });
        return grid;
    }
}