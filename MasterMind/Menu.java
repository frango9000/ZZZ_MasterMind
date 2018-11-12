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
        JOptionPane.showMessageDialog(welcome,Loc.intro);

    }

    public static void menuPickRuleset() {
        Rules.defaultRules();
        String[] rulesets = {Loc.edit1, Loc.pick2};
        int seleccion = JOptionPane.showOptionDialog(null, Loc.pick1+Loc.pick2 + Rules.rulesToString(), "MasterMind", 0, 3, null, rulesets, 0);

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
        String label = "";
        JFrame frame = new JFrame(Loc.edit1);
        do {
            maxT = Integer.parseInt(JOptionPane.showInputDialog(frame, label + Loc.edit2 + Loc.rule1 + " ( 2 - 99 ) : ", null));
            label = Loc.code4 + "\n";
        } while (!Rules.setMaxTries(maxT));
        label="";
        do {
            codeL = Integer.parseInt(JOptionPane.showInputDialog(frame, label + Loc.edit2 + Loc.rule2 + " ( 2 - " + Rules.getMaxLength() + " ) : ", null));
            label = Loc.code4 + "\n";
        } while (!Rules.setCodeLenght(codeL));
        label="";
        do {
            codeV = Integer.parseInt(JOptionPane.showInputDialog(frame, label + Loc.edit2 + Loc.rule3 + " ( 2 - " + Rules.getMaxValues() + " ) : ", null));
            label = Loc.code4 + "\n";
        } while (!Rules.setCodeValues(codeV));
        JOptionPane.showMessageDialog(frame, Loc.edit4 + Rules.rulesToString());
    }

    public static boolean menuNewGame() {
        String[] opciones = {Loc.newgame1, Loc.newgame2};
        int newg = JOptionPane.showOptionDialog(null, Loc.newgame1, "MasterMind", 0, 0, null, opciones, 1);

        switch (newg) {
            case 0:
                return true;
            default:
                return false;

        }

    }

    public static boolean pickRival() {
        String[] opciones = {Loc.opo1, Loc.opo2};
        int newg = JOptionPane.showOptionDialog(null, Loc.opo3, "MasterMind", 0, 0, null, opciones, 1);

        switch (newg) {
            case 0:
                return true;
            default:
                return false;

        }

    }
}
