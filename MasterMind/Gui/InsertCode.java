package MasterMind.Gui;

import MasterMind.Game;
import MasterMind.Loc;
import MasterMind.Rules;
import MasterMind.Ui;
import MasterMind.Code;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InsertCode extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Loc.eng();
        Rules.defaultRules();
        primaryStage.setTitle("Mastermind");
        primaryStage.setScene(sceneInsertCode());
        primaryStage.show();
    }

    public static Scene sceneInsertCode() {
        return new Scene(gridInsertCode(), Ui.RESX, Ui.RESX);
    }

    public static GridPane gridInsertCode() {
        GridPane grid = Ui.uiGridPane();

        Ui.addText(grid, Loc.code2 + ": " + Rules.getFormatString(), 14, 0, 15);

        TextField introCode = Ui.addTextField(grid, 0, 16);

        Button okButton = Ui.addOkButton(grid, 1,16,2,1);
        okButton.setOnAction(actionEvent -> {
            System.out.println(introCode.getCharacters());

            if(Code.codeCheck(introCode.getCharacters().toString())){
                System.out.println("valid");

                Code code = new Code(introCode.getCharacters().toString());
                Game game = Ui.startGame(code);
                Ui.setScene(InsertDeCode.sceneInsertDeCode(game), grid);
            }

        });
        return grid;
    }
}