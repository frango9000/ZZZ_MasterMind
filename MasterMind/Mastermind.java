package MasterMind;

public class Mastermind {
    
    public static void main(String[] args) {
        Menu.menuIntro();
        Menu.menuPickRuleset();
        do {
            Game game = new Game();
            game.startGame();
        } while (Menu.menuNewGame());
        System.exit(0);
    }
}
