package simonSays;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * This class is for making a connection between the program and the database.
 * I used a jdbc connection with the url to my database file.
 * 
 * With the insertNameIntoDB() method I insert the players name and the score into the database.
 * I did this by executing a statement that puts the name and score into the database.
 * 
 * With the executestatement() method i get all the data from the database.
 *
 */

public class DatabaseConnectie {

	Connection con;
	
//	public static void main(String[] args) {
//		DatabaseConnectie dc = new DatabaseConnectie();
//		dc.connectie();
//	}
	
	public DatabaseConnectie() {
		connectie();
	}
	
	public void connectie() {
//		DatabaseConnectie dbc = new DatabaseConnectie();
		
		try {
			con = DriverManager.getConnection("jdbc:sqlite:src/simonSays/SimonSays.db");
			
			ResultSet variableresultset = executestatement();
			printResultSet(variableresultset);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void printResultSet(ResultSet resultset) {
		try {
			while (resultset.next()) {
				System.out.println(resultset.getString("naam"));			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertNameIntoDB(String name, int score) {
		Statement statement;
		try {
			statement = con.createStatement();
			statement.execute("insert into Score values(" +name +"," + score+")");
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
