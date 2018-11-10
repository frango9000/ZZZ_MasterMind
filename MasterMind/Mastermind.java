package MasterMind;

public class Mastermind {

    public static void main(String[] args) {
        Rules.defaultRules();
        Game game = new Game();
        game.startGame();

    }
}
