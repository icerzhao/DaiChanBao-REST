package com.daichanbao.rest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category extends AbstractEntity {
	
	private String name;
	private String description;
	@Column(name="category_icon")
	private String categoryIcon;
	@ManyToMany(mappedBy="categories")
	private Set<Product> products;
	
	public void addProduct(Product product) {
		if (this.products == null) {
			this.products = new HashSet<Product>();
		}
		this.products.add(product);
	}
}
