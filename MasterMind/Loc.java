/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MasterMind;

/**
 *
 * @author fsancheztemprano
 */
public class Loc {

    public static String intro, lang;
    public static String pick1, pick2, pick3;
    public static String edit1, edit2, edit3, edit4;
    public static String newgame1, newgame2;
    public static String opo1, opo2, opo3;
    public static String rule1, rule2, rule3, rule4;
    public static String msg1, msg2, msg3, msg4;
    public static String code1, code2, err1;
    public static String decode1, decode2;
    public static String over1, over2, over3;
    public static String[] langs = new String[]{"English", "Español"};

    public static void pickLang(int i) {
        switch (i) {
            case 0:
                eng();
                break;
            case 1:
                esp();
                break;
            default:
                eng();
                break;
        }
    }

    public static void eng() {
        lang = "English";
        intro = "Welcome to MasterMind:\n"
                + "                    In this game Player 1 inserts a code\n"
                + "                    and Player 2 tries to crack it.\n"
                + "                    After every try player 2 will be given hints:\n"
                + "                    (P) : the number of matches in their correct position\n"
                + "                    (S) : the number of matches in their incorrect position";

        pick2 = "Default ";
        pick1 = "Pick Rule Set";

        edit1 = "Edit Rules";
        edit2 = "Insert: ";
        edit3 = "Custom Rules Valid";
        edit4 = "Custom ";

        rule1 = "Max Tries";
        rule2 = "Code Lenght";
        rule3 = "Code Variables";
        rule4 = "Rules:";

        newgame1 = "New Game";
        newgame2 = "Exit";

        opo1 = "Human";
        opo2 = "AI";
        opo3 = "Pick Opponent";

        code1 = "Insert Secret Code:";
        code2 = "Format";

        err1 = "Error, Try Again.";

        decode1 = "Insert deCode";
        decode2 = "Turn: ";

        over1 = "Game Over!";
        over2 = "You cracked the code";
        over3 = "You failed cracking the code";

        msg1 = "Max Tries";
        msg2 = "Code Lenght";
        msg3 = "Accept";
        msg4 = "Back";
    }

    public static void esp() {
        lang = "Castellano";
        intro = "MasterMind:\n"
                + "                    El jugador 1 introduce el codigo secreto\n"
                + "                    y el jugador 2 intenta descifrarlo.\n"
                + "                    Con cada intento el jugador 2 recibe pistas:\n"
                + "                    (P) : el numero aciertos en su posicion correcta\n"
                + "                    (S) : el numero aciertos en su posicion incorrecta";

        pick2 = "MasterMind ";
        pick1 = "Elige las reglas\n\n\b";

        edit1 = "Editar reglas";
        edit2 = "Insertar: ";
        edit3 = "Reglas Validas";
        edit4 = "Personalizadas ";

        rule1 = "Max Intentos";
        rule2 = "Longitud del Codigo";
        rule3 = "Cantidad de Variables";
        rule4 = "Reglas: \n";

        newgame1 = "Nuevo Juego";
        newgame2 = "Salir";

        opo1 = "Humano";
        opo2 = "AI";
        opo3 = "Elije Opponente";

        code1 = "Inserta Codigo Secreto:";
        code2 = "Formato: ";

        err1 = "Error, intentalo de nuevo.\n";

        decode1 = "Inserta deCode";
        decode2 = "Turno: ";

        over1 = "Game Over!";
        over2 = "Descodificaste el codigo! Has Ganado! (";
        over3 = "Superado limite de intentos! Has perdido! (";
    }

}
