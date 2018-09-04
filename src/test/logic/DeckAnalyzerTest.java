package test.logic;

import com.sun.tools.javac.util.Assert;
import main.logic.DeckAnalyzer;
import main.model.Deck;

import static org.junit.jupiter.api.Assertions.*;

class DeckAnalyzerTest {

    DeckAnalyzer deckAnalyzer = new DeckAnalyzer();

    @org.junit.jupiter.api.Test
    void analyzeDeck() {
        Deck testDeck = new Deck(35, 65);
        Double score = deckAnalyzer.analyzeDeck(testDeck);

        Assert.check(score == 1.0);
    }

    @org.junit.jupiter.api.Test
    void searchForManaClumps() {
        // setup deck
        Deck testDeck = new Deck(35, 65);

        int maxClump = deckAnalyzer.searchForManaClumps(testDeck);

        Assert.check(maxClump == 35);
    }
}