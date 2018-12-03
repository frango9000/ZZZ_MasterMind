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

public class InsertDeCode extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Loc.eng();
        Rules.defaultRules();
        primaryStage.setTitle("Mastermind");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_CENTER);
        //grid.setGridLinesVisible(true);

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(24, 24, 24, 24));

        Text mastermind = new Text("MasterMind");
        mastermind.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(mastermind, 0, 1, 1, 1);


        Text log = new Text( "TryLog");                                       //Try Log
        log.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(log, 0, 3);

        Text format = new Text(Loc.code2 + ": " + Rules.getFormatString());            //Format:
        format.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(format, 0, 15);



        TextField userTextField = new TextField();
        grid.add(userTextField, 0, 16);



        Button btnEng = new Button(Loc.msg3);
        HBox hbBtnEng = new HBox(10);
        hbBtnEng.setAlignment(Pos.BOTTOM_CENTER);
        hbBtnEng.getChildren().add(btnEng);
        grid.add(hbBtnEng, 1, 16, 2, 1);

        btnEng.setOnAction(actionEvent -> System.out.println(Loc.msg3));




        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setScene(scene);


        primaryStage.show();

    }
}
