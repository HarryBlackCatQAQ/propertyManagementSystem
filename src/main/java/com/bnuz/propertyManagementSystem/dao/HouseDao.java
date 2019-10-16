package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * HouseDao继承基类
 */
@Repository
public interface HouseDao extends JpaRepository<House, Integer> {

  Page<House> findAll(Pageable pageable);

  Page<House> findAllByBuildingId(Pageable pageable, Integer buildingId);

  House getById(Integer id);

  House getByBuildingIdAndNumber(Integer buildingId, Integer number);

}
