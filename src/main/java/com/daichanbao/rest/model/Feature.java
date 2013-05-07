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
public class Feature extends AbstractEntity {
	private String label;
	private String value;
	@Column(name="expert_comment", nullable=true)
	private String expertComment;
	@ManyToMany(mappedBy="features")
	private Set<Product> products;
	
	public void addProduct(Product product) {
		if (this.products == null) {
			this.products = new HashSet<Product>();
		}
		this.products.add(product);
	}
}
