
package model;

import java.time.LocalDate;

public class CardGame extends BoardGame {

    private int numberOfCards;
    private boolean collectible;

    public CardGame(
            int itemID,
            String name,
            String description,
            int yearPublished,
            LocalDate rentOutDate,
            int ownerID,
            int numberOfCards,
            boolean collectible
    ) {

        super(itemID, name, description, yearPublished, rentOutDate, ownerID);

        this.numberOfCards = numberOfCards;
        this.collectible = collectible;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    public boolean isCollectible() {
        return collectible;
    }

    public void setCollectible(boolean collectible) {
        this.collectible = collectible;
    }

}