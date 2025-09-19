import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * @modifier Bharath_Vinod (991806024)
 * @date 2025-09-19
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random();

        // Step 1: Fill the magicHand array with 7 random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            
            // Generate a random card value between 1 and 13
            int randomValue = random.nextInt(13) + 1;
            c.setValue(randomValue);

            // Generate a random suit index between 0 and 3
            int randomSuitIndex = random.nextInt(4);
            c.setSuit(Card.SUITS[randomSuitIndex]);
            
            // Add the new random card to the hand
            magicHand[i] = c;
        }

        // Step 2: Ask the user to pick a card
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a card value (1-13): ");
        int userValue = input.nextInt();
        System.out.print("Enter a suit (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = input.next();
        
        // Create the user's card object
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        // Step 3: Search the magicHand for the user's card
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equals(userCard.getSuit())) {
                found = true;
                break; // Stop searching once a match is found
            }
        }

        // Step 4: Report the result
        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand!");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
        
        input.close();
    }
}