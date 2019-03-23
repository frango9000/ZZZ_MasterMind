package MasterMind;

/**
 * @author fsancheztemprano
 */
public class Game {

    private int tries;
    private String tryLog;
    private Code code;
    private Code[] decodes;
    private Rules rules;


    public Code[] getDecodes() {
        return decodes;
    }

    public void setDecodes(Code[] decodes) {
        this.decodes = decodes;
    }

    public Code getDecodes(int index) {
        return decodes[index];
    }

    public void setDecodes(Code deCode, int index) {
        this.decodes[index] = deCode;
    }

    private int ui;          //0 console, 1 JOptionPane, 2 FX Gui (to do)

    public Game(int ui) {
        tries = 0;
        tryLog = "";
        decodes = new Code[Rules.getGameTries() + 1];
        this.ui = ui;
    }

    public Game(Code code) {
        this.code = code;
        tries = 0;
        tryLog = "";
        decodes = new Code[Rules.getGameTries() + 1];
        this.ui = 2;
    }


    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
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
        if (pickRival()) {
            code = new Code();
        } else {
            code = new Code(insertCode());
        }

        do {
            Code deCode = new Code(insertDeCode(), code);
            incTries();
            decodes[tries] = deCode;
            updateLog(getTries() + "/" + Rules.getGameTries() + " " + deCode.getCode() + " " + deCode.getPerfMatches() + " " + deCode.getSemiMatches() + "\n");
            if (deCode.getPerfMatches() >= Rules.getCodeLength()) {
                break;
            }
        } while (tries < Rules.getGameTries());
        gameOver();
    }

    public boolean pickRival() {
        switch (ui) {
            case 0:
                return Console.pickRival();
            case 1:
                return Menu.pickRival();
            default:
                return false;//ui
        }
    }

    public String insertCode() {
        switch (ui) {
            case 0:
                return Console.insertCode();
            case 1:
                return Menu.insertCode();
            default:
                return null;//ui
        }
    }

    public String insertDeCode() {
        switch (ui) {
            case 0:
                return Console.insertDeCode(this);
            case 1:
                return Menu.insertDeCode(this);
            default:
                return null;//Ui
        }
    }

    public void gameOver() {
        switch (ui) {
            case 0:
                Console.gameOver(this);
                break;
            case 1:
                Menu.gameOver(this);
                break;
            default:
                //ui
        }
    }

    public Code lastDeCode() {
        Code deCode = decodes[0];
        for (int i = 0; i <= decodes.length; i++) {
            if (decodes[i] == null) break;
            deCode = decodes[i];
        }
        return deCode;
    }

    public String finalLog() {
        if (lastDeCode().getPerfMatches() == Rules.getCodeLength()) {
            return Loc.over1 + "\n\n" + Loc.over2 + "! (" + getCode().getCode() + ")\n";
        } else {
            return Loc.over1 + "\n\n" + Loc.over3 + "! (" + getCode().getCode() + ")\n";
        }
    }

    public static boolean intToBoolean(int i) {
        switch (i) {
            case 0:
                return false;
            default:
                return true;
        }
    }
}
