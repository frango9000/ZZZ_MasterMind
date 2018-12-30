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

        Text pickRuleSet = new Text(Loc.pick1 + ":");
        pickRuleSet.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(pickRuleSet, 0, 4, 2, 1);

        Text rule1 = new Text(Loc.rule1);
        rule1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        grid.add(rule1, 0, 5, 2, 1);
        Text rule2 = new Text(Loc.rule2);
        rule2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        grid.add(rule2, 0, 6, 2, 1);
        Text rule3 = new Text(Loc.rule3);
        rule3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        grid.add(rule3, 0, 7, 2, 1);

        Text defaultRule1 = new Text(String.valueOf(Rules.getMaxTries()));
        defaultRule1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        grid.add(defaultRule1, 2, 5, 2, 1);
        GridPane.setHalignment(defaultRule1, HPos.RIGHT);
        Text defaultRule2 = new Text(String.valueOf(Rules.getCodeLength()));
        defaultRule2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        grid.add(defaultRule2, 2, 6, 2, 1);
        GridPane.setHalignment(defaultRule2, HPos.RIGHT);
        Text defaultRule3 = new Text(String.valueOf(Rules.getCodeValues()));
        defaultRule3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        grid.add(defaultRule3, 2, 7, 2, 1);
        GridPane.setHalignment(defaultRule3, HPos.RIGHT);

        Button editButton = new Button(Loc.edit1);//Edit
        HBox hbEditButton = Ui.uiButton(10, editButton);
        grid.add(hbEditButton, 0, 14);

        editButton.setOnAction(actionEvent -> {
            System.out.println(Loc.edit1);
            Stage stage = (Stage) grid.getScene().getWindow();
            stage.setScene(EditRules.sceneEditRules());
        });

        Button okButton = new Button(Loc.msg3);//Accept
        HBox hbOkButton = Ui.uiButton(10, okButton);
        grid.add(hbOkButton, 3, 14);

        okButton.setOnAction(actionEvent -> {
            System.out.println(Loc.pick2);
            Stage stage = (Stage) grid.getScene().getWindow();
            stage.setScene(PickRival.scenePickRival());
        });

        return grid;
    }

}

