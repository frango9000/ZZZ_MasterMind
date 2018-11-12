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
    public static String intro, pick1, pick2, pick3;
    public static String edit1, edit2, edit3, edit4;
    public static String newgame1, newgame2;
    public static String opo1, opo2, opo3;
    public static String rule1, rule2, rule3, rule4;
    public static String code1, code2, code3, code4;
    public static String decode1, decode2, decode3, decode4;
    public static String over1, over2, over3;
    
    public static void eng(){
        intro = "Welcome to MasterMind:\n"
                + "                    In this game Player 1 inserts a code\n"
                + "                    and Player 2 tries to crack it.\n"
                + "                    after every try player 2 will be given hints\n"
                + "                    based on the number of correct placements and\n"
                + "                    the number of correct choices but bad placements";
        
        pick1 = "Edit Rules";
        pick2 = "Default ";
        pick3 = "Pick Rule Set\n\n\b";
        
        edit1= "Edit Rules";
        edit2="Insert: ";
        edit3="Custom Rules Valid";
        edit4="Custom ";
                
        rule1="Max Tries";
        rule2="Code Lenght";
        rule3="Code Variables";
        rule4="Rules: \n";
        
        newgame1="New Game";
        newgame2="Salir";
        
        opo1="Human";
        opo2="AI";
        opo3="Pick Opponent";
        
        code1="Insert Code:";
        code2="\nDont let Player 2 look at the code.\n";
        code3="\nformat: ";
        code4="Code Error, Try Again.";
                
        decode1="Insert deCode";
        decode2= "Turn: ";
        decode3= "Previous tries:\n";
        decode4="Try# ";
                
        over1="Game Over!\n";
        over2="You cracked the code! (";
        over3="You failed cracking the code! (";
        
        
        
    }
    
}
