import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dbConnect {

	Date dateIn;
	public static String curLog;

	Connection connection = null;

	String driverName = "oracle.jdbc.driver.OracleDriver"; 

	String serverName = "141.165.201.104"; 
	String portNumber = "1521";
	String sid = "oracle11gs1";

	String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":"
			+ sid; 


	String username = "student025";
	String password = "student025";
	int x;

	public dbConnect() {
	}

	public boolean doConnection() {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, username, password);
			
			Statement stmt = null;
			String queryLog = "select * from login";

			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(queryLog);
			while (rs.next()) {
				eagleCredFrame.eagleCredListModel.addElement(rs.getString(1));
				eagleCredFrame.eagleCredListModel.addElement(rs.getString(2));
				//eagleCredFrame.eagleCredListModel.addElement("<html>user: "+rs.getString(1)+"<br>password: "+rs.getString(2));
			}

		} catch (ClassNotFoundException e) {
			// Could not find the database driver
			System.out.println("ClassNotFoundException : " + e.getMessage());
			return false;
		} catch (SQLException e) {
			// Could not connect to the database
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean loginCheck(String login, String pass) throws SQLException {
		
		Statement stmt = null;
		String queryLog = "SELECT * FROM Login join Student on Login.EagleId = Student.EagleId WHERE Login.EagleId LIKE '"
				+ login + "' AND Login.Pass LIKE '" + pass + "'";

		stmt = connection.createStatement();
		ResultSet rsCountLog = stmt.executeQuery(queryLog);
		int count = 0;
		while (rsCountLog.next()) {
			count = count + 1;
		}
		stmt.close();

		if (count != 0) {
			dateIn = new Date();
			curLog = login;
			System.out.println("Action Performed : LogIn - "+login);
			return true;
		}

		return false;
	}

	public void logOut()
			throws SQLException {
		int rand = 1000+(int) (Math.random() * 8999);
    	Date dateOut = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy h:mm:ss a");
    	String formattedDateOut = sdf.format(dateOut);
    	String formattedDateIn = sdf.format(dateIn);
    	
		Statement stmt = null;
		stmt = connection.createStatement();
		String sql2 = "INSERT INTO Student VALUES('"+curLog+"',"+rand+",'"+formattedDateIn+"','"+formattedDateOut+"')";
		stmt.executeUpdate(sql2);
		System.out.println("Action Performed: LogOut - "+curLog);
		
		databaseFrame.logDBListModel.addElement("<html>user: "+curLog+"<br>MAC: "+ (1 + (int)(Math.random() * ((28 - 1) + 1))) +"<br>timeIn: "+formattedDateIn+"<br>timeOut: "+formattedDateOut);
	}
}
