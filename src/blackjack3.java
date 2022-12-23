import java.util.Scanner;

public class blackjack3{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int result = 0;
        int userTotal = 0;
        int dealerTotal = 0;
        String choice;

        System.out.println("Welcome to Black Jack!");

        //deal first two cards to user
        userTotal += dealCard();
        userTotal += dealCard();
        System.out.println("Your total is: " + userTotal);

        //deal first two cards to dealer
        dealerTotal += dealCard();
        dealerTotal += dealCard();
        System.out.println("Dealer's total is: " + dealerTotal);

        //let user decide to hit or stay
        System.out.println("Hit or stay? (h/s)");
        choice = input.nextLine();

        //user hits
        while (choice.equals("h") && userTotal < 21){
            userTotal += dealCard();
            System.out.println("Your total is: " + userTotal);

            if (userTotal < 21){
                System.out.println("Hit or stay? (h/s)");
                choice = input.nextLine();
            }
            else if (userTotal == 21){
                System.out.println("You got Blackjack!");
                break;
            }
            else {
                System.out.println("You busted!");
                break;
            }
        }

        //user stays, dealer hits
        while (dealerTotal <= 17){
            dealerTotal += dealCard();
            System.out.println("Dealer's total is: " + dealerTotal);

            if (dealerTotal > 21){
                System.out.println("Dealer busted!");
                break;
            }
        }

        //determine winner
        if (userTotal == 21 || (userTotal < 21 && dealerTotal > 21) || (userTotal < 21 && userTotal > dealerTotal)){
            System.out.println("You win!");
        }
        else if (userTotal == dealerTotal){
            System.out.println("It's a tie!");
        }
        else {
            System.out.println("Dealer wins!");
        }

        System.out.println("Thanks for playing!");
    }

    public static int dealCard(){
        int card = (int)(Math.random() * 11) + 1;
        return card;
    }
}