package UtilData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author wiemhjiri
 */
public class DataSource {

	private static Connection con = null;
	static {
		String url = "jdbc:mysql://localhost:3306/eventun?useSSL=false";
		String user = "root";
		String pass = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return con;
	}

}