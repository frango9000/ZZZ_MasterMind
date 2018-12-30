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

public class PickRival extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Mastermind");
        primaryStage.setScene(scenePickRival());
        primaryStage.show();
    }

    public static Scene scenePickRival() {
        return new Scene(gridPickRival(), Ui.RESX, Ui.RESY);
    }

    public static GridPane gridPickRival() {

        GridPane grid = Ui.uiGridPane();

        Ui.addText(grid, "Pick Rival: ", 14, 0, 8, 2, 1);

        Button aiButton = Ui.addButton(grid, "AI", 0, 14);
        aiButton.setOnAction(actionEvent -> {
            System.out.println("1 Player");
        });

        Button humanButton = Ui.addButton(grid, "Human", 1, 14);
        humanButton.setOnAction(actionEvent -> {
            System.out.println("2 Player");
            Ui.setScene(InsertCode.sceneInsertCode(), grid);
        });
        return grid;
    }
}