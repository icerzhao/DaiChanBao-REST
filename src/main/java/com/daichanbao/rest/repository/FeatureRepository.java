package com.daichanbao.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.repository.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.daichanbao.rest.model.Feature;

/**
 * Feature repository
 * 
 * @author Zhao Qinghua
 *
 */
@RestResource(path = "features", rel = "features")
@Repository
public interface FeatureRepository extends CrudRepository<Feature, Long> {

}
