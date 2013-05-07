package com.daichanbao.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.repository.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.daichanbao.rest.model.Brand;

/**
 * Brand repository
 * 
 * @author Zhao Qinghua
 *
 */
@RestResource(path = "brands", rel = "brands")
@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {

}
