package simonSays;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectie {

	Connection con;
	
	public static void main(String[] args) {
		DatabaseConnectie dc = new DatabaseConnectie();
		dc.connectie();
	}
	
	public void connectie() {
		DatabaseConnectie dbc = new DatabaseConnectie();
		
		try {
			dbc.con = DriverManager.getConnection("jdbc:sqlite:SimonSays.db");
			
			ResultSet variableresultset = dbc.executestatement();
			dbc.printResultSet(variableresultset);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void printResultSet(ResultSet resultset) {
		try {
			while (resultset.next()) {
				System.out.println(resultset.getString("name"));			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet executestatement() {
		Statement statement;
		try {
			statement = con.createStatement();
			statement.execute("SELECT * FROM Score");
			return statement.getResultSet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}