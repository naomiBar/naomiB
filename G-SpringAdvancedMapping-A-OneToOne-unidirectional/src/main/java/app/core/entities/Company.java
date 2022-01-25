package app.core.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * spring beans (@Component, @Bean) - are managed by spring context (spring container)
 * JPA Entities (@Entity) - are managed by Hibernate session context (hibernate session)
 * entity is not bean. it is not managed by spring context. Entity is managed by hibernate session context
 * */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {

	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	//cascade means that saving/deleting Company will save/delete CompanyAddress
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adress_id")
	private Address address;
}
