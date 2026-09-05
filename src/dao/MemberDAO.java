package dao;

import database.DatabaseConnection;
import model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

    public void addMember(Member member) {

        String sql = "INSERT INTO Member (MemberID, Name, Address, PhoneNumber) VALUES (?, ?, ?, ?)";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, member.getMemberID());
            statement.setString(2, member.getName());
            statement.setString(3, member.getAddress());
            statement.setString(4, member.getPhoneNumber());

            statement.executeUpdate();

            System.out.println("Medlem lagret i databasen.");

        } catch (SQLException e) {
            System.out.println("Feil ved lagring av medlem.");
            e.printStackTrace();
        }

    }

    public boolean memberExists(int memberID) {

        String sql = "SELECT * FROM Member WHERE MemberID = ?";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, memberID);

            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            System.out.println("Feil ved sjekk av medlem.");
            e.printStackTrace();
        }

        return false;
    }

}