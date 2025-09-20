package card;

import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * @modifier BHARATH VINOD
 * @studentnumber [991806024]
 * @date Sept 19, 2025
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        
        // Define the suits array for random selection
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        
        // Loop to fill the magicHand array with random cards
        for (int i=0; i < magicHand.length; i++)
        {
            Card c = new Card();
            // Generate a random value between 1 and 13
            int randomValue = (int) (Math.random() * 13) + 1;
            c.setValue(randomValue);
            
            // Generate a random index for the suits array
            int randomSuitIndex = (int) (Math.random() * suits.length);
            c.setSuit(suits[randomSuitIndex]);
            
            magicHand[i] = c;
        }
        
        // Use a Scanner to get user input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a card value (1-13): ");
        int userValue = input.nextInt();
        System.out.print("Enter a suit (Hearts, Diamonds, Clubs, Spades): ");
        String userSuit = input.next();
        
        // Create the user's card object
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);
        
        boolean found = false;
        // Loop through the magicHand to search for the user's card
        for (Card card : magicHand) {
            // Check if the card's value and suit match
            if (card.getValue() == userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }   
        }
        
        // Report the result to the user
        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
    }
}