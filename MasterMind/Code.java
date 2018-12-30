package MasterMind;

import java.util.Arrays;
import java.util.Random;

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

    public Code() {
        Random rand = new Random();
        char[] randCode = new char[Rules.getCodeLength()];
        String options = new String(Rules.getOptionsArray());
        code = Rules.buildFormatString(Rules.getCodeLength());                //code = "XXXX"

        for (int i = 1; i <= Rules.getCodeLength(); i++) {
            int randn = rand.nextInt(options.length());                 //Length of String options = "ABCDEF"
            if(Rules.DEBUG)System.out.println(randn);                   //DEBUG
            randCode[i - 1] = options.charAt(randn);
        }
        code = new String(randCode);
    }

    public Code(String code) {
        this.code = code;
    }

    public Code(String code, Code cod) {
        this.code = code;

        codeChecks = new boolean[Rules.getCodeLength() + 1];
        Arrays.fill(codeChecks, Boolean.FALSE);
        deCodeChecks = new boolean[Rules.getCodeLength() + 1];
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
