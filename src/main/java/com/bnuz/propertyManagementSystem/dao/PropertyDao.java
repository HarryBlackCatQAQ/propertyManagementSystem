package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.Property;
import com.bnuz.propertyManagementSystem.model.PropertyExample;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PropertyDao继承基类
 */
@Repository
public interface PropertyDao extends JpaRepository<Property, Integer> {

  Page<Property> findAll(Pageable pageable);

  Property getById(Integer id);

  Property getByUid(Integer uid);

  Property getByName(String propertyName);

}