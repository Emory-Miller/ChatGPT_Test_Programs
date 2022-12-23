import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// enum of suits and values
enum CardSuits {
    SPADES,
    HEARTS,
    DIAMONDS,
    CLUBS
}

enum CardValues {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

public class Blackjack2 {
    // main method
    public static void main(String[] args) {
        // create a new deck
        ArrayList<Card> deck = new ArrayList<>();
        for (CardSuits suit : CardSuits.values()) {
            for (CardValues value : CardValues.values()) {
                Card card = new Card(suit, value);
                deck.add(card);
            }
        }

        // shuffle the deck
        Collections.shuffle(deck);

        // deal two cards to the player
        ArrayList<Card> playerCards = new ArrayList<>();
        playerCards.add(deck.remove(0));
        playerCards.add(deck.remove(0));

        // deal two cards to the dealer
        ArrayList<Card> dealerCards = new ArrayList<>();
        dealerCards.add(deck.remove(0));
        dealerCards.add(deck.remove(0));

        // print out the initial cards
        System.out.println("Dealer has: ");
        System.out.println(dealerCards.get(0));
        System.out.println("And one unseen card");
        System.out.println();
        System.out.println("You have: ");
        System.out.println(playerCards.get(0));
        System.out.println(playerCards.get(1));

        // prompt the player to hit or stay
        boolean stay = false;
        Scanner userInput = new Scanner(System.in);
        while (!stay) {
            System.out.println("Hit or Stay? (H/S): ");
            String hitOrStay = userInput.nextLine();
            if (hitOrStay.equalsIgnoreCase("H")) {
                playerCards.add(deck.remove(0));
                System.out.println("You draw a: ");
                System.out.println(playerCards.get(playerCards.size() - 1));
            } else if (hitOrStay.equalsIgnoreCase("S")) {
                stay = true;
            }
        }

        // print out the player's cards
        System.out.println("Your cards are: ");
        for (Card card : playerCards) {
            System.out.println(card);
        }
        System.out.println();

        // calculate the value of the player's hand
        int playerTotal = calculateHand(playerCards);
        System.out.println("Your hand is worth: " + playerTotal);

        // reveal dealer's cards
        System.out.println("Dealer reveals their cards: ");
        for (Card card : dealerCards) {
            System.out.println(card);
        }
        System.out.println();

        // calculate the value of the dealer's hand
        int dealerTotal = calculateHand(dealerCards);
        System.out.println("Dealer's hand is worth: " + dealerTotal);

        // check for winner
        if (playerTotal > dealerTotal && playerTotal <= 21) {
            System.out.println("You win!");
        } else if (playerTotal > 21) {
            System.out.println("You bust!");
        } else if (dealerTotal > playerTotal && dealerTotal <= 21) {
            System.out.println("Dealer wins!");
        } else if (dealerTotal > 21) {
            System.out.println("Dealer busts!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    // calculate the value of a hand of cards
    public static int calculateHand(ArrayList<Card> cards) {
        int handValue = 0;
        int aceCount = 0;
        for (Card card : cards) {
            switch (card.value) {
                case ACE:
                    aceCount++;
                    handValue += 11;
                    break;
                case TWO:
                    handValue += 2;
                    break;
                case THREE:
                    handValue += 3;
                    break;
                case FOUR:
                    handValue += 4;
                    break;
                case FIVE:
                    handValue += 5;
                    break;
                case SIX:
                    handValue += 6;
                    break;
                case SEVEN:
                    handValue += 7;
                    break;
                case EIGHT:
                    handValue += 8;
                    break;
                case NINE:
                    handValue += 9;
                    break;
                case TEN:
                case JACK:
                case QUEEN:
                case KING:
                    handValue += 10;
                    break;
            }
        }

        // check if ace should be counted as 11 or 1
        while (handValue > 21 && aceCount > 0) {
            handValue -= 10;
            aceCount--;
        }

        return handValue;
    }

}

// class for a card
class Card {
    CardSuits suit;
    CardValues value;

    Card(CardSuits suit, CardValues value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}