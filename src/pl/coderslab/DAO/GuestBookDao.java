package pl.coderslab.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.entities.GuestBookEntry;

public class GuestBookDao {
	private static String INSERT_INTO_GUEST_BOOK = "INSERT INTO servletJDBC.guest_book (name, description) VALUES (?,?)";
	private static String GET_GEUST_BOOK = "SELECT * FROM servletJDBC.guest_book order by id desc";

	public void insertIntoGuestBook(GuestBookEntry guestBookEntry, String connection, String user, String password) {
		try (Connection conn = DriverManager.getConnection(connection, user, password)) {
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_INTO_GUEST_BOOK);
			preparedStatement.setString(1, guestBookEntry.getName());
			preparedStatement.setString(2, guestBookEntry.getDescription());
			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<GuestBookEntry> allEntry(String connection, String user, String password) {
		List<GuestBookEntry> allEntry = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(connection, user, password)) {
			PreparedStatement preparedStatement = conn.prepareStatement(GET_GEUST_BOOK);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				GuestBookEntry bookEntry = new GuestBookEntry();
				bookEntry.setName(resultSet.getString("name"));
				bookEntry.setDescription(resultSet.getString("description"));
				allEntry.add(bookEntry);
			}
			return allEntry;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}

	}

}
