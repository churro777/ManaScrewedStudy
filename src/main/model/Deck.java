package main.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Deck {
    /**
     * First card is the bottom and last card is the top
     * [x,o,o,o,x,o,x,o,x,o]
     * first/bottom      last/top
     */
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
    public void addCard(Card card) {
        cards.addLast(card);
    }

    /**
     * Get and remove the top card
     * @return
     */
    public Card popTopCard() {
        return cards.removeLast();
    }

    /**
     * First card is the bottom..last is the top
     * @return bottom (or first) card in the deck
     */
    public Card popBottomCard() { return cards.removeFirst();}

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
    public void removeCardLot(int amountOfCards){
        for (int i = 0; i < amountOfCards; i++) {
            cards.removeLast();
        }
    }

    /**
     * Check how many Non lands are at the top of the deck
     * @return How many non lands are at the top
     */
    public int numOfNonLandsAtTop() {
        int numOfNonLands = 0;

        Deque<Card> tempCards = cards;

        while (tempCards.size() > 0) {
            Card card = tempCards.removeLast();

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
    public int numOfLandsAtTop() {
        int numOfLands = 0;

        Deque<Card> tempCards = cards;

        while (tempCards.size() > 0) {
            Card card = tempCards.removeLast();

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

    /**
     * get the amount of cards in the deck
     * @return size
     */
    public int size(){
        return cards.size();
    }

    /**
     * Add a deck to this deck object
     * @param secondDeck
     */
    public void plus(Deck secondDeck) {

        for (int i = 0; i < secondDeck.size(); i++) {
            addCard(secondDeck.popBottomCard());
        }
    }
}
