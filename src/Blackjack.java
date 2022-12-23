import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Setting up the deck of cards
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        ArrayList<String> deck = new ArrayList<String>();
        for (String suit : suits) {
            for (String value : values) {
                deck.add(value + " of " + suit);
            }
        }
        Collections.shuffle(deck);

        // Initializing player's and dealer's hands
        ArrayList<String> playerHand = new ArrayList<String>();
        ArrayList<String> dealerHand = new ArrayList<String>();

        // Dealing initial cards to player and dealer
        playerHand.add(deck.get(0));
        dealerHand.add(deck.get(1));
        playerHand.add(deck.get(2));
        dealerHand.add(deck.get(3));
        deck.remove(0);
        deck.remove(0);
        deck.remove(0);
        deck.remove(0);

        // Displaying player's and dealer's hands
        System.out.println("Your hand:");
        for (String card : playerHand)
            System.out.println(card);
        System.out.println("\nDealer's hand:");
        System.out.println(dealerHand.get(0));
        System.out.println("\nOne card hidden");

        // Calculating initial hand values
        int playerTotal = 0;
        int dealerTotal = 0;
        for (String card : playerHand) {
            if (card.startsWith("2") || card.startsWith("3") || card.startsWith("4") || card.startsWith("5") ||
                    card.startsWith("6") || card.startsWith("7") || card.startsWith("8") || card.startsWith("9") ||
                    card.startsWith("10"))
                playerTotal += Integer.parseInt(card.substring(0, card.indexOf(" ")));
            else if (card.startsWith("Jack") || card.startsWith("Queen") || card.startsWith("King"))
                playerTotal += 10;
            else if (card.startsWith("Ace"))
                playerTotal += 11;
        }
        for (String card : dealerHand) {
            if (card.startsWith("2") || card.startsWith("3") || card.startsWith("4") || card.startsWith("5") ||
                    card.startsWith("6") || card.startsWith("7") || card.startsWith("8") || card.startsWith("9") ||
                    card.startsWith("10"))
                dealerTotal += Integer.parseInt(card.substring(0, card.indexOf(" ")));
            else if (card.startsWith("Jack") || card.startsWith("Queen") || card.startsWith("King"))
                dealerTotal += 10;
            else if (card.startsWith("Ace"))
                dealerTotal += 11;
        }
        System.out.println("\nYour total is " + playerTotal);

        // Player's turn
        System.out.println("\nWould you like to \"hit\" or \"stay\"?");
        String playerMove = scanner.nextLine();
        while (playerMove.equalsIgnoreCase("hit")) {
            playerHand.add(deck.get(0));
            deck.remove(0);
            System.out.println("\nYour hand:");
            for (String card : playerHand)
                System.out.println(card);
            playerTotal = 0;
            for (String card : playerHand) {
                if (card.startsWith("2") || card.startsWith("3") || card.startsWith("4") || card.startsWith("5") ||
                        card.startsWith("6") || card.startsWith("7") || card.startsWith("8") || card.startsWith("9") ||
                        card.startsWith("10"))
                    playerTotal += Integer.parseInt(card.substring(0, card.indexOf(" ")));
                else if (card.startsWith("Jack") || card.startsWith("Queen") || card.startsWith("King"))
                    playerTotal += 10;
                else if (card.startsWith("Ace") && playerTotal + 11 <= 21)
                    playerTotal += 11;
                else if (card.startsWith("Ace") && playerTotal + 11 > 21)
                    playerTotal += 1;
            }
            if (playerTotal > 21) {
                System.out.println("\nYour total is " + playerTotal);
                System.out.println("\nYou bust!");
                break;
            } else
                System.out.println("\nYour total is " + playerTotal);
            if (playerTotal == 21)
                break;
            System.out.println("\nWould you like to \"hit\" or \"stay\"?");
            playerMove = scanner.nextLine();
        }

        // Dealer's turn
        while (dealerTotal < 17) {
            dealerHand.add(deck.get(0));
            deck.remove(0);
            dealerTotal = 0;
            for (String card : dealerHand) {
                if (card.startsWith("2") || card.startsWith("3") || card.startsWith("4") || card.startsWith("5") ||
                        card.startsWith("6") || card.startsWith("7") || card.startsWith("8") || card.startsWith("9") ||
                        card.startsWith("10"))
                    dealerTotal += Integer.parseInt(card.substring(0, card.indexOf(" ")));
                else if (card.startsWith("Jack") || card.startsWith("Queen") || card.startsWith("King"))
                    dealerTotal += 10;
                else if (card.startsWith("Ace") && dealerTotal + 11 <= 21)
                    dealerTotal += 11;
                else if (card.startsWith("Ace") && dealerTotal + 11 > 21)
                    dealerTotal += 1;
            }
        }

        // Results
        System.out.println("\nDealer's hand:");
        for (String card : dealerHand)
            System.out.println(card);
        System.out.println("\nDealer's total is " + dealerTotal);
        if (playerTotal > dealerTotal && playerTotal <= 21 || dealerTotal > 21)
            System.out.println("\nYou win!");
        else if (playerTotal == dealerTotal)
            System.out.println("\nIt's a tie!");
        else
            System.out.println("\nYou lose!");
    }
}