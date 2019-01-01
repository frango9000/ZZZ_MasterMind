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
        decodes = new Code[Rules.getMaxTries() + 1];
        this.ui=ui;
    }
    public Game(Code code) {
        this.code = code;
        tries = 0;
        tryLog = "";
        decodes = new Code[Rules.getMaxTries() + 1];
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
            code = new Code(insertCode());
        } else {
            code = new Code();
        }

        do {
            Code deCode = new Code(insertDeCode(), code);
            incTries();
            decodes[tries] = deCode;
            updateLog(getTries() + "/" + Rules.getMaxTries() + " " + deCode.getCode() + " " + deCode.getPerfMatches() + " " + deCode.getSemiMatches() + "\n");
            if (deCode.getPerfMatches() >= Rules.getCodeLength()) {
                break;
            }
        } while (tries < Rules.getMaxTries());

        gameOver();
    }
    public boolean pickRival(){
        if(ui == 0){
            return Console.consolePickRival();
        }else {
            return Menu.menuPickRival();
        }        
    }

    public String insertCode() {
        if(ui == 0){
            return Console.consoleInsertCode();
        }else {
            return Menu.menuInsertCode();
        } 
    }

    public String insertDeCode() {        
        if(ui == 0){
            return Console.consoleInsertDeCode(this);
        }else {
            return Menu.menuInsertDeCode(this);
        } 
        
    }
    public Code lastDeCode(){
        Code deCode=decodes[0];
        for(int i=0; i<=decodes.length; i++){
            if (decodes[i]==null) break;
            deCode=decodes[i];
        }
        return deCode;
    }

    public void gameOver(){
        if(ui == 0){
            Console.consoleGameOver(this);
        }else {
            Menu.menuGameOver(this);
        }
    }

    public String finalLog(){
        String finalLog;
        if (lastDeCode().getPerfMatches() == Rules.getCodeLength()) {
            finalLog = Loc.over1 + "\n\n" + Loc.over2 + "! (" + getCode().getCode() + ")\n";
        } else {
            finalLog = Loc.over1 + "\n\n" + Loc.over3 + "! (" + getCode().getCode() + ")\n";
        }
        return finalLog;
    }
}
