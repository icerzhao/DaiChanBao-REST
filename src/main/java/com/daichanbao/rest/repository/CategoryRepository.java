package com.daichanbao.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.repository.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.daichanbao.rest.model.Category;

/**
 * Category repository
 * 
 * @author Zhao Qinghua
 *
 */
@RestResource(path = "categories", rel = "categories")
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
