package helper.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import helper.logger.LoggerHelper;

public class DatabaseHelper {

	private Logger log = LoggerHelper.getLogger(DatabaseHelper.class);

	private static String url = "jdbc:mysql://localhost/akash";
	private String driverName = "com.mysql.jdbc.Driver";
	private static String userName = "root";
	private static String password = "password";
	private static Connection connection;
	private static DatabaseHelper instance = null;

	public DatabaseHelper() {
		connection = getSingleInstanceConnection();
	}

	public static DatabaseHelper getInstance() {
		if (instance == null) {
			instance = new DatabaseHelper();
		}
		return instance;
	}

	private Connection getSingleInstanceConnection() {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, userName, password);
			if (connection != null) {
				log.info("Connected to database");
			}
		} catch (Exception e) {
			log.info("Driver not found" + e);
		}
		return connection;
	}

	public Connection getConnection() {
		return connection;
	}

	public ResultSet getResultSet(String dbQuery) throws SQLException {
		instance = DatabaseHelper.getInstance();
		connection = instance.getConnection();
		log.info("Running SQL Query " + dbQuery);
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(dbQuery);
		return result;
	}
}
