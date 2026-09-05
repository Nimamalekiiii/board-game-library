package model;

import java.time.LocalDate;

public class FamilyGame extends BoardGame {

    private int recommendedAge;
    private boolean cooperative;

    public FamilyGame(int itemID, String name, String description,
                      int yearPublished, LocalDate rentOutDate, int ownerID,
                      int recommendedAge, boolean cooperative) {

        super(itemID, name, description, yearPublished, rentOutDate, ownerID);

        this.recommendedAge = recommendedAge;
        this.cooperative = cooperative;
    }

    public int getRecommendedAge() {
        return recommendedAge;
    }

    public void setRecommendedAge(int recommendedAge) {
        this.recommendedAge = recommendedAge;
    }

    public boolean isCooperative() {
        return cooperative;
    }

    public void setCooperative(boolean cooperative) {
        this.cooperative = cooperative;
    }
}