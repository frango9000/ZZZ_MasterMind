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

    private int tries;
    private String tryLog;

    public Game() {
        tries = 0;
        tryLog = "";
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

    public static void reset() {

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

    public static String insertCode() {
        String label = "";
        String code = "";
        do {
            JFrame frame = new JFrame("Insert Code");
            code = JOptionPane.showInputDialog(frame,
                    label + "Insert Code?\nDont let Player 2 look at the code.\n" + Arrays.toString(Rules.getOptionsArray()) + "\nformat: " + Rules.getOptionsStr() + "", null);
            label = "Code Error, Try Again.";
        } while (Code.codeCheck(code));

        return code;
    }

    public static String insertDeCode() {
     
        String label = "";
        String deCode = "";
        do {

            JFrame frame = new JFrame("Insert deCode");
            deCode = JOptionPane.showInputDialog(frame,
                    label + "Insert deCode \n"
                    + "Turn: " + ( + 1) + " of " + Rules.getMaxTries() + " !\n"
                    + Arrays.toString(Rules.getOptionsArray()) + "\n"
                    + "format: " + Rules.getOptionsStr() + "\n"
                    + "Previous tries:\n"
                    + "Try# " + Rules.getOptionsStr() + " perf semi\n"
            );//+ tryLog);
        } while (Code.codeCheck(deCode));
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
                break;
            case 1:
                break;

        }

    }
    public static void startGame() {
        
    }
}
