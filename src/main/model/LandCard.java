package main.model;

public class LandCard implements Card {
    private String landType;

    public LandCard(){
        super();
    }

    public LandCard(String landType){
        super();
        this.landType = landType;
    }

    @Override
    public void displayCard() {
        System.out.println(landType);
    }

    @Override
    public boolean isLand() {
        return true;
    }

    @Override
    public boolean isNonLand() {
        return false;
    }

    public String getLandType() {
        return landType;
    }

    public void setLandType(String landType) {
        this.landType = landType;
    }
}
