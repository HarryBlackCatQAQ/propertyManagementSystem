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

  @Query("select new com.bnuz.propertyManagementSystem.dto.HouseDto(h.id, h.number, h.area, h.direction, h.floor, "
      + "h.buildingId, h.userId, u.nickname) "
      + "from House h,User u where h.userId = u.id and h.buildingId = :buildingId order by h.number asc ")
  Page<HouseDto> findAllByBuildingIdOrderByNumber(Integer buildingId, Pageable pageable);

  House getById(Integer id);

  House getByBuildingIdAndNumber(Integer buildingId, Integer number);

}
