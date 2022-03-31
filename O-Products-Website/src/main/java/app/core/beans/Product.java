package app.core.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

	private int id;
	private String name;
	private double price;
	private int stock;
}
