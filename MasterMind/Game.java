/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MasterMind;

import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author NarF
 */
public class Game {

    private static int tries = 0;
    private static String tryLog = "";

    static int perfMatches = 0;
    static int semiMatches = 0;

    private static boolean[] codeChecks;
    private static boolean[] deCodeChecks;

    public static int getTries() {
        return tries;
    }

    public static void setTries(int tries) {
        Game.tries = tries;
    }

    public static void incTries() {
        tries++;
    }

    public static void updateLog(String str) {
        tryLog += str;
    }

    public static String getTryLog() {
        return tryLog;
    }

    public static void setTryLog(String tryLog) {
        Game.tryLog = tryLog;
    }

    public static void reset() {

        perfMatches = 0;
        semiMatches = 0;
        codeChecks = new boolean[Rules.getCodeLenght() + 1];
        deCodeChecks = new boolean[Rules.getCodeLenght() + 1];
        Arrays.fill(codeChecks, Boolean.FALSE);
        Arrays.fill(deCodeChecks, Boolean.FALSE);
    }

    public static int codeCheck(String code) {
        int codeCheck = 0;
        char[] ar = Rules.getOptionsArray();
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < code.length(); j++) {
                if (code.charAt(j) == ar[i]) {
                    codeCheck++;
                }
            }
        }
        return codeCheck;
    }

    public static int perfCheck(String cod, String deCod) {
        int perfMatches = 0;
        for (int i = 0; i < cod.length(); i++) {
            if (deCod.charAt(i) == cod.charAt(i)) {
                perfMatches++;
                codeChecks[i] = true;
                deCodeChecks[i] = true;
            }
        }
        return perfMatches;
    }

    public static int semiCheck(String cod, String deCod) {
        int semiMatches = 0;
        for (int i = 0; i < deCod.length(); i++) {
            for (int j = 0; j < cod.length(); j++) {
                if (i != j && codeChecks[j] != true && deCodeChecks[i] != true) {
                    if (deCod.charAt(i) == cod.charAt(j)) {
                        semiMatches++;
                        codeChecks[j] = true;
                        deCodeChecks[i] = true;
                        break;
                    }

                    System.out.println(j + " = " + codeChecks[j]);
                }
            }
        }
        return semiMatches;
    }

    public static void newGameMsg() {
        JFrame welcome = new JFrame("Result");
        JOptionPane.showMessageDialog(welcome,
                "Welcome to MasterMind:\n"
                + "                    In this game Player 1 inserts a code\n"
                + "                    and Player 2 tries to crack it.\n"
                + "                    after every try player 2 will be given hints\n"
                + "                    based on the number of correct placements and\n"
                + "                    the number of correct choices but bad placements");

    }

    public static String insertCode(String label) {
        JFrame frame = new JFrame("Insert Code");
        String code = JOptionPane.showInputDialog(frame,
                label + "Insert Code?\nDont let Player 2 look at the code.\n" + Arrays.toString(Rules.getOptionsArray()) + "\nformat: " + Rules.getOptionsStr() + "", null);
        return code;
    }

    public static String insertDeCode(String label) {
        JFrame frame = new JFrame("Insert deCode");
        String deCode = JOptionPane.showInputDialog(frame,
                label + "Insert deCode \n"
                + "Turn: " + (tries + 1) + " of " + Rules.getMaxTries() + " !\n"
                + Arrays.toString(Rules.getOptionsArray()) + "\n"
                + "format: " + Rules.getOptionsStr() + "\n"
                + "Previous tries:\n"
                + "Try# " + Rules.getOptionsStr() + " perf semi\n"
                + tryLog);
        return deCode;
    }

    public static void gameOver(String cod, String deCod) {
        String finalLog;
        if (Game.perfMatches == Rules.getCodeLenght() && Game.getTries() < Rules.getMaxTries()) {
            finalLog = "Game Over!\nYou cracked the code! (" + cod + ")\n";
        } else {
            finalLog = "Game Over!\nYou failed cracking the code! (" + cod + ")\n";
        }
        JFrame finalFrame = new JFrame("Insert deCode");
        JOptionPane.showMessageDialog(finalFrame,
                finalLog
                + "Log:\n"
                + "Try# " + Rules.getOptionsStr() + " perf semi\n"
                + tryLog);

        //Game.updateLog(cod + "\n" + Game.getTries() + " " + deCod + " " + Game.perfMatches + " " + Game.semiMatches);
    }

    public static void restartPrompt() {
        String[] opciones = {"Si", "No"};
        int seleccion = JOptionPane.showOptionDialog(null, "Volver a Jugar", "MasterMind", 0, 0, null, opciones, 1);

        switch (seleccion) {
            case 0:
                //Circulo circulo = new Circulo();
                //circulo.mostrarArea();
                break;
            case 1:
                break;

        }

    }
}
