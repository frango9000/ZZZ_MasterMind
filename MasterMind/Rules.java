package MasterMind;

import java.util.Arrays;

/**
 *
 * @author fsancheztemprano
 */
public class Rules {

    private static int codeLenght = 4;
    private static int codeValues = 6;
    private static int maxTries = 10;

    private static char[] optionsArray;
    private static String optionsStr;

    public static void defaultRules() {
        optionsArray = buildArray(codeValues);
        optionsStr = buildString(codeLenght);
    }

    public static void editRules(int codeL, int codeV, int maxT) {
        codeLenght = codeL;
        codeValues = codeV;
        maxTries = maxT;
        optionsArray = buildArray(codeValues);
        optionsStr = buildString(codeLenght);
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
        System.out.println(optionsArray);
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

    public static String buildString(int val) {
        String str = "";
        for (int i = 0; i < val; i++) {
            str = str + "X";
        }
        return str;
    }

    public static String rulesToString() {
        return "Rules: \nMax Tries: " + getMaxTries() + "\nCode Lenght: " + getCodeLenght() + "\nCode Options: " + getCodeValues() + "\n" + Arrays.toString(getOptionsArray());
    }
}
