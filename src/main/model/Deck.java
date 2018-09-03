package main.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Deck {
    Deque<Card> cards = new ArrayDeque<>();

    void addCard(Card card){
        cards.add(card);
    }

    Card removeTopCard(){
        return cards.pop();
    }

    void addCardLot(Card cardType, int amountOfCards){
        for (int i = 0; i < amountOfCards; i++) {
            addCard(cardType);
        }
    }

    int numOfNonLandsAtTop(){
        int numOfNonLands = 0;

        Deque<Card> tempCards = cards;

        while(tempCards.size() > 0){
            Card card = tempCards.pop();

            if (card.isNonLand()){
                numOfNonLands++;
            }
            if (card.isLand()){
                return numOfNonLands;
            }
        }
        return  numOfNonLands;
    }

    int numOfLandsAtTop(){
        int numOfLands = 0;

        Deque<Card> tempCards = cards;

        while(tempCards.size() > 0){
            Card card = tempCards.pop();

            if (card.isLand()){
                numOfLands++;
            }
            if (card.isNonLand()){
                return numOfLands;
            }
        }
        return  numOfLands;
    }
}
