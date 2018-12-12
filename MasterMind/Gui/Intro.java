package MasterMind.Gui;
import MasterMind.Loc;
import MasterMind.Rules;
import MasterMind.Ui;
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

public class Intro extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Loc.eng();
        Rules.defaultRules();
        primaryStage.setTitle("Mastermind");
        primaryStage.setScene(sceneIntro());
        primaryStage.show();
    }
    public static Scene sceneIntro(){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_CENTER);
        //grid.setGridLinesVisible(true);

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(24, 24, 24, 24));

        Text mastermind = new Text("MasterMind");
        mastermind.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(mastermind, 0, 1, 1, 1);


        Text finish = new Text(Loc.intro);                                       //Game Over
        finish.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(finish, 0, 2);

        Text format = new Text("Hecho por Franisco J Sanchez T\nfrango9000@gmail.com");      //Log
        format.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(format, 0, 3);


        Button quit = new Button(Loc.msg3);
        HBox hbQuit = new HBox(10);
        hbQuit.setAlignment(Pos.BOTTOM_CENTER);
        hbQuit.getChildren().add(quit);
        grid.add(hbQuit, 0, 24);

        quit.setOnAction(actionEvent -> {
            System.out.println("OK");
            Stage stage = (Stage) grid.getScene().getWindow();
            stage.setScene(PickLang.scenePickLang());
        });


        Scene scene = new Scene(grid, Ui.RESX, Ui.RESY);
        return scene;
    }
}