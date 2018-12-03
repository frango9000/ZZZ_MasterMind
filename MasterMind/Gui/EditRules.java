package MasterMind.Gui;

import MasterMind.Loc;
import MasterMind.Rules;
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

public class EditRules extends Application {

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

        Text picklangtitle = new Text(Loc.pick1 + ":");
        picklangtitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(picklangtitle, 0, 4, 2, 1);


        Text rule1 = new Text(Loc.rule1);
        rule1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        grid.add(rule1, 0, 5);

        Text rule2 = new Text(Loc.rule2);
        rule2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        grid.add(rule2, 0, 6);

        Text rule3 = new Text(Loc.rule3);
        rule3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        grid.add(rule3, 0, 7);


        TextField userTextField = new TextField();
        userTextField.appendText(String.valueOf(Rules.getMaxTries()));
        grid.add(userTextField, 1, 5);

        TextField setRuleField3 = new TextField();
        setRuleField3.appendText(String.valueOf(Rules.getCodeValues()));
        grid.add(setRuleField3, 1, 6);

        TextField setRuleField2 = new TextField();
        setRuleField2.appendText(String.valueOf(Rules.getCodeValues()));
        grid.add(setRuleField2, 1, 7);



        Button btnEng = new Button(Loc.msg3);
        HBox hbBtnEng = new HBox(10);
        hbBtnEng.setAlignment(Pos.BOTTOM_CENTER);
        hbBtnEng.getChildren().add(btnEng);
        grid.add(hbBtnEng, 1, 10, 2, 1);

        btnEng.setOnAction(actionEvent -> System.out.println(Loc.msg3));




        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setScene(scene);


        primaryStage.show();

    }
}

