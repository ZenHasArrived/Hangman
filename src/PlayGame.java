public class PlayGame {

    public static int gamesWon=0, gamesLost=0;
    public static void main(String[] args){

        Hangman hng = new Hangman();

        System.out.print(hng.getUserGuess());

    }

}
