package main.model;

public class NonLandCard implements Card {
    @Override
    public void displayCard() {
        System.out.println("Not land card");
    }

    @Override
    public boolean isLand() {
        return false;
    }

    @Override
    public boolean isNonLand() {
        return true;
    }
}