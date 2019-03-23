package MasterMind;

import java.util.Arrays;

/**
 *
 * @author fsancheztemprano
 */
public class Rules {

    private static int codeLength;
    private static int codeValues;
    private static int gameTries;

    private static final int maxLength = 15;
    private static final int maxValues = 15;
    private static final int maxTries = 99;

    private static char[] optionsArray;
    private static String optionsString;
    private static String formatString;

    private static char[] fullArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'};

    private static final boolean DEBUG=true;

    public static boolean isDEBUG() {
        return DEBUG;
    }

    public static void defaultRules() {
        codeLength = 4;
        codeValues = 6;
        gameTries = 10;
        optionsArray = buildArray(codeValues);
        formatString = buildFormatString(codeLength);
        optionsString = buildOptionsString(codeValues);
    }

    public static void editRules(int codeL, int codeV, int maxT) {
        codeLength = codeL;
        codeValues = codeV;
        gameTries = maxT;
        optionsArray = buildArray(codeValues);
        formatString = buildFormatString(codeLength);
        optionsString = buildOptionsString(codeValues);
    }

    public static int getCodeLength() {
        return codeLength;
    }
    public static int getCodeValues() {
        return codeValues;
    }
    public static int getGameTries() {
        return gameTries;
    }

    public static int getMaxLength() {
        return maxLength;
    }
    public static int getMaxValues() {
        return maxValues;
    }
    public static int getMaxTries() {
        return maxTries;
    }

    public static char[] getOptionsArray() {
        return optionsArray;
    }
    public static String getFormatString() {
        return formatString;
    }
    public static String getOptionsString() {
        return optionsString;
    }

    public static boolean setCodeLength(int codeL) {
        if (codeL > 1 && codeL <= maxLength) {
            codeLength = codeL;
            optionsString = buildFormatString(codeL);
            return true;
        } else {
            return false;
        }
    }

    public static boolean setCodeValues(int codeV) {
        if (codeV > 1 && codeV <= maxValues) {
            codeValues = codeV;
            optionsArray = buildArray(codeV);
            return true;
        } else {
            return false;
        }
    }

    public static boolean setGameMaxTries(int maxT) {
        if (maxT > 1 && maxT <= maxTries) {
            codeValues = maxT;
            return true;
        } else {
            return false;
        }
    }
    public static boolean checkCodeLength(int codeL) {
        if (codeL > 1 && codeL <= maxLength) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkCodeValues(int codeV) {
        if (codeV > 1 && codeV <= maxValues) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkGameMaxTries(int maxT) {
        if (maxT > 1 && maxT <= maxTries) {
            return true;
        } else {
            return false;
        }
    }

    private static char[] buildArray(int codeValues) {

        char[] options = new char[codeValues];
        System.arraycopy(fullArray, 0, options, 0, codeValues);
        return options;
    }

    static String buildFormatString(int codeLength) {
        String str = "";
        for (int i = 0; i < codeLength; i++) {
            str = str + "X";
        }
        return str;
    }

    private static String buildOptionsString(int codeValues) {
        String str = "";
        for (int i = 0; i < codeValues; i++) {
            str = str + fullArray[i];
        }
        return str;
    }

    public static String rulesToString() {
        return Loc.rule4 + Loc.rule1 + ": " + getGameTries() + "\n" + Loc.rule2 + ": " + getCodeLength() + "\n" + Loc.rule3 + ": " + getCodeValues() + "\n" + Arrays.toString(getOptionsArray());
    }
}
