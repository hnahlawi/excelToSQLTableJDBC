package p1;

import java.sql.*;
import java.util.ArrayList;


public class Database {
	
	Connection connection;
	
	public Database() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hadi", "hadi", "hadi");
		
		
	}
	
	
	public void createTable(ArrayList<String> columns) throws SQLException {
		System.out.println("Creating table...");
		Statement statement = connection.createStatement();
		
		String query = "CREATE TABLE data (" + columns.get(0) + " varchar(255), " + columns.get(1) + " varchar(255),";
		query += columns.get(2) + " varchar(255), " + columns.get(3) + " varchar(512),";
		query += columns.get(4) + " varchar(512), " + columns.get(5) + " varchar(512),";
		query += columns.get(6) + " varchar(255), " + columns.get(7) + " varchar(255) );";
		
		System.out.println(columns.get(4));
		statement.execute(query);
		
		
	}
	
	public void addRows(ArrayList<Entry> entries) throws SQLException {
		System.out.println("Adding rows...");
		for (int i = 0; i < entries.size(); i++) {
		Entry curr = entries.get(i);
		Statement statement = connection.createStatement();
		String query = "INSERT INTO data VALUES (";
		query += "'"+ curr.company+ "'" + ", " +"'"+ curr.jobTitle + "'" + ", " + "'" +curr.description+ "'" +  ", " + "'" +curr.link+"'" + ", ";
		query += "'" +curr.date+ "'"  + ", " + "'" +curr.status + "'" +", " + "'" +curr.location +"'" + ", " + "'" +curr.clFile +"'" + ");";
		statement.execute(query);
		
		
		
		}
	}
	
	
}
