package model;

import java.time.LocalDate;

public abstract class BoardGame {

    private int itemID;
    private String name;
    private String description;
    private int yearPublished;
    private LocalDate rentOutDate;
    private int ownerID;

    public BoardGame(int itemID, String name, String description,
                     int yearPublished, LocalDate rentOutDate, int ownerID) {

        this.itemID = itemID;
        this.name = name;
        this.description = description;
        this.yearPublished = yearPublished;
        this.rentOutDate = rentOutDate;
        this.ownerID = ownerID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public LocalDate getRentOutDate() {
        return rentOutDate;
    }

    public void setRentOutDate(LocalDate rentOutDate) {
        this.rentOutDate = rentOutDate;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }
}