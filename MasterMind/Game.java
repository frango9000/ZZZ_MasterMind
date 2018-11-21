package MasterMind;
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
        if (Menu.menuPickRival()) {
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

        Menu.menuGameOver(this, code, decodes[tries]);
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
        return Menu.menuInsertCode(this);
    }

    public String insertDeCode() {
        return Menu.menuInsertDeCode(this);
    }
}
