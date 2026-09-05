package utils;

import dao.FamilyGameDAO;
import dao.MemberDAO;
import dao.PartyGameDAO;
import dao.StrategyGameDAO;

import model.Member;
import model.StrategyGame;
import model.FamilyGame;
import model.PartyGame;

import java.io.BufferedReader;
import java.io.FileReader;


import dao.CardGameDAO;
import model.CardGame;


public class BoardGameFileReader {

    private MemberDAO memberDAO;
    private StrategyGameDAO strategyGameDAO;
    private FamilyGameDAO familyGameDAO;
    private PartyGameDAO partyGameDAO;
    private CardGameDAO cardGameDAO;

    public BoardGameFileReader() {
        memberDAO = new MemberDAO();
        strategyGameDAO = new StrategyGameDAO();
        familyGameDAO = new FamilyGameDAO();
        partyGameDAO = new PartyGameDAO();
        cardGameDAO = new CardGameDAO();
    }

    public void readFile(String fileName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            System.out.println("Leser fil: " + fileName);

            int numberOfMembers = Integer.parseInt(reader.readLine());

            System.out.println("Antall medlemmer: " + numberOfMembers);

            for (int i = 0; i < numberOfMembers; i++) {

                int memberID = Integer.parseInt(reader.readLine());
                String name = reader.readLine();
                String address = reader.readLine();
                String phoneNumber = reader.readLine();


                reader.readLine();

                Member member = new Member(memberID, name, address, phoneNumber);

                if (!memberDAO.memberExists(memberID)) {
                    memberDAO.addMember(member);
                } else {
                    System.out.println("Medlem med ID " + memberID + " finnes allerede i databasen.");
                }
            }

            int numberOfGames = Integer.parseInt(reader.readLine());

            System.out.println();
            System.out.println("Antall spill: " + numberOfGames);
            System.out.println();

            for (int i = 0; i < numberOfGames; i++) {

                String gameName = reader.readLine();
                String description = reader.readLine();
                int yearPublished = Integer.parseInt(reader.readLine());
                int ownerID = Integer.parseInt(reader.readLine());
                String gameType = reader.readLine();

                System.out.println("Spill " + (i + 1));
                System.out.println("Navn: " + gameName);
                System.out.println("Beskrivelse: " + description);
                System.out.println("År: " + yearPublished);
                System.out.println("OwnerID: " + ownerID);
                System.out.println("Type: " + gameType);

                if (gameType.equals("STRATEGY")) {

                    int playTime = Integer.parseInt(reader.readLine());
                    int complexity = Integer.parseInt(reader.readLine());
                    String strategyType = reader.readLine();

                    StrategyGame game = new StrategyGame(
                            0,
                            gameName,
                            description,
                            yearPublished,
                            null,
                            ownerID,
                            playTime,
                            complexity,
                            strategyType
                    );

                    if (!strategyGameDAO.strategyGameExists(gameName)) {
                        strategyGameDAO.addStrategyGame(game);
                    } else {
                        System.out.println("StrategyGame '" + gameName + "' finnes allerede.");
                    }

                } else if (gameType.equals("FAMILY")) {

                    int recommendedAge = Integer.parseInt(reader.readLine());
                    boolean cooperative = Boolean.parseBoolean(reader.readLine());

                    FamilyGame game = new FamilyGame(
                            0,
                            gameName,
                            description,
                            yearPublished,
                            null,
                            ownerID,
                            recommendedAge,
                            cooperative
                    );

                    if (!familyGameDAO.familyGameExists(gameName)) {
                        familyGameDAO.addFamilyGame(game);
                    } else {
                        System.out.println("FamilyGame '" + gameName + "' finnes allerede.");
                    }

                } else if (gameType.equals("PARTY")) {

                    int minimumPlayers = Integer.parseInt(reader.readLine());
                    boolean requiresMobileApp = Boolean.parseBoolean(reader.readLine());

                    PartyGame game = new PartyGame(
                            0,
                            gameName,
                            description,
                            yearPublished,
                            null,
                            ownerID,
                            minimumPlayers,
                            requiresMobileApp
                    );

                    if (!partyGameDAO.partyGameExists(gameName)) {
                        partyGameDAO.addPartyGame(game);
                    } else {
                        System.out.println("PartyGame '" + gameName + "' finnes allerede.");
                    }

                }
                else if (gameType.equals("CARD")) {

                    int numberOfCards = Integer.parseInt(reader.readLine());
                    boolean collectible = Boolean.parseBoolean(reader.readLine());

                    CardGame game = new CardGame(
                            0,
                            gameName,
                            description,
                            yearPublished,
                            null,
                            ownerID,
                            numberOfCards,
                            collectible
                    );

                    if (!cardGameDAO.cardGameExists(gameName)) {
                        cardGameDAO.addCardGame(game);
                    } else {
                        System.out.println("CardGame '" + gameName + "' finnes allerede.");
                    }

                }

                reader.readLine();

                System.out.println();

            }

        } catch (Exception e) {

            System.out.println();
            System.out.println("Filen inneholder feil og må rettes før den kan leses.");
            System.out.println("Feilmelding: " + e.getMessage());

        }

    }

}