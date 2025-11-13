import java.util.Scanner; //temp till being switch with JOptionPane
public class PlayGame {
    public static int gamesWon=0, gamesLost=0;

    public static void processGuesses(Hangman aGame){
        int secretWordLength = aGame.getSecretWord().length();
        int chances = secretWordLength*3;
        int usedChances = 0;
        int loc; //Location of character
        Scanner scnr = new Scanner(System.in);

        while(usedChances<chances && !(aGame.getSecretWord().equalsIgnoreCase(aGame.getUserGuess()))){ //While you still have chances and the user guess isn't the secret word

            usedChances++;
            System.out.print("Guess a letter: ");
            String letterGuess = scnr.next(); //letterGuess is equal to the first character inputted

            loc = -1;

            do{
                loc++; //increment loc
                loc = aGame.getSecretWord().indexOf(letterGuess,loc); //look for index for letter guessed with offset of loc, set loc to that

                if(loc>=0){
                    String firstHalf = aGame.userGuess.substring(0,loc); //Get the underscores up to the letter index
                    String concatResult = firstHalf + letterGuess; //add the letter to the index it was found at
                    String latterHalf = aGame.userGuess.substring(loc+1); //get the half after the letter
                    aGame.setUserGuess(concatResult+latterHalf); //set userGuess to the entire thing combined
                }
            }while(loc>-1); //Run the loop while indexOf doesn't return a -1, meaning it didn't find anything
            System.out.println(aGame.getUserGuess()); //Print the userGuess after iterating through the do while


        }

        System.out.println(aGame); //Print aGame after loop finishes

    }

    public static void determineWinner(Hangman aGame){
        Scanner scnr = new Scanner(System.in);

        if(aGame.getSecretWord().equalsIgnoreCase(aGame.getUserGuess())){
            System.out.println("You won! congratulations!");
            gamesWon++;
        }
        else{
            System.out.print("Final guess: ");
            String finalGuess = scnr.nextLine();
            if(finalGuess.equalsIgnoreCase(aGame.getSecretWord())){
                System.out.println("You won! congratulations!");
                gamesWon++;
            }
            else{
                System.out.println("You lost, better luck next time!");
                gamesLost++;
            }
        }

    }

    public static void summarize(){

        System.out.println("You won " + gamesWon + " times");
        System.out.println("You lost " + gamesLost + " times");
        System.out.println("Thank you for playing!");

    }

    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        String yesNo;
        boolean playAgain = true;

        do{
            Hangman aGame = new Hangman(); //Create new Hangman
            processGuesses(aGame); //Process the guesses for the new hang man
            determineWinner(aGame); //Determine if the player won or lost
            System.out.print("Play again? (yes/no): "); //Ask to play again
            yesNo = scnr.next();
            if(yesNo.equals("no")){
                playAgain=false;
            }
        }while(playAgain);
        summarize();


    }

}
