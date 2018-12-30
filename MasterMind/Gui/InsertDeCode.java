package MasterMind.Gui;
import MasterMind.Loc;
import MasterMind.Rules;
import MasterMind.Ui;
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
        public static Scene sceneInsertDeCode(){ return new Scene(gridInsertDeCode(), Ui.RESX, Ui.RESY);}
        public static GridPane gridInsertDeCode(){

        GridPane grid = Ui.uiGridPane();


        Text log = new Text( "TryLog");                                       //Try Log
        log.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(log, 0, 3);

        Text format = new Text(Loc.code2 + ": " + Rules.getFormatString());            //Format:
        format.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(format, 0, 15);

        TextField userTextField = new TextField();
        grid.add(userTextField, 0, 16);

            Button okButton = new Button(Loc.msg3);
            HBox hbOkButton = Ui.uiButton(10, okButton);
            grid.add(hbOkButton, 1, 16, 2, 1);

            okButton.setOnAction(actionEvent -> {
                System.out.println(Loc.msg3);
                //
            });
        return grid;
    }
}
