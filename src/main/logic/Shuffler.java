package main.logic;

import main.model.Card;
import main.model.Deck;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Shuffler {

    /**
     * Power shuffle
     * @param deckOfCards
     * @param numberOfPiles
     * @param isRandomPickup
     */
    Deck powerShuffle(Deck deckOfCards, int numberOfPiles, boolean isRandomPickup){
        List<Deck> stacks = new ArrayList<>();

        //initialize decks
        for (int i = 0; i < numberOfPiles; i++) {
            stacks.add(new Deck());
        }

        // pop off cards into the stacks(decks)
        for (int i = 0; i < numberOfPiles; i++) {
            Card card = deckOfCards.popTopCard();
            stacks.get(i).addCard(card);
        }

        if(isRandomPickup){
            return stackDecksRandomly(stacks);
        }

        return stackDecks(stacks);
    }

    // TODO figure out other ways to shuffle


    /**
     * Stack decks together - helper method
     * @param stackOfDecks
     * @return deck
     */
    Deck stackDecks(List<Deck> stackOfDecks){
        Deck combinedDeck = new Deck();

        for (int i = 0; i < stackOfDecks.size(); i++) {
            combinedDeck.plus(stackOfDecks.get(i));
        }

        return combinedDeck;
    }

    /**
     * Stack decks together randomly - helper method
     * @param stackOfDecks
     * @return deck
     */
    Deck stackDecksRandomly(List<Deck> stackOfDecks){
        Deck combinedDeck = new Deck();

        for (int i = 0; i < stackOfDecks.size(); i++) {
            if (!stackOfDecks.isEmpty()){
                combinedDeck.plus(stackOfDecks.remove(i));
            }
        }

        return combinedDeck;
    }
}
