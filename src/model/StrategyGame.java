package model;

import java.time.LocalDate;

public class StrategyGame extends BoardGame {

    private int playTimeMinutes;
    private int complexityLevel;
    private String strategyType;

    public StrategyGame(int itemID, String name, String description,
                        int yearPublished, LocalDate rentOutDate, int ownerID,
                        int playTimeMinutes, int complexityLevel, String strategyType) {

        super(itemID, name, description, yearPublished, rentOutDate, ownerID);

        this.playTimeMinutes = playTimeMinutes;
        this.complexityLevel = complexityLevel;
        this.strategyType = strategyType;
    }

    public int getPlayTimeMinutes() {
        return playTimeMinutes;
    }

    public void setPlayTimeMinutes(int playTimeMinutes) {
        this.playTimeMinutes = playTimeMinutes;
    }

    public int getComplexityLevel() {
        return complexityLevel;
    }

    public void setComplexityLevel(int complexityLevel) {
        this.complexityLevel = complexityLevel;
    }

    public String getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(String strategyType) {
        this.strategyType = strategyType;
    }
}