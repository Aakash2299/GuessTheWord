package game;

import java.util.Random;

public class Words {
    
    private String[] randomWords = {"animals", "admission","beach","basket","bark","adjust","additional","action",
                            "acknowledgement","achievement","accomplish","absence","abroad","tactful","sacrifice",
                            "radiation","nomination","legitimate","impress","height","glad","fault","effort","depict",
                            "depression","chain","ceremony","bench","belt","adolescent"};

    private String selectWord;
    private Random random = new Random();
    private char[] letters;

    public Words(){
        selectWord = randomWords[random.nextInt(randomWords.length)];
        letters = new char[selectWord.length()];
    }

    public String toString() {

        StringBuilder text = new StringBuilder();

        for( char letter : letters){
            text.append(letter == '\u0000' ? '-' : letter);
            text.append(' ');
        }

        return text.toString();
    }


    public boolean isGuessedRight(){

        for( char letter : letters){
            if(letter == '\u0000'){
                return false;
            }
        }
        return true;
    }

    public boolean guess(char letter) {

        boolean gussedRight = false;

        for(int i = 0 ; i < selectWord.length() ; i++){
            if(letter == selectWord.charAt(i)){
                letters[i] = letter;
                gussedRight = true;
            }
        }
        return gussedRight;
    }

}
