package MasterMind;

public class Mastermind {

    public static void main(String[] args) {
        if ("c".equalsIgnoreCase(args[0])) {
            Console.pickLang();
            Console.intro();
            Console.pickRuleset();
            do {
                Game game = new Game(0);
                game.startGame();
            } while (Console.newGame());
            System.exit(0);
        } else if ("m".equalsIgnoreCase(args[0])){
            Menu.pickLang();
            Menu.intro();
            Menu.pickRuleset();
            do {
                Game game = new Game(1);
                game.startGame();
            } while (Menu.newGame());
        } else{
            System.exit(0);
        }
    }
}
