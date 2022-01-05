package com.naomi.DAO.school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

	private String dbUrl = "jdbc:mysql://localhost:3306/db_school?createDatabaseIfNotExist=true";
	private String user = "root";
	private String password;

	public StudentDao(String password, boolean isCreate) {
		this.password = password;
		if(isCreate) {
			try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
				Statement stmt = con.createStatement();
				String sqlCreate = "create table students(id int primary key auto_increment, school_id int, name varchar(50), email varchar(50),"
						+ " foreign key (school_id) references schools(id))";
				stmt.executeUpdate(sqlCreate);
			} catch (SQLException e) {
				throw new RuntimeException("create students table failed", e);
			}			
		}
	}

	public void saveStudent(Student student) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "insert into students values(0, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student.getSchool_id());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("save student failed", e);
		}
	}

	public Student readStudent(int id) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "select * from students where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Student(rs.getInt("id"), rs.getInt("school_id"), rs.getString("name"), rs.getString("email"));
			} else {
				throw new RuntimeException("read student failed");
			}
		} catch (SQLException e) {
			throw new RuntimeException("read student failed", e);
		}
	}

	public List<Student> readAllStudents() {
		List<Student> students = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "select * from students";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) {
				throw new RuntimeException("read students table failed");
			}
			System.out.println("  id: \t|   school_id: \t|   name: \t|   email:");
			System.out.println("--------------------------------------------------------------------");			
			do {
				int id = rs.getInt("id");
				int school_id = rs.getInt("school_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				
				System.out.println("   " + id + "\t|\t" + school_id + "\t|\t" + name + "\t|\t" + email);
				students.add(new Student(id, school_id, name, email));
			}while(rs.next());
			return students;
		} catch (SQLException e) {
			throw new RuntimeException("read students table failed", e);
		}
	}

	public void updateStudent(Student student) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "update students set school_id = ?, name = ?, email = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student.getId());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getEmail());
			pstmt.setInt(4, student.getId());
			if (pstmt.executeUpdate() == 0) {
				throw new RuntimeException("update student failed - not found");
			}
		} catch (SQLException e) {
			throw new RuntimeException("update student failed", e);
		}
	}

	public void deleteStudent(int id) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "delete from students where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			if (pstmt.executeUpdate() == 0) {
				throw new RuntimeException("delete student " + id + " failed - not found");
			}
		} catch (Exception e) {
			throw new RuntimeException("delete student failed", e);
		}
	}

	public void deleteAllStudents() {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "delete from students";
			PreparedStatement pstmt = con.prepareStatement(sql);
			if (pstmt.executeUpdate() == 0) {
				throw new RuntimeException("delete students failed");
			}
		} catch (Exception e) {
			throw new RuntimeException("delete students failed", e);
		}
	}

	public void dropTable() {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			Statement stmt = con.createStatement();
			String sql = "drop table students";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			throw new RuntimeException("drop students table failed", e);
		}
	}

}
