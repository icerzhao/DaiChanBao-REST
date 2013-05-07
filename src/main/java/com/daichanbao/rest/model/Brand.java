package com.daichanbao.rest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Model class for Brand
 * 
 * @author Zhao Qinghua
 *
 */

@Entity
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class Brand extends AbstractEntity {

	private String name;
	private String description;
	@Column(name="logo_img")
	private String logoImg;
	@OneToMany(mappedBy="brand", fetch=FetchType.LAZY, orphanRemoval=false)
	private Set<Product> products;
	
	public void addProduct(Product product) {
		if (this.products == null) {
			this.products = new HashSet<Product>();
		}
		this.products.add(product);
	}
}
