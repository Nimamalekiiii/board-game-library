import dao.FamilyGameDAO;
import dao.PartyGameDAO;
import dao.StrategyGameDAO;
import utils.BoardGameFileReader;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BoardGameFileReader fileReader = new BoardGameFileReader();

        StrategyGameDAO strategyGameDAO = new StrategyGameDAO();
        FamilyGameDAO familyGameDAO = new FamilyGameDAO();
        PartyGameDAO partyGameDAO = new PartyGameDAO();

        boolean running = true;

        while (running) {

            System.out.println("===== BOARD GAME LIBRARY =====");
            System.out.println("1. Registrer medlemmer og brettspill");
            System.out.println("2. Se alle brettspill");
            System.out.println("3. Registrer utlån");
            System.out.println("4. Registrer innlevering");
            System.out.println("5. Vis utlånte spill");
            System.out.println("6. Avslutt");
            System.out.print("Velg: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Skriv inn filnavn: ");
                    String fileName = scanner.nextLine();

                    fileReader.readFile(fileName);

                    break;

                case 2:

                    System.out.println("\n===== STRATEGY GAMES =====");
                    strategyGameDAO.showAllStrategyGames();

                    System.out.println("\n===== FAMILY GAMES =====");
                    familyGameDAO.showAllFamilyGames();

                    System.out.println("\n===== PARTY GAMES =====");
                    partyGameDAO.showAllPartyGames();

                    break;

                case 3:

                    System.out.println("Velg spilltype:");
                    System.out.println("1. StrategyGame");
                    System.out.println("2. FamilyGame");
                    System.out.println("3. PartyGame");
                    System.out.print("Valg: ");

                    int gameType = scanner.nextInt();

                    System.out.print("Skriv inn spill-ID: ");
                    int itemID = scanner.nextInt();
                    scanner.nextLine();

                    switch (gameType) {

                        case 1:
                            strategyGameDAO.rentOutGame(itemID);
                            break;

                        case 2:
                            familyGameDAO.rentOutGame(itemID);
                            break;

                        case 3:
                            partyGameDAO.rentOutGame(itemID);
                            break;

                        default:
                            System.out.println("Ugyldig spilltype.");

                    }

                    break;



                case 4:

                    System.out.println("Velg spilltype:");
                    System.out.println("1. StrategyGame");
                    System.out.println("2. FamilyGame");
                    System.out.println("3. PartyGame");
                    System.out.print("Valg: ");

                    int returnType = scanner.nextInt();

                    System.out.print("Skriv inn spill-ID: ");
                    int returnID = scanner.nextInt();
                    scanner.nextLine();

                    switch (returnType) {

                        case 1:
                            strategyGameDAO.returnGame(returnID);
                            break;

                        case 2:
                            familyGameDAO.returnGame(returnID);
                            break;

                        case 3:
                            partyGameDAO.returnGame(returnID);
                            break;

                        default:
                            System.out.println("Ugyldig spilltype.");

                    }

                    break;

                case 5:

                    System.out.println("\n===== UTLÅNTE STRATEGY GAMES =====");
                    strategyGameDAO.showRentedGames();

                    System.out.println("\n===== UTLÅNTE FAMILY GAMES =====");
                    familyGameDAO.showRentedGames();

                    System.out.println("\n===== UTLÅNTE PARTY GAMES =====");
                    partyGameDAO.showRentedGames();

                    break;

                case 6:

                    running = false;
                    System.out.println("Programmet avsluttes.");

                    break;

                default:

                    System.out.println("Ugyldig valg.");

            }

            }



        scanner.close();

    }

}