package MasterMind;

import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author fsancheztemprano
 */
public class Game {

    private int tries;
    private String tryLog;
    private Code code;
    private Code[] decodes;

    public Game() {
        tries = 0;
        tryLog = "";
        decodes = new Code[Rules.getMaxTries() + 1];
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public void incTries() {
        tries++;
    }

    public void updateLog(String str) {
        tryLog += str;
    }

    public String getTryLog() {
        return tryLog;
    }

    public void setTryLog(String tryLog) {
        this.tryLog = tryLog;
    }

    public void startGame() {
        if (Menu.pickRival()) {
            code = new Code(insertCode());
        } else {
            code = new Code();
        }

        do {
            Code deCode = new Code(insertDeCode(), code);
            incTries();
            decodes[tries] = deCode;
            updateLog(getTries() + "/" + Rules.getMaxTries() + " " + deCode.getCode() + " " + deCode.getPerfMatches() + " " + deCode.getSemiMatches() + "\n");
            if (deCode.getPerfMatches() >= Rules.getCodeLenght()) {
                break;
            }
        } while (tries < Rules.getMaxTries());

        gameOver(decodes[tries]);
    }

    public boolean codeCheck(String cod) {
        int codeCheck = 0;
        char[] ar = Rules.getOptionsArray();
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < cod.length(); j++) {
                if (cod.charAt(j) == ar[i]) {
                    codeCheck++;
                }
            }
        }
        return cod.length() == Rules.getCodeLenght() && codeCheck == Rules.getCodeLenght();
    }

    public String insertCode() {
        String label = "";
        String codeIn = "";
        do {
            JFrame frame = new JFrame("Insert Code");
            codeIn = JOptionPane.showInputDialog(frame,
                    label + "Insert Code?\nDont let Player 2 look at the code.\n" + Arrays.toString(Rules.getOptionsArray()) + "\nformat: " + Rules.getOptionsStr() + "", null);
            label = "Code Error, Try Again.";
        } while (!codeCheck(codeIn));

        return codeIn;
    }

    public String insertDeCode() {

        String label = "";
        String deCodeIn = "";
        do {

            JFrame frame = new JFrame("Insert deCode");
            deCodeIn = JOptionPane.showInputDialog(frame,
                    label + "Insert deCode \n"
                    + "Turn: " + (+1) + " of " + Rules.getMaxTries() + " !\n"
                    + Arrays.toString(Rules.getOptionsArray()) + "\n"
                    + "format: " + Rules.getOptionsStr() + "\n"
                    + "Previous tries:\n"
                    + "Try# " + Rules.getOptionsStr() + " perf semi\n"
                    + tryLog);
        } while (!codeCheck(deCodeIn));
        return deCodeIn;
    }

    public void gameOver(Code deCod) {
        String finalLog;
        if (deCod.getPerfMatches() == Rules.getCodeLenght()) {
            finalLog = "Game Over!\nYou cracked the code! (" + code.getCode() + ")\n";
        } else {
            finalLog = "Game Over!\nYou failed cracking the code! (" + code.getCode() + ")\n";
        }
        JFrame finalFrame = new JFrame("Insert deCode");
        JOptionPane.showMessageDialog(finalFrame,
                finalLog
                + "Log:\n"
                + "Try# " + Rules.getOptionsStr() + " perf semi\n"
                + tryLog);
    }
}
