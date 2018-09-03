package main.model;

public class CommanderDeck extends Deck {
    private String commander;

    public CommanderDeck(String commanderName){
        commander = commanderName;
    }

    @Override
    void addCard(Card card) {
        super.addCard(card);
    }

    @Override
    Card removeTopCard() {
        return super.removeTopCard();
    }


}
