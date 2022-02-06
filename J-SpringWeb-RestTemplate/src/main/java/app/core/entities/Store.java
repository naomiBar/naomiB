package app.core.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "items")
@EqualsAndHashCode(of = "id")
@Entity //JPA
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	private List<Item> items;
	
	public void addItem(Item item) {
		if(this.items == null) {
			this.items = new ArrayList<>();
		}
		item.setStore(this);
		this.items.add(item);
	}
	
	public void setItems(List<Item> items) {
		for (Item item : items) {
			item.setStore(this);
		}
		this.items = items;
	}
}
