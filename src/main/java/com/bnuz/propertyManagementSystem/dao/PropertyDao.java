package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.Property;
import java.util.List;
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

  List<Property> findAllByOrderByName();

  Property getFirstBy();

  Property getById(Integer id);

  Property getByUid(Long uid);

  Property getByName(String propertyName);

}