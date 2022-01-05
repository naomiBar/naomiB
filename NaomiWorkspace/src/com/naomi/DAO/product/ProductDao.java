package com.naomi.DAO.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

	private String dbUrl = "jdbc:mysql://localhost:3306/db_product?createDatabaseIfNotExist=true";
	private String user = "root";
	private String password;

	public ProductDao(String password, boolean isCreate) {
		this.password = password;
		if(isCreate) {
			try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
				Statement stmt = con.createStatement();
				String sqlCreate = "create table products(id int primary key auto_increment, name varchar(50), price float)"; // define																							// String
				stmt.executeUpdate(sqlCreate);
			} catch (SQLException e) {
				throw new RuntimeException("create products table failed", e);
			}			
		}
	}

	public void saveProduct(Product product) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "insert into products values(0, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getName());
			pstmt.setFloat(2, product.getPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("save product failed", e);
		}
	}

	public Product readProduct(int id) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "select * from products where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Product(rs.getInt("id"), rs.getString("name"), rs.getFloat("price"));
			} else {
				throw new RuntimeException("read product failed");
			}
		} catch (SQLException e) {
			throw new RuntimeException("read product failed", e);
		}
	}

	
	public List<Product> readAllProducts() {
		List<Product> products = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "select * from products";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(!rs.next()) {
				throw new RuntimeException("read product failed");				
			}
			System.out.println("  id: \t|\t   name: \t|   price:");
			System.out.println("------------------------------------------");			
			do {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				
				System.out.println("   " + id + "\t|\t" + name + "\t|\t" + price);
				products.add(new Product(id, name, price));				
			}while(rs.next());
			return products;
		} catch (SQLException e) {
			throw new RuntimeException("read products table failed", e);
		}
	}
	
	public void updateProduct(Product product) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "update products set name = ?, price = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getName());
			pstmt.setFloat(2, product.getPrice());
			pstmt.setInt(3, product.getId());
			if (pstmt.executeUpdate() == 0) {
				throw new RuntimeException("update person failed - not found");
			}
		} catch (SQLException e) {
			throw new RuntimeException("update product failed", e);
		}
	}

	public void deleteProduct(int id) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "delete from products where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			if (pstmt.executeUpdate() == 0) {
				throw new RuntimeException("delete person " + id + " failed - not found");
			}
		} catch (Exception e) {
			throw new RuntimeException("delete product failed", e);
		}
	}
	
	public void deleteAllProducts() {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "delete from products";
			PreparedStatement pstmt = con.prepareStatement(sql);
			if (pstmt.executeUpdate() == 0) {
				throw new RuntimeException("delete products failed");
			}
		} catch (Exception e) {
			throw new RuntimeException("delete products failed", e);
		}
	}
	
	public void dropTable() {
		try(Connection con = DriverManager.getConnection(dbUrl, user, password)){
			Statement stmt = con.createStatement();
			String sql = "drop table products";
			stmt.executeUpdate(sql);
		}catch (Exception e) {
			throw new RuntimeException("drop products table failed", e);
		}
	}
	

}
