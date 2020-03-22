package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.HouseFeeRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseFeeRecordDao extends JpaRepository<HouseFeeRecord, Integer> {

    public HouseFeeRecord getByOutTradeNo(String outTradeNo);

    @Query(value = "SELECT * FROM house_fee_record WHERE houseId = any(SELECT id FROM house where userId = ?1) AND isPaid = ?2",nativeQuery=true)
    public Page<HouseFeeRecord> findAllPayFeesListByUserIdAndPayState(int userId,int payState,Pageable pageable);


    @Query(value = "SELECT * FROM house_fee_record WHERE houseId = any(SELECT id FROM house where userId = ?1)",nativeQuery=true)
    public Page<HouseFeeRecord> findAllPayFeesListByUserId(int userId,Pageable pageable);
}
