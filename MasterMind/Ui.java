package MasterMind;

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

import MasterMind.Gui.*;




public class Ui extends Application {
    public static final int RESX =500;
    public static final int RESY =500;
    public Stage stage;

    public Ui() {
        this.stage = new Stage();
    }

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("MasterMind");
        stage.setScene(MasterMind.Gui.Intro.sceneIntro());
        stage.show();
    }
    public void setScene(Stage stage, Scene scene){

        stage.setScene(scene);
    }

    public void uiPickLang(Stage stage) {
        stage.setScene(MasterMind.Gui.PickLang.scenePickLang());
        stage.show();
    }
    public void uiPickLang(int i){
        switch(i){
            case 0:
                Loc.eng();
                break;
            case 1:
                Loc.esp();
                break;
            default:
                Loc.eng();
                break;
        }
    }
    public void uiIntro(Stage stage){

        stage.setScene(MasterMind.Gui.Intro.sceneIntro());
        stage.show();
    }
    public static void uiPickRules(int i){
        switch(i){
            case 0:
                Rules.defaultRules();//nominative
                break;
            case 1:
                //EditRules ui
                break;
        }
    }
}
