package com.daichanbao.rest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Model class for Products
 * 
 * @author Zhao Qinghua
 *
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class Product extends AbstractEntity {

	private String name;
	private String description;
	@Column(name="product_img")
	private String productImg;
	@ManyToOne(optional=false)
	@JoinColumn(name="brand_id", nullable=false, updatable=true)
	private Brand brand;
	@ManyToMany
	@JoinTable(name="product_feature", 
		joinColumns=
            @JoinColumn(name="product_id", referencedColumnName="id"),
        inverseJoinColumns=
            @JoinColumn(name="feature_id", referencedColumnName="id")
	)
	private Set<Feature> features;
	@ManyToMany
	@JoinTable(name="product_category", 
		joinColumns=
            @JoinColumn(name="product_id", referencedColumnName="id"),
        inverseJoinColumns=
            @JoinColumn(name="category_id", referencedColumnName="id")
	)
	private Set<Category> categories;
	
	public Product(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public void setBrand(Brand brand) {
		this.brand = brand;
		brand.addProduct(this);
	}
	
	public void addFeature(Feature feature) {
		if (this.features == null) {
			this.features = new HashSet<Feature>();
		}
		this.features.add(feature);
		feature.addProduct(this);
	}
	
	public void addCategory(Category category) {
		if (this.categories == null) {
			this.categories = new HashSet<Category>();
		}
		this.categories.add(category);
		category.addProduct(this);
	}
}
