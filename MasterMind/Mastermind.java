package MasterMind;

import javafx.stage.Stage;

public class Mastermind {

    public static void main(String[] args) {
        if ("c".equalsIgnoreCase(args[0])) {
            Console.consolePickLang();
            Console.consoleIntro();
            Console.consolePickRuleset();
            do {
                Game game = new Game(0);
                game.startGame();
            } while (Console.consoleNewGame());
            System.exit(0);
            //} else if ("m".equalsIgnoreCase(args[0]))) {
        }else{
            Menu.menuPickLang();
            Menu.menuIntro();
            Menu.menuPickRuleset();
            do {
                Game game = new Game(1);
                game.startGame();
            } while (Menu.menuNewGame());
            System.exit(0);
        //} else {//UI
        }
    }
}
