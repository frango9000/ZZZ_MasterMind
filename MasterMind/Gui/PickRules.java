package MasterMind.Gui;

import MasterMind.Loc;
import MasterMind.Rules;
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

public class PickRules extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Loc.eng();


        primaryStage.setTitle("Mastermind");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(24, 24, 24, 24));

        Text mastertitle = new Text("MasterMind");
        mastertitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(mastertitle, 0, 0, 2, 1);

        Text picklangtitle = new Text(Loc.pick1+":");
        picklangtitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(picklangtitle, 0, 4, 2, 1);

        Text rule1 = new Text(Loc.rule1);
        rule1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        grid.add(rule1, 0, 5, 2, 1);
        Text rule2 = new Text(Loc.rule2);
        rule2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        grid.add(rule2, 0, 6, 2, 1);
        Text rule3= new Text(Loc.rule3);
        rule3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        grid.add(rule3, 0, 7, 2, 1);

        Text defaultrule1 = new Text(String.valueOf(Rules.getMaxTries()));
        defaultrule1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        grid.add(defaultrule1, 2, 5, 2, 1);
        Text defaultrule2 = new Text(String.valueOf(Rules.getCodeLenght()));
        defaultrule2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        grid.add(defaultrule2, 2, 6, 2, 1);
        Text defaultrule3= new Text(String.valueOf(Rules.getCodeValues()));
        defaultrule3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        grid.add(defaultrule3, 2, 7, 2, 1);

        Button btnEng = new Button(Loc.pick2);
        HBox hbBtnEng = new HBox(10);
        hbBtnEng.setAlignment(Pos.BOTTOM_CENTER);
        hbBtnEng.getChildren().add(btnEng);
        grid.add(hbBtnEng, 0, 10);

        btnEng.setOnAction(actionEvent -> System.out.println(Loc.pick2));

        Button btnSpa = new Button(Loc.edit1);
        HBox hbBtnSpa = new HBox(10);
        hbBtnSpa.setAlignment(Pos.BOTTOM_CENTER);
        hbBtnSpa.getChildren().add(btnSpa);
        grid.add(hbBtnSpa, 1, 10);

        btnSpa.setOnAction(actionEvent -> System.out.println(Loc.edit1));



        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setScene(scene);


        primaryStage.show();
    }

}

