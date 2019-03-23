package MasterMind;

import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * @author fsancheztemprano
 */
public class Console {

    public static void pickLang() {
        Scanner scan = new Scanner(System.in);
        String[] opciones = Loc.langs;

        for (int i=0; i<opciones.length; i++){
            System.out.println(i+" : "+opciones[i]);
        }
        Loc.pickLang(scan.nextInt());
    }
    public static void intro() {
        System.out.println( Loc.intro );
    }

    public static void pickRuleset() {
        Rules.defaultRules();
        Scanner scan = new Scanner(System.in);
        System.out.println(Loc.pick1 +"\n1 : "+ Loc.edit1 + "\n2 : "+ Loc.pick2+" "+ Rules.rulesToString());
        int seleccion = scan.nextInt();

        switch (seleccion) {
            case 0:
                newRules();
                break;
            default:
                break;
        }
    }

    public static void newRules() {
        int codeL, codeV, maxT;
        String label = "";
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println(label + Loc.edit2 + Loc.rule1 + " ( 2 - 99 ) : ");
            maxT = scan.nextInt();
            label = Loc.err1 + "\n";
        } while (!Rules.setGameMaxTries(maxT));
        label = "";
        do {
            System.out.println( label + Loc.edit2 + Loc.rule2 + " ( 2 - " + Rules.getMaxLength() + " ) : ");
            codeL = scan.nextInt();
            label = Loc.err1 + "\n";
        } while (!Rules.setCodeLength(codeL));
        label = "";
        do {
            System.out.println( label + Loc.edit2 + Loc.rule3 + " ( 2 - " + Rules.getMaxValues() + " ) : ");
            codeV = scan.nextInt();
            label = Loc.err1 + "\n";
        } while (!Rules.setCodeValues(codeV));
        System.out.println( Loc.edit4 + Rules.rulesToString());
    }

    public static boolean newGame() {
        
        Scanner scan = new Scanner(System.in);
        System.out.println(Loc.newgame1+ "?\n1: "+ Loc.newgame1+"\n2: "+ Loc.newgame2);
        int in = scan.nextInt();
        return !Game.intToBoolean(in);
    }

    public static boolean pickRival() {
        Scanner scan = new Scanner(System.in);
        System.out.println(Loc.opo3+ "\n1: "+ Loc.opo1+"\n2: "+ Loc.opo2);
        int in = scan.nextInt();
        return !Game.intToBoolean(in);
    }

    public static String insertCode() {
        Scanner scan = new Scanner(System.in);
        String label = "";
        String codeIn = "";
        do {
            System.out.println(label+ Loc.code1+ "\n"+ Arrays.toString(Rules.getOptionsArray()) +"\n"+ Loc.code2 + Rules.getFormatString());
            codeIn = scan.next();
            label = Loc.err1;
        } while (!Code.codeCheck(codeIn));

        return codeIn;
    }

    public static String insertDeCode(Game game) {
        Scanner scan = new Scanner(System.in);
        String label = "";
        String deCodeIn = "";
        do {
            System.out.println(label
                    + Loc.decode1 + "\n"
                    + Loc.code2 + Rules.getFormatString() + "\n"
                    + Arrays.toString(Rules.getOptionsArray()) + "\n"
                    + Loc.decode2 + (game.getTries() + 1) + " / " + Rules.getGameTries() + " !\n\n"
                    + Loc.decode2 + Rules.getFormatString() + " (P) (S)\n"
                    + game.getTryLog());
            
            deCodeIn = scan.next();
            label = Loc.err1;
        } while (!Code.codeCheck(deCodeIn));
        return deCodeIn;
    }

    public static void gameOver(Game game) {
        String finalLog = game.finalLog();
        System.out.println(
                finalLog + "\n\n"
                + Loc.decode2 + Rules.getFormatString() + " (P) (S)\n"
                + game.getTryLog());
    }
}
