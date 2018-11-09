/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MasterMind;

/**
 *
 * @author NarF
 */
public class Rules {

    private static int codeLenght;
    private static int codeValues;
    private static int maxTries;

    private static char[] optionsArray;
    private static String optionsStr;

    public static void defaultRules() {
        codeLenght = 4;
        codeValues = 6;
        maxTries = 10;
        optionsArray = buildArray(codeValues);
        optionsStr = buildString(codeLenght);
    }

    public static boolean editRules(int codeL, int codeV, int maxT) {
        codeLenght = codeL;
        codeValues = codeV;
        maxTries = maxT;
        optionsArray = buildArray(codeValues);
        optionsStr = buildString(codeLenght);
        return verifyRules();
    }

    public static int getCodeLenght() {
        return codeLenght;
    }

    public static int getCodeValues() {
        return codeValues;
    }

    public static int getMaxTries() {
        return maxTries;
    }

    public static char[] getOptionsArray() {
        return optionsArray;
    }

    public static String getOptionsStr() {
        return optionsStr;
    }

    public static boolean verifyRules() {
        if (codeLenght > 15 || codeLenght < 2) {
            return false;
        }
        if (codeValues > 15 || codeValues < 2) {
            return false;
        }
        return maxTries >= 2;
    }

    private static char[] buildArray(int len) {

        char[] fullArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'};
        char[] options = new char[len];
        System.arraycopy(fullArray, 0, options, 0, len);
        return options;
    }

    private static String buildString(int val) {
        String str = "";
        for (int i = 0; i < val; i++) {
            str = str + "X";
        }
        return str;
    }

}
