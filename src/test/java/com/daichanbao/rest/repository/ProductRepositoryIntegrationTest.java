package com.daichanbao.rest.repository;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.daichanbao.rest.AbstractIntegrationTest;
import com.daichanbao.rest.model.Brand;
import com.daichanbao.rest.model.Category;
import com.daichanbao.rest.model.Feature;
import com.daichanbao.rest.model.Product;

/**
 * Integration tests for Spring Data based {@link ProductRepository}.
 * 
 * @author Zhao Qinghua
 */
public class ProductRepositoryIntegrationTest extends AbstractIntegrationTest {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	BrandRepository brandRepository;
	@Autowired
	FeatureRepository featureRepository;
	@Autowired
	CategoryRepository categoryRepository;

/*	@Test
	public void findsAllOrders() {

		Iterable<Order> orders = repository.findAll();
		assertThat(orders, is(Matchers.<Order> iterableWithSize(2)));
	}*/

	@Test
	public void createsNewProduct() {
		Brand brand = new Brand();
		brand.setName("brand1");
		brand.setDescription("brand1Desc");
		brand = brandRepository.save(brand);
		
		Feature feature1 = new Feature();
		feature1.setLabel("label1");
		feature1.setValue("value1");
		Feature feature2 = new Feature();
		feature2.setLabel("label2");
		feature2.setValue("value2");
		feature1 = featureRepository.save(feature1);
		feature2 = featureRepository.save(feature2);
		
		Category category1 = new Category();
		category1.setName("cat1");
		category1.setDescription("cat1Desc");
		Category category2 = new Category();
		category2.setName("cat2");
		category2.setDescription("cat2Desc");
		category1 = categoryRepository.save(category1);
		category2 = categoryRepository.save(category2);
		
		Product product = new Product("p1Name", "p1Desc");
		product.setBrand(brand);
		product.addFeature(feature1);
		product.addFeature(feature2);
		product.addCategory(category1);
		product.addCategory(category2);
		
		product = productRepository.save(product);
		
		Iterable<Product> result = productRepository.findAll();
		assertThat(result, hasItem(product));
	}

	/*@Test
	public void findsOrderByStatus() {

		List<Order> result = repository.findByStatus(PAYMENT_EXPECTED);
		assertThat(result, hasSize(2));

		Order order = result.get(0);
		order.markPaid();
		order = repository.save(order);

		assertThat(repository.findByStatus(PAYMENT_EXPECTED), hasSize(1));
		assertThat(repository.findByStatus(PAID), hasSize(1));
	}*/
}
