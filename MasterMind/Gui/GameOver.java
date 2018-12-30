package MasterMind.Gui;

import MasterMind.Game;
import MasterMind.Loc;
import MasterMind.Rules;
import MasterMind.Ui;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameOver extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Loc.eng();
        Rules.defaultRules();
        primaryStage.setTitle("Mastermind");
        primaryStage.setScene(sceneGameOver());
        primaryStage.show();
    }

    public static Scene sceneGameOver() {        return new Scene(gridGameOver(), Ui.RESX, Ui.RESY);    }

    public static GridPane gridGameOver() {

        GridPane grid = Ui.uiGridPane();

        Ui.addText(grid, "Game Over", 14, 0, 2);

        Ui.addText(grid, "TryLog", 14, 0, 3);

        Button accept = Ui.addButton(grid, Loc.newgame1, 0, 16, 2, 1);
        accept.setOnAction(actionEvent -> {
            System.out.println(Loc.newgame1);
        });

        Button quit = Ui.addButton(grid, Loc.newgame2, 1, 16, 2, 1);
        quit.setOnAction(actionEvent -> {
            System.out.println(Loc.newgame2);
        });
        return grid;
    }
    public static GridPane gridGameOver(Game game) {

        GridPane grid = Ui.uiGridPane();

        Ui.addText(grid, "Game Over", 14, 0, 2);

        Ui.addText(grid, "TryLog", 14, 0, 3);

        Button accept = Ui.addButton(grid, Loc.newgame1, 0, 16, 2, 1);
        accept.setOnAction(actionEvent -> {
            System.out.println(Loc.newgame1);
        });

        Button quit = Ui.addButton(grid, Loc.newgame2, 1, 16, 2, 1);
        quit.setOnAction(actionEvent -> {
            System.out.println(Loc.newgame2);
        });
        return grid;
    }
}
