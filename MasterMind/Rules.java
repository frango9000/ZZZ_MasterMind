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
        codeLenght = 6;
        codeValues = 6;
        maxTries = 10;
        optionsArray = buildArray(codeValues);
        optionsStr = buildString(codeValues);
    }

    public static boolean editRules(int codeLen, int codeVal, int maxTri) {
        codeLenght = codeLen;
        codeValues = codeVal;
        maxTries = maxTri;
        optionsArray = buildArray(codeValues);
        optionsStr = buildString(codeValues);
        if(codeLenght > 15 || codeLenght<2) 
            return false;
        if(codeValues > 15 || codeValues<2) 
            return false;
        return maxTries >= 2;
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


    public static char[] buildArray(int len) {

        char[] fullArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'};
        char[] options = new char[len];
        System.arraycopy(fullArray, 0, options, 0, len);
        return options;
    }
    
      public static char[] getOptionsArray() {
        return optionsArray;
    }
    public static String buildString(int val) {
        String str="";
        for(int i=0;i<val;i++){
           str = str+"X";
        }
        return str;
    }

    public static String getOptionsStr() {
        return optionsStr;
    }
    

}
