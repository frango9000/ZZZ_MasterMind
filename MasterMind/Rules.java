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

    private static int maxLength = 15;
    private static int maxValues = 15;

    private static char[] optionsArray;
    private static String optionsString;
    private static String valuesString;


    private static char[] fullArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'};

    public static final boolean DEBUG = true;

    public static void defaultRules() {
        optionsArray = buildArray(codeValues);
        optionsString = buildFormatString(codeLenght);
        optionsString = buildOptionsString(codeValues);
    }

    public static void editRules(int codeL, int codeV, int maxT) {
        codeLenght = codeL;
        codeValues = codeV;
        maxTries = maxT;
        optionsArray = buildArray(codeValues);
        optionsString = buildFormatString(codeLenght);
        valuesString = buildOptionsString(codeValues);
    }

    public static int getCodeLenght() {        return codeLenght;    }

    public static int getCodeValues() {        return codeValues;    }

    public static int getMaxTries() {        return maxTries;    }

    public static int getMaxLength() {        return maxLength;    }

    public static int getMaxValues() {        return maxValues;    }

    public static char[] getOptionsArray() {        return optionsArray;    }

    public static String getOptionsString() {        return optionsString;    }

    public static String getValuesString() {        return valuesString;    }



    public static boolean setCodeLenght(int codeL) {
        if (codeL > 1 && codeL <= maxLength) {
            codeLenght = codeL;
            optionsString = buildFormatString(codeLenght);
            return true;
        } else {
            return false;
        }
    }

    public static boolean setCodeValues(int codeV) {
        if (codeV > 1 && codeV <= maxValues) {
            codeValues = codeV;
            optionsArray = buildArray(codeValues);
            return true;
        } else {
            return false;
        }
    }

    public static boolean setMaxTries(int maxT) {
        if (maxT > 1 && maxT <= 99) {
            codeValues = maxT;
            return true;
        } else {
            return false;
        }
    }

    private static char[] buildArray(int len) {

        char[] options = new char[len];
        System.arraycopy(fullArray, 0, options, 0, len);
        return options;
    }

    public static String buildFormatString(int val) {
        String str = "";
        for (int i = 0; i < val; i++) {
            str = str + "X";
        }
        return str;
    }
    public static String buildOptionsString(int val) {
        String str = "";
        for (int i = 0; i < val; i++) {
            str = str + fullArray[i];
        }
        return str;
    }

    public static String rulesToString() {
        return Loc.rule4 + Loc.rule1 + ": " + getMaxTries() + "\n" + Loc.rule2 + ": " + getCodeLenght() + "\n" + Loc.rule3 + ": " + getCodeValues() + "\n" + Arrays.toString(getOptionsArray());
    }
}
