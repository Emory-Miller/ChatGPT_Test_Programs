import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        // set up the game
        String[] wordList = {"hello", "world", "programming"};
        String word = wordList[(int)(Math.random() * wordList.length)];
        String hiddenWord = createHiddenWord(word);
        int numGuesses = 0;
        int maxGuesses = word.length() + 2;
        boolean isGameOver = false;
        Scanner input = new Scanner(System.in);

        // game loop
        while (!isGameOver) {
            displayHangman(numGuesses);
            System.out.println(hiddenWord);
            System.out.println("Guess a letter:");
            char guess = input.next().charAt(0);
            hiddenWord = updateHiddenWord(word, hiddenWord, guess);
            if (word.equals(hiddenWord)) {
                System.out.println("You win!");
                isGameOver = true;
            }
            else {
                numGuesses++;
                if (numGuesses == maxGuesses) {
                    System.out.println("You lose!");
                    isGameOver = true;
                }
            }
        }
    }

    // Helper methods

    public static String createHiddenWord(String word) {
        String hiddenWord = "";
        for (int i = 0; i < word.length(); i++) {
            hiddenWord += "_";
        }
        return hiddenWord;
    }

    public static String updateHiddenWord(String word, String hiddenWord, char guess) {
        String updatedHiddenWord = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                updatedHiddenWord += guess;
            }
            else {
                updatedHiddenWord += hiddenWord.charAt(i);
            }
        }
        return updatedHiddenWord;
    }

    public static void displayHangman(int numGuesses) {
        switch (numGuesses) {
            case 0:
                System.out.println("   ____");
                System.out.println("  |    |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 1:
                System.out.println("   ____");
                System.out.println("  |    |");
                System.out.println("  |    O");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 2:
                System.out.println("   ____");
                System.out.println("  |    |");
                System.out.println("  |    O");
                System.out.println("  |    |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 3:
                System.out.println("   ____");
                System.out.println("  |    |");
                System.out.println("  |    O");
                System.out.println("  |    |\\");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 4:
                System.out.println("   ____");
                System.out.println("  |    |");
                System.out.println("  |    O");
                System.out.println("  |   /|\\");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 5:
                System.out.println("   ____");
                System.out.println("  |    |");
                System.out.println("  |    O");
                System.out.println("  |   /|\\");
                System.out.println("  |    |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 6:
                System.out.println("   ____");
                System.out.println("  |    |");
                System.out.println("  |    O");
                System.out.println("  |   /|\\");
                System.out.println("  |    |");
                System.out.println("  |   / \\");
                System.out.println("__|__");
                break;
            default:
                System.out.println("Something went wrong...");
        }
    }
}