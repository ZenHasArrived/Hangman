import java.util.Random;
public class Hangman {
    String secretWord, userGuess;
    Random rnd = new Random();
    int rndNum;

    public Hangman(){

        rndNum = rnd.nextInt(5)+1;
        if(rndNum==1){
            secretWord="pokemon";
        }
        else if(rndNum==2){
            secretWord="frieren";
        }
        else if(rndNum==3){
            secretWord="sakuya";
        }
        else if(rndNum==4){
            secretWord="cybersecurity";
        }
        else{
            secretWord="gentoo";
        }

        userGuess = secretWord.replaceAll(".","_");

    }

    public String getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public String getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(String userGuess) {
        this.userGuess = userGuess;
    }

}
