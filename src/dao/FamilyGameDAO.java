package dao;

import database.DatabaseConnection;
import model.FamilyGame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class FamilyGameDAO {

    public void addFamilyGame(FamilyGame game) {

        String sql = "INSERT INTO FamilyGame (Name, Description, YearPublished, RentOutDate, OwnerID, RecommendedAge, Cooperative) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, game.getName());
            statement.setString(2, game.getDescription());
            statement.setInt(3, game.getYearPublished());

            if (game.getRentOutDate() == null) {
                statement.setNull(4, java.sql.Types.DATE);
            } else {
                statement.setDate(4, Date.valueOf(game.getRentOutDate()));
            }

            statement.setInt(5, game.getOwnerID());
            statement.setInt(6, game.getRecommendedAge());
            statement.setBoolean(7, game.isCooperative());

            statement.executeUpdate();

            System.out.println("FamilyGame lagret.");

        } catch (SQLException e) {
            System.out.println("Feil ved lagring av FamilyGame.");
            e.printStackTrace();
        }

    }

    public boolean familyGameExists(String name) {

        String sql = "SELECT COUNT(*) FROM FamilyGame WHERE Name = ?";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public void showAllFamilyGames() {

        String sql = "SELECT * FROM FamilyGame";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ) {

            while (resultSet.next()) {

                System.out.println("---------------------------");
                System.out.println("ID: " + resultSet.getInt("ItemID"));
                System.out.println("Navn: " + resultSet.getString("Name"));
                System.out.println("Beskrivelse: " + resultSet.getString("Description"));
                System.out.println("År: " + resultSet.getInt("YearPublished"));
                System.out.println("OwnerID: " + resultSet.getInt("OwnerID"));
                System.out.println("Anbefalt alder: " + resultSet.getInt("RecommendedAge"));
                System.out.println("Cooperative: " + resultSet.getBoolean("Cooperative"));

            }

        } catch (SQLException e) {

            System.out.println("Feil ved henting av FamilyGame.");
            e.printStackTrace();

        }

    }
    public void rentOutGame(int itemID) {

        String checkSql = "SELECT RentOutDate FROM FamilyGame WHERE ItemID = ?";
        String updateSql = "UPDATE FamilyGame SET RentOutDate = CURDATE() WHERE ItemID = ?";

        try (
                Connection connection = DatabaseConnection.getConnection()
        ) {

            PreparedStatement checkStatement = connection.prepareStatement(checkSql);
            checkStatement.setInt(1, itemID);

            ResultSet resultSet = checkStatement.executeQuery();

            if (resultSet.next()) {

                if (resultSet.getDate("RentOutDate") != null) {
                    System.out.println("Dette spillet er allerede utlånt.");
                    return;
                }

                PreparedStatement updateStatement = connection.prepareStatement(updateSql);
                updateStatement.setInt(1, itemID);

                int rows = updateStatement.executeUpdate();

                if (rows > 0) {
                    System.out.println("Spillet er nå registrert som utlånt.");
                }

            } else {

                System.out.println("Fant ikke spill med ID " + itemID);

            }

        } catch (SQLException e) {

            System.out.println("Feil ved registrering av utlån.");
            e.printStackTrace();

        }

    }
    public void returnGame(int itemID) {

        String checkSql = "SELECT RentOutDate FROM FamilyGame WHERE ItemID = ?";
        String updateSql = "UPDATE FamilyGame SET RentOutDate = NULL WHERE ItemID = ?";

        try (
                Connection connection = DatabaseConnection.getConnection()
        ) {

            PreparedStatement checkStatement = connection.prepareStatement(checkSql);
            checkStatement.setInt(1, itemID);

            ResultSet resultSet = checkStatement.executeQuery();

            if (resultSet.next()) {

                if (resultSet.getDate("RentOutDate") == null) {
                    System.out.println("Spillet er ikke utlånt.");
                    return;
                }

                PreparedStatement updateStatement = connection.prepareStatement(updateSql);
                updateStatement.setInt(1, itemID);

                int rows = updateStatement.executeUpdate();

                if (rows > 0) {
                    System.out.println("Spillet er registrert som innlevert.");
                }

            } else {

                System.out.println("Fant ikke spill med ID " + itemID);

            }

        } catch (SQLException e) {

            System.out.println("Feil ved registrering av innlevering.");
            e.printStackTrace();

        }

    }
    public void showRentedGames() {

        String sql = "SELECT * FROM FamilyGame WHERE RentOutDate IS NOT NULL";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ) {

            while (resultSet.next()) {

                System.out.println("---------------------------");
                System.out.println("ID: " + resultSet.getInt("ItemID"));
                System.out.println("Navn: " + resultSet.getString("Name"));
                System.out.println("Utlånsdato: " + resultSet.getDate("RentOutDate"));

            }

        } catch (SQLException e) {

            System.out.println("Feil ved henting av utlånte spill.");
            e.printStackTrace();

        }

    }
}