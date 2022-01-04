package com.naomi.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadStatement {

	public static void main(String[] args) {

		String dbUrl = "jdbc:mysql://localhost:3306/db?createDatabaseIfNotExist=true";
		String user = "root";
		String password = "Nbar2000";
		
		try(Connection con = DriverManager.getConnection(dbUrl, user, password)){
			Statement stmt = con.createStatement();

//			readPerson(stmt);
//			readBook(stmt);
			read(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void readPerson(Statement stmt) throws SQLException {
		String sql = "select * from person";
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("  id: \t|\t name:");
		System.out.println("------------------------");
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println("   " + id + "\t|\t" + name);
		}
	}
	
	private static void readBook(Statement stmt) throws SQLException {
		String sql = "select * from book";
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("  id: \t|   author_id: \t|   title: \t|   publication_date: \t|   price:");
		System.out.println("--------------------------------------------------------------------------");
		while(rs.next()) {
			int id = rs.getInt(1);
			int author_id = rs.getInt(2);
			String title = rs.getString(3);
			Date date = rs.getDate(4);
			float price = rs.getFloat(5);
			System.out.println("   " + id + "\t|\t" + author_id + "\t|\t" + title + "\t|\t" + date + "\t|\t" + price);
		}
	}
	
	private static void read(Statement stmt) throws SQLException {
		String sql = "select b.id, b.title, a.name, b.price "
				+ "from book as b join author a "
				+ "on b.author_id = a.id "
				+ "where b.price > 100";
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("  id: \t|   title: \t|   name: \t|       price:");
		System.out.println("---------------------------------------------------------");
		while(rs.next()) {
			int id = rs.getInt("b.id");
			String title = rs.getString("b.title");
			String name = rs.getString("a.name");
			float price = rs.getFloat("b.price");
			System.out.println("   " + id + "\t|\t" + title + "\t|\t" + name + "\t|\t" + price);
		}
	}
	
}
