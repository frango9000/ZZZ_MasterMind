package MasterMind.Gui;

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

public class PickLang extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MasterMind");
        primaryStage.setScene(scenePickLang());
        primaryStage.show();
    }

    public static Scene scenePickLang(){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(24, 24, 24, 24));

        Button btnEng = new Button("English");
        HBox hbBtnEng = new HBox(10);
        hbBtnEng.setAlignment(Pos.BOTTOM_CENTER);
        hbBtnEng.getChildren().add(btnEng);
        grid.add(hbBtnEng, 0, 10);

        btnEng.setOnAction(actionEvent -> System.out.println("English"));

        Button btnSpa = new Button("Español");
        HBox hbBtnSpa = new HBox(10);
        hbBtnSpa.setAlignment(Pos.BOTTOM_CENTER);
        hbBtnSpa.getChildren().add(btnSpa);
        grid.add(hbBtnSpa, 1, 10);

        btnSpa.setOnAction(actionEvent -> System.out.println("Español"));


        Text scenetitle = new Text("MasterMind");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);


        return new Scene(grid, Ui.RESX, Ui.RESY);
    }

}

