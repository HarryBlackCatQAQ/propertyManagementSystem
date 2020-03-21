package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.EquipmentPurchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EquipmentPurchaseDao继承基类
 */
@Repository
public interface EquipmentPurchaseDao extends JpaRepository<EquipmentPurchase, Integer> {

  EquipmentPurchase getById(Integer id);

  Page<EquipmentPurchase> findAllByApplicantId(Integer userId, Pageable pageable);

}
