package MasterMind.Gui;

import MasterMind.Loc;
import MasterMind.Rules;
import MasterMind.Ui;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EditRules extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Loc.eng();

        primaryStage.setTitle("Mastermind");
        primaryStage.setScene(sceneEditRules());
        primaryStage.show();
    }

    public static Scene sceneEditRules() {
        return new Scene(gridEditRules(), Ui.RESX, Ui.RESY);
    }

    public static GridPane gridEditRules() {
        GridPane grid = Ui.uiGridPane();

        Text editRuleSet = new Text(Loc.edit1 + ":");
        editRuleSet.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(editRuleSet, 0, 4, 2, 1);

        Text rule1 = new Text(Loc.rule1);
        rule1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        grid.add(rule1, 0, 5);

        Text rule2 = new Text(Loc.rule2);
        rule2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        grid.add(rule2, 0, 6);

        Text rule3 = new Text(Loc.rule3);
        rule3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        grid.add(rule3, 0, 7);


        TextField setRuleField1 = new TextField();
        setRuleField1.appendText(String.valueOf(Rules.getMaxTries()));
        grid.add(setRuleField1, 1, 5);

        TextField setRuleField2 = new TextField();
        setRuleField2.appendText(String.valueOf(Rules.getCodeValues()));
        grid.add(setRuleField2, 1, 6);

        TextField setRuleField3 = new TextField();
        setRuleField3.appendText(String.valueOf(Rules.getCodeLength()));
        grid.add(setRuleField3, 1, 7);


        Button buttonEditRules = new Button(Loc.msg3);
        HBox hbButtonEditRules = Ui.uiButton(10, buttonEditRules);
        grid.add(hbButtonEditRules, 1, 11, 2, 1);

        buttonEditRules.setOnAction(actionEvent -> {
            System.out.println("OK");
            if (Ui.isInteger(setRuleField1.getCharacters().toString()) && Ui.isInteger(setRuleField2.getCharacters().toString()) && Ui.isInteger(setRuleField3.getCharacters().toString())) {
                int r1 = Integer.parseInt(setRuleField1.getCharacters().toString());
                int r2 = Integer.parseInt(setRuleField2.getCharacters().toString());
                int r3 = Integer.parseInt(setRuleField3.getCharacters().toString());
                if (r2 > 0 && r2 <= Rules.getMaxLength() && r3 > 0 && r3 <= Rules.getMaxValues() && r1 > 0 && r1 <= 99) {
                    Rules.editRules(r2, r3, r1);
                    Stage stage = (Stage) grid.getScene().getWindow();
                    stage.setScene(PickRules.scenePickRules());
                }

            }//else NFE alert

        });

        return grid;
    }
}

