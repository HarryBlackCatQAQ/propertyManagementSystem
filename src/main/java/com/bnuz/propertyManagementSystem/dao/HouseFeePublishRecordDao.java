package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.HouseFeePublishRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * HouseFeePublishRecordDao继承基类
 */
@Repository
public interface HouseFeePublishRecordDao extends JpaRepository<HouseFeePublishRecord, Integer> {

  Page<HouseFeePublishRecord> findAll(Pageable pageable);

}
