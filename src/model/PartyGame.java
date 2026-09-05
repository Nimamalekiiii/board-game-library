package model;

import java.time.LocalDate;

public class PartyGame extends BoardGame {

    private int minimumPlayers;
    private boolean requiresMobileApp;

    public PartyGame(int itemID, String name, String description,
                     int yearPublished, LocalDate rentOutDate, int ownerID,
                     int minimumPlayers, boolean requiresMobileApp) {

        super(itemID, name, description, yearPublished, rentOutDate, ownerID);

        this.minimumPlayers = minimumPlayers;
        this.requiresMobileApp = requiresMobileApp;
    }

    public int getMinimumPlayers() {
        return minimumPlayers;
    }

    public void setMinimumPlayers(int minimumPlayers) {
        this.minimumPlayers = minimumPlayers;
    }

    public boolean isRequiresMobileApp() {
        return requiresMobileApp;
    }

    public void setRequiresMobileApp(boolean requiresMobileApp) {
        this.requiresMobileApp = requiresMobileApp;
    }
}