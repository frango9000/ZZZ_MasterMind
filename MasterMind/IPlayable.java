package MasterMind;

public interface IPlayable {
    void intro();
    void pickRuleset();
    void newRules();
    boolean newGame();
    boolean pickRival();
    void pickLang();
    String insertCode();
    String insertDeCode(Game game);
    void gameOver(Game game);
}
