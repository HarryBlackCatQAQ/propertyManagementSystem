package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.dto.HouseDto;
import com.bnuz.propertyManagementSystem.model.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * HouseDao继承基类
 */
@Repository
public interface HouseDao extends JpaRepository<House, Integer> {

  Page<House> findAll(Pageable pageable);

  @Query(value = "select h.id, h.number, h.area, h.direction, h.floor, "
      + "h.buildingId, h.userId, u.nickName from house h,user u where h.userId = u.id and h.buildingId = ?1", nativeQuery = true)
  Page<HouseDto> findAllByBuildingId(Integer buildingId, Pageable pageable);

  House getById(Integer id);

  House getByBuildingIdAndNumber(Integer buildingId, Integer number);

}
