package MasterMind;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author fsancheztemprano
 */
public class Menu {

    public static void menuIntro() {
        JFrame welcome = new JFrame("MasterMind");
        JOptionPane.showMessageDialog(welcome,
                "Welcome to MasterMind:\n"
                + "                    In this game Player 1 inserts a code\n"
                + "                    and Player 2 tries to crack it.\n"
                + "                    after every try player 2 will be given hints\n"
                + "                    based on the number of correct placements and\n"
                + "                    the number of correct choices but bad placements");

    }

    public static void menuPickRuleset() {
        Rules.defaultRules();
        String[] rulesets = {"Edit Rules", "Default"};
        int seleccion = JOptionPane.showOptionDialog(null, "Pick Rule Set\n\n\bDefault " + Rules.rulesToString(), "MasterMind", 0, 3, null, rulesets, 0);

        switch (seleccion) {
            case 0:
                menuNewRules();
                break;
            default:
                break;
        }
    }

    public static void menuNewRules() {
        int codeL, codeV, maxT;
        do {
            JFrame frame = new JFrame("Edit Rules");
            maxT = Integer.parseInt(JOptionPane.showInputDialog(frame, "Insert Max Tries ( 2 - 99 ) : ", null));
            codeL = Integer.parseInt(JOptionPane.showInputDialog(frame, "Insert Code Lenght ( 2 - 15 ) : ", null));
            codeV = Integer.parseInt(JOptionPane.showInputDialog(frame, "Insert Code Variables ( 2 - 15 ) : ", null));
        } while (!Rules.verifyRules());
        JFrame welcome = new JFrame("Custom Rules Valid");
        Rules.editRules(codeL, codeV, maxT);
        JOptionPane.showMessageDialog(welcome, "Custom  " + Rules.rulesToString());
    }

    public static boolean menuNewGame() {
        String[] opciones = {"New Game", "Quit"};
        int newg = JOptionPane.showOptionDialog(null, "New Game?", "MasterMind", 0, 0, null, opciones, 1);

        switch (newg) {
            case 0:
                return true;
            default:
                return false;

        }

    }
    public static boolean pickRival(){
        String[] opciones = {"Human", "AI"};
        int newg = JOptionPane.showOptionDialog(null, "Pick Opponent?", "MasterMind", 0, 0, null, opciones, 1);

        switch (newg) {
            case 0:
                return true;
            default:
                return false;

        }
        
    }
}
