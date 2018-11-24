package UI;
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

public class GameOver extends Application {

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



        Text finish = new Text( "Game Over");                                       //Game Over
        finish.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(finish, 0, 2);

        Text format = new Text("hola");                                                             //Log
        format.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(format, 0, 3);



        Button accept = new Button(Loc.newgame1);
        HBox hbAccept = new HBox(10);
        hbAccept.setAlignment(Pos.BOTTOM_CENTER);
        hbAccept.getChildren().add(accept);
        grid.add(hbAccept, 0, 16, 2, 1);

        accept.setOnAction(actionEvent -> System.out.println(Loc.newgame1));

        Button quit = new Button(Loc.newgame2);
        HBox hbQuit = new HBox(10);
        hbQuit.setAlignment(Pos.BOTTOM_CENTER);
        hbQuit.getChildren().add(quit);
        grid.add(hbQuit, 1, 16, 2, 1);

        quit.setOnAction(actionEvent -> System.out.println(Loc.newgame2));


        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setScene(scene);


        primaryStage.show();

    }
}
