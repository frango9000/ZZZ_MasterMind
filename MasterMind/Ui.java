package MasterMind;

import MasterMind.Gui.PickRules;
import javafx.application.Application;
import javafx.geometry.HPos;
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


public class Ui extends Application {
    public static final int RESX = 300;
    public static final int RESY = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("MasterMind");
        stage.setScene(MasterMind.Gui.PickLang.scenePickLang());
        stage.show();
    }

    public static GridPane uiGridPane() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(24, 24, 24, 24));

        Text mastertitle = new Text("MasterMind");
        mastertitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(mastertitle, 0, 0, 2, 1);
        GridPane.setHalignment(mastertitle, HPos.CENTER);

        grid.setGridLinesVisible(true);

        return grid;
    }

    public static HBox uiButton(int space, Button button) {
        HBox hbButton = new HBox(space);
        hbButton.setAlignment(Pos.BOTTOM_CENTER);
        hbButton.getChildren().add(button);
        return hbButton;
    }


    public static Button addOkButton(GridPane grid, int columnIndex, int rowIndex, int colSpan, int rowSpan){
        Button okButton = new Button(Loc.msg3);
        HBox hbOkButton = Ui.uiButton(10, okButton);
        grid.add(hbOkButton, columnIndex, rowIndex, colSpan, rowSpan);
        return okButton;
    }
    public static Button addButton(GridPane grid,String msg, int columnIndex, int rowIndex, int colSpan, int rowSpan){
        Button okButton = new Button(msg);
        HBox hbOkButton = Ui.uiButton(10, okButton);
        grid.add(hbOkButton, columnIndex, rowIndex, colSpan, rowSpan);
        return okButton;
    }
    public static Button addButton(GridPane grid,String msg, int columnIndex, int rowIndex){
        Button okButton = new Button(msg);
        HBox hbOkButton = Ui.uiButton(10, okButton);
        grid.add(hbOkButton, columnIndex, rowIndex);
        return okButton;
    }
    public static TextField addTextField(GridPane grid, int columnIndex, int rowIndex){
        TextField userTextField = new TextField();
        grid.add(userTextField, columnIndex, rowIndex);
        return userTextField;
    }
    public static TextField addTextField(GridPane grid, String msg, int columnIndex, int rowIndex){
        TextField userTextField = new TextField();
        grid.add(userTextField, columnIndex, rowIndex);
        return userTextField;
    }

    public static void addText(GridPane grid, String msg, int size, int columnIndex, int rowIndex){
        Text text = new Text(msg);
        text.setFont(Font.font("Tahoma", FontWeight.NORMAL, size));
        grid.add(text, columnIndex, rowIndex);
    }
    public static void addText(GridPane grid, String msg, int size, int columnIndex, int rowIndex, int colSpan, int rowSpan){
        Text text = new Text(msg);
        text.setFont(Font.font("Tahoma", FontWeight.NORMAL, size));
        grid.add(text, columnIndex, rowIndex, colSpan, rowSpan);
    }
    public static void addText(GridPane grid, String msg, int size, int columnIndex, int rowIndex, int colSpan, int rowSpan, HPos pos){
        Text text = new Text(msg);
        text.setFont(Font.font("Tahoma", FontWeight.NORMAL, size));
        grid.add(text, columnIndex, rowIndex, colSpan, rowSpan);
        GridPane.setHalignment(text, pos);
    }


    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Game startGame(Code code) {
        return new Game(code);
    }

    public static void setGameScene(Game game, Scene scene){


    }

    public static void setScene(Scene scene, GridPane ParentGrid){
        Stage stage = (Stage) ParentGrid.getScene().getWindow();
        stage.setScene(scene);
    }
}