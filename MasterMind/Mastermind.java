package MasterMind;

public class Mastermind {

    public static void main(String[] args) {

        String resultLabel = "";

        //Start 
        Game game = new Game();
        Game.newGameMsg();

        Code code = new Code(Game.insertCode());
        while (!Code.codeCheck(code.getCode())) {
            
            Code.codeCheck(code.getCode());
            codeLabel = "Not Valid Code. Try again\n";

        } 

        System.out.println("Your code is Valid");
        codeLabel = "";

        do {
            do {
                deCode = Game.insertDeCode(codeLabel);
                deCodeCheck = Game.codeCheck(deCode);
                codeLabel = "Not Valid Code. Try again\n";

            } while (deCode.length() != Rules.getCodeLenght() || deCodeCheck != Rules.getCodeLenght());

            System.out.println("Your deCode is Valid");

            Game.reset();
            Game.perfMatches = Game.perfCheck(code, deCode);
            Game.semiMatches = Game.semiCheck(code, deCode);
            Game.incTries();

            Game.updateLog(Game.getTries() + " " + deCode + " " + Game.perfMatches + " " + Game.semiMatches + "\n");

        } while (Game.perfCheck(code, deCode) != Rules.getCodeLenght());

        Game.gameOver(code, deCode);
        Game.restartPrompt();
    }
}
