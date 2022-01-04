package com.naomi.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class CreateJDBCConnection {

	public static void main(String[] args) {
		
		/* to get a connection to the database we need:
		 	1) database url
		 	2) user name
		 	3) user password */
		String dbUrl = "jdbc:mysql://localhost:3306/db?createDatabaseIfNotExist=true";
		String user = "root";
		String password = "Nbar2000";
		
		/* to get a Connection object we need DriverManager:
			Driver - database implementation
			Connection - connection to the database
			Statement - object for executing sql statements Statement. stmt.executeUpdate(..); */
		try(Connection connection = DriverManager.getConnection(dbUrl, user, password);) {
			System.out.println("connected");
			//use the connection to get a Statement object
			Statement statement = connection.createStatement();
			
			//create the person table
			String sqlCreate = "create table person(id int primary key auto_increment, name varchar(50))"; //define an sql as String
//			statement.executeUpdate(sqlCreate); //execute the sql
			
			//insert 100 person to the person table
			for(int i=0; i<100; i++) {
				String sqlInsert = "insert into person values(0, 'person " + (i+1) + "')";
//				statement.executeUpdate(sqlInsert);
			}
			
			//change the name of person 1 to 'Naomi'
			String sqlUpdate = "update person set name = 'Naomi' where id = 1";
//			statement.executeUpdate(sqlUpdate);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("disconnected");
	}

	
}
