//package Game3;
import java.util.Random;

public class Deck {
    private Card[] cards;
    private int cardsInDeck;

    // constructor of Deck
    public Deck() {
        this.cards = new Card[28];
    }

    // reset the whole Deck
    public void reset() {
        Card.MColor[] colors = Card.MColor.values();
        cardsInDeck = 0;

        // Fill up the deck with the specified cards
        for (Card.MColor color : colors) {
            int[] values = getCardValues(color);
            for (int value : values) {
                cards[cardsInDeck] = new Card(color, value);
                cardsInDeck++;
            }
        }
        shuffleDeck();
    }

    // assign the values for each color
    private int[] getCardValues(Card.MColor color) {
        // Define the card values for each color
        switch (color) {
            case YELLOW:
                return new int[] { 18, 9, 3, 15, 12, 4, 7 };
            case BLUE:
                return new int[] { 3, 19, 10, 9, 13, 6, 8 };
            case ORANGE:
                return new int[] { 7, 5, 1, 14, 4, 11, 20 };
            case PURPLE:
                return new int[] { 17, 10, 6, 8, 2, 5, 16 };
            default:
                return new int[] {};
        }
    }

    // shuffle
    public void shuffleDeck() {
        Random rand = new Random();
        for (int i = cardsInDeck - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            // Swap cards[i] and cards[j]
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    public Card dealCard() {
        if (cardsInDeck > 0) {
            return cards[--cardsInDeck];
        } else {
            // Handle case when the deck is empty
            System.out.println("The deck is empty. Cannot deal more cards.");
            return null;
        }
    }

    // deal cards to players (2 players, 3 cards for each)
    
    // display the cards in player hand
    

    // Method to check if the deck is empty
    public boolean isDeckEmpty() {
        return cardsInDeck == 0;
    }

}
