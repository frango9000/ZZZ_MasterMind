package MasterMind;


import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Mastermind {
   // @SuppressWarnings("UnusedAssignment")
    public static void main(String[] args) {
        
       
        char[] optionsArray = new char[] { 'A' , 'B' , 'C' , 'D', 'E' , 'F' };
        int codeCheck;
        String code;
        String codeLabel="";
        String resultLabel="";
        
            JFrame welcome = new JFrame("Result");
            JOptionPane.showMessageDialog(welcome,
                                          "Welcome to MasterMind:\n"
                    + "                    In this game Player 1 inserts a code\n"
                    + "                    and Player 2 tries to crack it.\n"
                    + "                    after every try player 2 will be given hints\n"
                    + "                    based on the number of correct placements and\n"
                    + "                    the number of correct choices but bad placements");
        
        do{

            codeCheck=0;
            JFrame frame = new JFrame("Insert Code");
            code = JOptionPane.showInputDialog(frame,
                   codeLabel + "Insert Code?\nDont let Player 2 look at the code.\nA B C D E F\nformat: XXXX", null);

        
        
            for(int i = 0; i<optionsArray.length ; i++){
                for(int j = 0; j<code.length(); j++){
                    if(code.charAt(j) == optionsArray[i]){
                        codeCheck++;
                    }  
                }
            }
            codeLabel="Not Valid Code. Try again\n";

        }while( code.length() != 4 || codeCheck != 4 );
        
        System.out.println("Your code is Valid");
        
        int deCodeCheck;
        String deCode;
        int perfMatches=0;
        int semiMatches=0;
        codeLabel="";
        String tryLog="";
        int tries=0;
        
        do{
            do{
                deCodeCheck=0;

                JFrame frame = new JFrame("Insert deCode");
                deCode = JOptionPane.showInputDialog(frame,
                        codeLabel + "Insert deCode?\n"
                        + "A B C D E F\n"
                        + "format: XXXX\n"
                        + "Tries Left: " + (10-tries) + "!\n"
                        + "Previous tries:\n"
                        + "Try# XXXX perf semi\n"
                        + tryLog);
        
        
                for(int i = 0; i<optionsArray.length ; i++){
                    for(int j = 0; j<deCode.length(); j++){
                        if(deCode.charAt(j) == optionsArray[i]){
                            deCodeCheck++;
                        }  
                    }
                }
                codeLabel="Not Valid Code. Try again\n";
                
            }while( deCode.length() != 4 || deCodeCheck != 4 );
            
            System.out.println("Your deCode is Valid");
            
            perfMatches=0;
            semiMatches=0;
            boolean[] codeChecks = new boolean[5];
            Arrays.fill(codeChecks, Boolean.FALSE);
            boolean[] deCodeChecks = new boolean[5];
            Arrays.fill(deCodeChecks, Boolean.FALSE);
            
            for(int i = 0; i<code.length() ; i++){

                    if(deCode.charAt(i) == code.charAt(i)){
                        perfMatches++;
                        codeChecks[i]=true;
                        deCodeChecks[i]=true;
                    }  
                }
            
                for(int i = 0; i<deCode.length() ; i++){
                    for(int j = 0; j<code.length(); j++){
                            

                        if(i!=j && codeChecks[j]!=true && deCodeChecks[i] != true){
                                if(deCode.charAt(i) == code.charAt(j)){
                                    semiMatches++;
                                    codeChecks[j]=true;
                                    deCodeChecks[i]=true;
                                    break; 
                            }  
                                
                                    System.out.println(j + " = " + codeChecks[j]);
                        }
                    }
                }
                tries++;
                
                tryLog = tryLog + tries  +" "+ deCode +" "+ perfMatches +" "+ semiMatches + "\n";
                        


        }while(perfMatches!=4);
        
        String finalLog;
            if(perfMatches==4 && tries<10 ){
                finalLog="Game Over!\nYou cracked the code! ("+ code + ")\n";
            }else{
                finalLog="Game Over!\nYou failed cracking the code! ("+ code + ")\n";
            }
                JFrame finalFrame = new JFrame("Insert deCode");
                JOptionPane.showMessageDialog(finalFrame,
                        finalLog
                        + "Log:\n"
                        + "Try# XXXX perf semi\n"
                        + tryLog);
        
        System.out.println(code + "\n" + tries + " " + deCode + " " + perfMatches + " " + semiMatches);

    }
}