package com.naomi.DAO.product;

public class ProductTest {

	public static void main(String[] args) {

		String password = "1234";
//		String password = "Nbar2000";
		try {
			ProductDao dao = new ProductDao(password, true);
			for(int i=0; i<10; i++) {
				float price = (float) (Math.random()*100);
				Product product = new Product("product " + (i+1), price);
				dao.saveProduct(product);
				System.out.println("save product " + (i+1));
				System.out.println("read product: " + dao.readProduct(i+1));
			}
			Product product = new Product(1, "chocolate", 300);
			dao.updateProduct(product);
			dao.deleteProduct(2);
			System.out.println("\t products: \n" + dao.readAllProducts());
			dao.deleteAllProducts();
			dao.dropTable();

		} catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());
		}
	}

}
