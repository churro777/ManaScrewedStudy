package main.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Deck {
    private Deque<Card> cards = new ArrayDeque<>();
    private int numOfLands;

    /**
     * DEFAULT CONSTRUCTOR
     */
    public Deck() {
        super();
    }

    /**
     * NON-DEFAULT CONSTRUCTOR
     * - input how many lands and nonLands to put in
     * @param numOfLands
     * @param numOfNonLands
     */
    public Deck(int numOfLands, int numOfNonLands) {
        setNumOfLands(numOfLands);
        addCardLot(new LandCard(), numOfLands);
        addCardLot(new NonLandCard(), numOfNonLands);
    }

    /**
     * Add a card to the deque
     * @param card
     */
    void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Get and remove the top card
     * @return
     */
    Card popTopCard() {
        return cards.pop();
    }

    /**
     * Add an X amount of cards
     * @param cardType
     * @param amountOfCards
     */
    void addCardLot(Card cardType, int amountOfCards) {
        for (int i = 0; i < amountOfCards; i++) {
            addCard(cardType);
        }
    }

    /**
     * Remove X cards from the deck
     * @param amountOfCards
     */
    void removeCardLot(int amountOfCards){
        for (int i = 0; i < amountOfCards; i++) {
            cards.pop();
        }
    }

    /**
     * Check how many Non lands are at the top of the deck
     * @return How many non lands are at the top
     */
    int numOfNonLandsAtTop() {
        int numOfNonLands = 0;

        Deque<Card> tempCards = cards;

        while (tempCards.size() > 0) {
            Card card = tempCards.pop();

            if (card.isNonLand()) {
                numOfNonLands++;
            }
            if (card.isLand()) {
                return numOfNonLands;
            }
        }
        return numOfNonLands;
    }

    /**
     * Check how many Lands are at the top of the deck
     * @return How many Lands are at the top
     */
    int numOfLandsAtTop() {
        int numOfLands = 0;

        Deque<Card> tempCards = cards;

        while (tempCards.size() > 0) {
            Card card = tempCards.pop();

            if (card.isLand()) {
                numOfLands++;
            }
            if (card.isNonLand()) {
                return numOfLands;
            }
        }
        return numOfLands;
    }

    /**
     * Get the amount of lands in the deck
     * @return amount
     */
    public int getNumOfLands() {
        return numOfLands;
    }

    /**
     * Set amount of lands in the deck
     * @param numOfLands
     */
    public void setNumOfLands(int numOfLands) {
        this.numOfLands = numOfLands;
    }
}
