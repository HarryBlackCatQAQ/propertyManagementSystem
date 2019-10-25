package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.Building;
import com.bnuz.propertyManagementSystem.model.BuildingExample;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BuildingDao继承基类
 */
@Repository
public interface BuildingDao extends JpaRepository<Building, Integer> {

  Page<Building> findAll(Pageable pageable);

  Page<Building> findAllByPropertyId(Pageable pageable, Integer propertyId);

  Building getById(Integer id);



}