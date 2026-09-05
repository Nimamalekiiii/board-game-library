DROP DATABASE IF EXISTS BoardGameLibraryDB;
CREATE DATABASE BoardGameLibraryDB;
USE BoardGameLibraryDB;

CREATE TABLE Member (
    MemberID INT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Address VARCHAR(255) NOT NULL,
    PhoneNumber VARCHAR(20) NOT NULL
);

CREATE TABLE StrategyGame (
    ItemID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Description VARCHAR(255) NOT NULL,
    YearPublished INT NOT NULL,
    RentOutDate DATE,
    OwnerID INT NOT NULL,

    PlayTimeMinutes INT NOT NULL,
    ComplexityLevel INT NOT NULL,
    StrategyType VARCHAR(255) NOT NULL,

    FOREIGN KEY (OwnerID) REFERENCES Member(MemberID)
);

CREATE TABLE PartyGame (
    ItemID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Description VARCHAR(255) NOT NULL,
    YearPublished INT NOT NULL,
    RentOutDate DATE,
    OwnerID INT NOT NULL,

    MinimumPlayers INT NOT NULL,
    RequiresMobileApp BOOLEAN NOT NULL,

    FOREIGN KEY (OwnerID) REFERENCES Member(MemberID)
);

CREATE TABLE FamilyGame (
    ItemID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Description VARCHAR(255) NOT NULL,
    YearPublished INT NOT NULL,
    RentOutDate DATE,
    OwnerID INT NOT NULL,

    RecommendedAge INT NOT NULL,
    Cooperative BOOLEAN NOT NULL,

    FOREIGN KEY (OwnerID) REFERENCES Member(MemberID)
);