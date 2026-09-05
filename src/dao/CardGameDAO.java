package dao;

import database.DatabaseConnection;
import model.CardGame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class CardGameDAO {

    public void addCardGame(CardGame game) {

        String sql = "INSERT INTO CardGame (Name, Description, YearPublished, RentOutDate, OwnerID, NumberOfCards, Collectible) VALUES (?, ?, ?, ?, ?, ?, ?)";

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
            statement.setInt(6, game.getNumberOfCards());
            statement.setBoolean(7, game.isCollectible());

            statement.executeUpdate();

            System.out.println("CardGame lagret.");

        } catch (SQLException e) {
            System.out.println("Feil ved lagring av CardGame.");
            e.printStackTrace();
        }

    }

    public boolean cardGameExists(String name) {

        String sql = "SELECT COUNT(*) FROM CardGame WHERE Name = ?";

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

}