package pl.coderslab.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewsletterDao {
	private static final String JDBC_CONNECTION = "jdbc:mysql://localhost:3306/?useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "coderslab";
	private static final String INSERT_INTO_DB = "INSERT INTO servletJDBC.newsletter (name,email) VALUES (?,?)";
	
	
	public void insertData (String name, String email){
		try (Connection conn = DriverManager.getConnection(JDBC_CONNECTION, USER, PASSWORD)){
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_INTO_DB);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
