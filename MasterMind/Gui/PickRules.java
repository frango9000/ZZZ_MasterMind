package MasterMind.Gui;

import MasterMind.Loc;
import MasterMind.Rules;
import MasterMind.Ui;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PickRules extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Loc.eng();
        //Rules.defaultRules();
        primaryStage.setTitle("Mastermind");
        primaryStage.setScene(scenePickRules());
        primaryStage.show();
    }

    public static Scene scenePickRules() {
        return new Scene(gridPickRules(), Ui.RESX, Ui.RESY);
    }

    public static GridPane gridPickRules() {
        GridPane grid = Ui.uiGridPane();

        Ui.addText(grid, Loc.pick1 + ":", 14,0, 1, 2, 1);

        Ui.addText(grid, Loc.rule1 + ":", 12,0, 5, 2, 1);
        Ui.addText(grid, Loc.rule2 + ":", 12,0, 6, 2, 1);
        Ui.addText(grid, Loc.rule3 + ":", 12,0, 7, 2, 1);

        Ui.addText(grid, String.valueOf(Rules.getMaxTries()), 12,2, 5, 2, 1, HPos.RIGHT);
        Ui.addText(grid, String.valueOf(Rules.getCodeLength()), 12,2, 6, 2, 1, HPos.RIGHT);
        Ui.addText(grid, String.valueOf(Rules.getCodeValues()), 12,2, 7, 2, 1, HPos.RIGHT);

        Button editButton = Ui.addButton(grid, Loc.edit1, 0, 14);//Edit
        editButton.setOnAction(actionEvent -> {
            System.out.println(Loc.edit1);
            Stage stage = (Stage) grid.getScene().getWindow();
            stage.setScene(EditRules.sceneEditRules());
        });

        Button okButton = Ui.addButton(grid, Loc.msg3, 3, 14);//Accept
        okButton.setOnAction(actionEvent -> {
            System.out.println(Loc.pick2);
            Stage stage = (Stage) grid.getScene().getWindow();
            stage.setScene(PickRival.scenePickRival());
        });

        return grid;
    }

}

