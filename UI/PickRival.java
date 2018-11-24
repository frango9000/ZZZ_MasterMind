package UI;

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

public class PickRival extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Mastermind");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(24, 24, 24, 24));

        Text mastertitle = new Text("MasterMind");
        mastertitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(mastertitle, 0, 0, 2, 1);

        Text picklangtitle = new Text("Pick Rival: ");
        picklangtitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(picklangtitle, 0, 8, 2, 1);



        Button btnEng = new Button("AI");
        HBox hbBtnEng = new HBox(10);
        hbBtnEng.setAlignment(Pos.BOTTOM_CENTER);
        hbBtnEng.getChildren().add(btnEng);
        grid.add(hbBtnEng, 0, 10);

        btnEng.setOnAction(actionEvent -> System.out.println("1 Player"));

        Button btnSpa = new Button("2 Player");
        HBox hbBtnSpa = new HBox(10);
        hbBtnSpa.setAlignment(Pos.BOTTOM_CENTER);
        hbBtnSpa.getChildren().add(btnSpa);
        grid.add(hbBtnSpa, 1, 10);

        btnSpa.setOnAction(actionEvent -> System.out.println("2 Player"));



        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setScene(scene);


        primaryStage.show();
    }

}

