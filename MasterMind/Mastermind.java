package MasterMind;

public class Mastermind {

    public static void main(String[] args) {
        if (args.length >= 1 && args[0].equalsIgnoreCase("c")) {
            Console.consolePickLang();
            Console.consoleIntro();
            Console.consolePickRuleset();
            do {
                Game game = new Game(0);
                game.startGame();
            } while (Console.consoleNewGame());
            System.exit(0);
        } else {
            Menu.menuPickLang();
            Menu.menuIntro();
            Menu.menuPickRuleset();
            do {
                Game game = new Game(1);
                game.startGame();
            } while (Menu.menuNewGame());
            System.exit(0);
        }
    }
}
