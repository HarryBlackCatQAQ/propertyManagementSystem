package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.Building;
import com.bnuz.propertyManagementSystem.model.BuildingExample;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BuildingDao继承基类
 */
@Repository
public interface BuildingDao extends JpaRepository<Building, Integer> {

  Building getById(Integer id);

}