package com.naomi.DAO.school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SchoolDao {

	private String dbUrl = "jdbc:mysql://localhost:3306/db_school?createDatabaseIfNotExist=true";
	private String user = "root";
	private String password;

	public SchoolDao(String password, boolean isCreate) {
		this.password = password;
		if(isCreate) {
			try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
				Statement stmt = con.createStatement();
				String sqlCreate = "create table schools(id int primary key auto_increment, name varchar(50), address varchar(50))"; // define																							// String
				stmt.executeUpdate(sqlCreate);
			} catch (SQLException e) {
				throw new RuntimeException("create schools table failed", e);
			}
		}
	}

	public void saveSchool(School school) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "insert into schools values(0, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, school.getName());
			pstmt.setString(2, school.getAddress());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("save school failed", e);
		}
	}

	public School readSchool(int id) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "select * from schools where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new School(rs.getInt("id"), rs.getString("name"), rs.getString("address"));
			} else {
				throw new RuntimeException("read school failed");
			}
		} catch (SQLException e) {
			throw new RuntimeException("read school failed", e);
		}
	}

	public List<School> readAllSchools() {
		List<School> schools = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "select * from schools";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(!rs.next()) {
				throw new RuntimeException("read schools table failed");				
			}
			System.out.println("  id: \t|   name: \t|   address:");
			System.out.println("------------------------------------------");			
			do {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				
				System.out.println("   " + id + "\t|\t" + name + "\t|\t" + address);
				schools.add(new School(id, name, address));
			}while(rs.next());
			return schools;
		} catch (SQLException e) {
			throw new RuntimeException("read schools table failed", e);
		}
	}
	
	public void updateSchool(School school) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "update schools set name = ?, address = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, school.getName());
			pstmt.setString(2, school.getAddress());
			pstmt.setInt(3, school.getId());
			if (pstmt.executeUpdate() == 0) {
				throw new RuntimeException("update school failed - not found");
			}
		} catch (SQLException e) {
			throw new RuntimeException("update school failed", e);
		}
	}

	public void deleteSchool(int id) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "delete from schools where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			if (pstmt.executeUpdate() == 0) {
				throw new RuntimeException("delete school " + id + " failed - not found");
			}
		} catch (Exception e) {
			throw new RuntimeException("delete school failed", e);
		}
	}
	
	public void deleteAllSchools() {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "delete from schools";
			PreparedStatement pstmt = con.prepareStatement(sql);
			if (pstmt.executeUpdate() == 0) {
				throw new RuntimeException("delete schools failed");
			}
		} catch (Exception e) {
			throw new RuntimeException("delete schools failed", e);
		}
	}
	
	public void dropTable() {
		try(Connection con = DriverManager.getConnection(dbUrl, user, password)){
			Statement stmt = con.createStatement();
			String sql = "drop table schools";
			stmt.executeUpdate(sql);
		}catch (Exception e) {
			throw new RuntimeException("drop schools table failed", e);
		}
	}
	

}
