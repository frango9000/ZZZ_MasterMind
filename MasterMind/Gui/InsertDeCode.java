package MasterMind.Gui;

import MasterMind.*;
import javafx.application.Application;
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

public class InsertDeCode extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Loc.eng();
        Rules.defaultRules();
        primaryStage.setTitle("Mastermind");
        primaryStage.setScene(sceneInsertDeCode());
        primaryStage.show();
    }

    public static Scene sceneInsertDeCode() {
        return new Scene(gridInsertDeCode(), Ui.RESX, Ui.RESY);
    }

    public static Scene sceneInsertDeCode(Game game) {
        return new Scene(gridInsertDeCode(game), Ui.RESX, Ui.RESY);
    }

    public static GridPane gridInsertDeCode() {

        GridPane grid = Ui.uiGridPane();

        Ui.addText(grid, "TryLog", 14, 0, 3);

        Ui.addText(grid, Loc.code2 + ": " + Rules.getFormatString(), 14, 0, 15);

        TextField introDeCode = Ui.addTextField(grid, 0, 16);

        Button okButton = Ui.addOkButton(grid, 1, 16, 2, 1);
        okButton.setOnAction(actionEvent -> {
            System.out.println(Loc.msg3);
            //
        });
        return grid;
    }

    public static GridPane gridInsertDeCode(Game game) {

        GridPane grid = gridInsertDeCode();

        TextField introDeCode = Ui.addTextField(grid, 0, 16);

        Button okButton = Ui.addOkButton(grid, 1, 16, 2, 1);
        okButton.setOnAction(actionEvent -> {
            System.out.println(Loc.msg3);
            //
            if (Code.codeCheck(introDeCode.getCharacters().toString())) {
                System.out.println("valid");

                Code deCode = new Code(introDeCode.getCharacters().toString(), game.getCode());

                game.incTries();
                game.setDecodes(deCode, game.getTries());
                game.updateLog(game.getTries() + "/" + Rules.getMaxTries() + " " + deCode.getCode() + " " + deCode.getPerfMatches() + " " + deCode.getSemiMatches() + "\n");
                if (deCode.getPerfMatches() >= Rules.getCodeLength()) {
                    Ui.setScene(GameOver.sceneGameOver(), grid);
                }
            }
        });
        return grid;
    }
}
