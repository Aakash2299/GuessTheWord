package game;

import java.util.Scanner;

public class GuessTheWord {
    
    private boolean play = true;
    private Words randomWords = new Words();
    private Scanner scanner = new Scanner(System.in);
    private int rounds = 5;
    private char lastRound;

    public void start(){
        do{
            showWord();
            getInput();
            checkInput();

        }while(play);
    }

    public void showWord(){
        System.out.println(rounds + " tries left.");
        System.out.println(randomWords);
    }

    public void getInput(){
        System.out.print("Enter the charcter : ");
        String userGuess = scanner.nextLine();
        lastRound = userGuess.charAt(0);

    }

    public void checkInput(){

        boolean rightGuess = randomWords.guess(lastRound);
        
        if(rightGuess){
            if(randomWords.isGuessedRight()){
                System.out.println("\nCongratulation! You Won");
                System.out.println("The word is : " + randomWords + "\n\n");
                play = false;
            }
        }
        else{
            rounds--;

            if(rounds == 0){
                System.out.println("\nGame Over!!!!, Try again later.\n\n");
                play = false;
            }
        }

    }

    public void end() {
        scanner.close();
    }

}
