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
            JFrame frame = new JFrame(Loc.code1);
            codeIn = JOptionPane.showInputDialog(frame,
                    label + Loc.code1+Loc.code2 + Arrays.toString(Rules.getOptionsArray()) + Loc.code3 + Rules.getOptionsStr() + "", null);
            label = Loc.code4;
        } while (!codeCheck(codeIn));

        return codeIn;
    }

    public String insertDeCode() {

        String label = "";
        String deCodeIn = "";
        do {

            JFrame frame = new JFrame(Loc.decode1);
            deCodeIn = JOptionPane.showInputDialog(frame,
                    label + Loc.decode1+" \n"
                    + Loc.decode2 + (+1) + " / " + Rules.getMaxTries() + " !\n"
                    + Arrays.toString(Rules.getOptionsArray()) + "\n"
                    + Loc.code3+ Rules.getOptionsStr() + "\n"
                    + Loc.decode3
                    + Loc.decode4 + Rules.getOptionsStr() + " perf semi\n"
                    + tryLog);
        } while (!codeCheck(deCodeIn));
        return deCodeIn;
    }

    public void gameOver(Code deCod) {
        String finalLog;
        if (deCod.getPerfMatches() == Rules.getCodeLenght()) {
            finalLog = Loc.over1 + Loc.over2 + code.getCode() + ")\n";
        } else {
            finalLog = Loc.over1 + Loc.over3 + code.getCode() + ")\n";
        }
        JFrame finalFrame = new JFrame("Final");
        JOptionPane.showMessageDialog(finalFrame,
                finalLog
                + "Log:\n"
                + Loc.decode4 + Rules.getOptionsStr() + " perf semi\n"
                + tryLog);
    }
}
