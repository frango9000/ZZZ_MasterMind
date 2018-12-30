package MasterMind;

import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * @author fsancheztemprano
 */
public class Console {

    public static void consolePickLang() {
        Scanner scan = new Scanner(System.in);
        String[] opciones = Loc.langs;

        for (int i=0; i<opciones.length; i++){
            System.out.println(i+" : "+opciones[i]);
        }
        Loc.pickLang(scan.nextInt());
    }
    public static void consoleIntro() {
        System.out.println( Loc.intro );
    }

    public static void consolePickRuleset() {
        Rules.defaultRules();
        Scanner scan = new Scanner(System.in);
        System.out.println(Loc.pick1 +"\n1 : "+ Loc.edit1 + "\n2 : "+ Loc.pick2+" "+ Rules.rulesToString());
        int seleccion = scan.nextInt();

        switch (seleccion) {
            case 0:
                consoleNewRules();
                break;
            default:
                break;
        }
    }

    public static void consoleNewRules() {
        int codeL, codeV, maxT;
        String label = "";
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println(label + Loc.edit2 + Loc.rule1 + " ( 2 - 99 ) : ");
            maxT = scan.nextInt();
            label = Loc.err1 + "\n";
        } while (!Rules.setMaxTries(maxT));
        label = "";
        do {
            System.out.println( label + Loc.edit2 + Loc.rule2 + " ( 2 - " + Rules.getMaxLength() + " ) : ");
            codeL = scan.nextInt();
            label = Loc.err1 + "\n";
        } while (!Rules.setCodeLenght(codeL));
        label = "";
        do {
            System.out.println( label + Loc.edit2 + Loc.rule3 + " ( 2 - " + Rules.getMaxValues() + " ) : ");
            codeV = scan.nextInt();
            label = Loc.err1 + "\n";
        } while (!Rules.setCodeValues(codeV));
        System.out.println( Loc.edit4 + Rules.rulesToString());
    }

    public static boolean consoleNewGame() {
        
        Scanner scan = new Scanner(System.in);
        System.out.println(Loc.newgame1+ "?\n1: "+ Loc.newgame1+"\n2: "+ Loc.newgame2);
        int newg = scan.nextInt();

        switch (newg) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    public static boolean consolePickRival() {
        Scanner scan = new Scanner(System.in);
        System.out.println(Loc.opo3+ "\n1: "+ Loc.opo1+"\n2: "+ Loc.opo2);
        int newg = scan.nextInt();

        switch (newg) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    public static String consoleInsertCode(Game game) {
        Scanner scan = new Scanner(System.in);
        String label = "";
        String codeIn = "";
        do {
            System.out.println(label+ Loc.code1+ "\n"+ Arrays.toString(Rules.getOptionsArray()) +"\n"+ Loc.code2 + Rules.getFormatString());
            codeIn = scan.next();
            label = Loc.err1;
        } while (!game.codeCheck(codeIn));

        return codeIn;
    }

    public static String consoleInsertDeCode(Game game) {
        Scanner scan = new Scanner(System.in);
        String label = "";
        String deCodeIn = "";
        do {
            System.out.println(label
                    + Loc.decode1 + "\n"
                    + Loc.code2 + Rules.getFormatString() + "\n"
                    + Arrays.toString(Rules.getOptionsArray()) + "\n"
                    + Loc.decode2 + (game.getTries() + 1) + " / " + Rules.getMaxTries() + " !\n\n"
                    + Loc.decode2 + Rules.getFormatString() + " (P) (S)\n"
                    + game.getTryLog());
            
            deCodeIn = scan.next();
            label = Loc.err1;
        } while (!game.codeCheck(deCodeIn));
        return deCodeIn;
    }

    public static void consoleGameOver(Game game,Code code, Code deCod) {
        String finalLog;
        if (deCod.getPerfMatches() == Rules.getCodeLength()) {
            finalLog = Loc.over1 + "\n\n" + Loc.over2 + "! (" + code.getCode() + ")\n";
        } else {
            finalLog = Loc.over1 + "\n\n" + Loc.over3 + "! (" + code.getCode() + ")\n";
        }
        System.out.println(
                finalLog + "\n\n"
                + Loc.decode2 + Rules.getFormatString() + " (P) (S)\n"
                + game.getTryLog());
    }
}
