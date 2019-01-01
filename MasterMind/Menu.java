package MasterMind;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author fsancheztemprano
 */
public class Menu {

    public static void menuIntro() {
        JOptionPane.showMessageDialog(null, Loc.intro, "MasterMind", 1);
    }

    public static void menuPickRuleset() {
        Rules.defaultRules();
        String[] rulesets = {Loc.edit1, Loc.pick2};
        int seleccion = JOptionPane.showOptionDialog(null, Loc.pick1 + Loc.pick2 + Rules.rulesToString(), "MasterMind", 0, 3, null, rulesets, 0);

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
        do {
            maxT = Integer.parseInt(JOptionPane.showInputDialog(null, label + Loc.edit2 + Loc.rule1 + " ( 2 - 99 ) : ", null));
            label = Loc.err1 + "\n";
        } while (!Rules.setMaxTries(maxT));
        label = "";
        do {
            codeL = Integer.parseInt(JOptionPane.showInputDialog(null, label + Loc.edit2 + Loc.rule2 + " ( 2 - " + Rules.getMaxLength() + " ) : ", null));
            label = Loc.err1 + "\n";
        } while (!Rules.setCodeLenght(codeL));
        label = "";
        do {
            codeV = Integer.parseInt(JOptionPane.showInputDialog(null, label + Loc.edit2 + Loc.rule3 + " ( 2 - " + Rules.getMaxValues() + " ) : ", null));
            label = Loc.err1 + "\n";
        } while (!Rules.setCodeValues(codeV));
        JOptionPane.showMessageDialog(null, Loc.edit4 + Rules.rulesToString());
    }

    public static boolean menuNewGame() {
        String[] opciones = {Loc.newgame1, Loc.newgame2};
        int in = JOptionPane.showOptionDialog(null, Loc.newgame1, "MasterMind", 0, 0, null, opciones, 3);
        return Console.true0(in);
    }

    public static boolean menuPickRival() {
        String[] opciones = {Loc.opo1, Loc.opo2};
        int in = JOptionPane.showOptionDialog(null, Loc.opo3, "MasterMind", 0, 0, null, opciones, 3);
        return Console.true0(in);
    }

    public static void menuPickLang() {
        String[] opciones = Loc.langs;
        int i = JOptionPane.showOptionDialog(null, Loc.opo3, "MasterMind", 0, 3, null, opciones, 3);
        Loc.pickLang(i);
    }
    
    public static String menuInsertCode() {
        String label = "";
        String codeIn = "";
        do {
            codeIn = JOptionPane.showInputDialog(null,
                    label
                    + Loc.code1 + "\n"
                    + Arrays.toString(Rules.getOptionsArray()) + "\n"
                    + Loc.code2 + Rules.getFormatString(),
                    "MasterMind", 3);
            label = Loc.err1;
        } while (!Code.codeCheck(codeIn));
        return codeIn;
    }

    public static String menuInsertDeCode(Game game) {
        String label = "";
        String deCodeIn = "";
        do {
            deCodeIn = JOptionPane.showInputDialog(null,
                    label
                    + Loc.decode1 + "\n"
                    + Loc.code2 + Rules.getFormatString() + "\n"
                    + Arrays.toString(Rules.getOptionsArray()) + "\n"
                    + Loc.decode2 + (game.getTries() + 1) + " / " + Rules.getMaxTries() + " !\n\n"
                    + Loc.decode2 + Rules.getFormatString() + " (P) (S)\n"
                    + game.getTryLog(),
                    "MasterMind", 3);
            label = Loc.err1;
        } while (!Code.codeCheck(deCodeIn));
        return deCodeIn;
    }

    public static void menuGameOver(Game game) {
        JOptionPane.showMessageDialog(null,
                game.finalLog() + "\n\n"
                + Loc.decode2 + Rules.getFormatString() + " (P) (S)\n"
                + game.getTryLog(),
                "MasterMind", 3);
    }
}
