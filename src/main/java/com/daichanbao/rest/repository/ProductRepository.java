package com.daichanbao.rest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.daichanbao.rest.model.Product;

/**
 * Product repository
 * 
 * @author Zhao Qinghua
 *
 */
@RestResource(path = "products", rel = "products")
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	/**
	 * Retrieves all the products for a given name
	 * 
	 * @param name
	 * @return list of products having the name
	 */
	List<Product> findByName(@Param("name") String name);
	
	/**
	 * Deletes the entity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
	 */
	@RestResource(exported = false)
	void delete(Long id);

	/**
	 * Deletes a given entity.
	 * 
	 * @param entity
	 * @throws IllegalArgumentException in case the given entity is (@literal null}.
	 */
	@RestResource(exported = false)
	void delete(Product entity);

	/**
	 * Deletes the given entities.
	 * 
	 * @param entities
	 * @throws IllegalArgumentException in case the given {@link Iterable} is (@literal null}.
	 */
	@RestResource(exported = false)
	void delete(Iterable<? extends Product> entities);

	/**
	 * Deletes all entities managed by the repository.
	 */
	@RestResource(exported = false)
	void deleteAll();
}
