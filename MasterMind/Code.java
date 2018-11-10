package MasterMind;

import java.util.Arrays;

/**
 *
 * @author fsancheztemprano
 */
public class Code {

    private String code;

    private int perfMatches;
    private int semiMatches;

    private boolean[] codeChecks;
    private boolean[] deCodeChecks;

    public Code(String code) {
        this.code = code;
    }

    public Code(String code, Code cod) {
        this.code = code;

        codeChecks = new boolean[Rules.getCodeLenght() + 1];
        Arrays.fill(codeChecks, Boolean.FALSE);
        deCodeChecks = new boolean[Rules.getCodeLenght() + 1];
        Arrays.fill(deCodeChecks, Boolean.FALSE);

        perfMatches = perfCheck(cod);
        semiMatches = semiCheck(cod);

    }

    public String getCode() {
        return code;
    }

    public int getPerfMatches() {
        return perfMatches;
    }

    public int getSemiMatches() {
        return semiMatches;
    }

    private int perfCheck(Code cod) {
        int matches = 0;
        for (int i = 0; i < cod.code.length(); i++) {
            if (this.code.charAt(i) == cod.code.charAt(i)) {
                matches++;
                codeChecks[i] = true;
                deCodeChecks[i] = true;
            }
        }
        return matches;
    }

    private int semiCheck(Code cod) {
        int matches = 0;
        for (int i = 0; i < this.code.length(); i++) {
            for (int j = 0; j < cod.code.length(); j++) {
                if (i != j && codeChecks[j] != true && deCodeChecks[i] != true) {
                    if (this.code.charAt(i) == cod.code.charAt(j)) {
                        matches++;
                        codeChecks[j] = true;
                        deCodeChecks[i] = true;
                        break;
                    }
                }
            }
        }
        return matches;
    }

}
