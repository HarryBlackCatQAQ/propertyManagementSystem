package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.Property;
import com.bnuz.propertyManagementSystem.model.PropertyExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PropertyDao继承基类
 */
@Repository
public interface PropertyDao extends JpaRepository<Property, Integer> {

  Property getById(Integer id);

}