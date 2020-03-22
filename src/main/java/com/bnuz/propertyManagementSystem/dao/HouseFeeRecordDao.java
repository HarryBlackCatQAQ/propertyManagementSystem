package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.HouseFeeRecord;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseFeeRecordDao extends JpaRepository<HouseFeeRecord, Integer> {

    public HouseFeeRecord getByOutTradeNo(String outTradeNo);

    @Query(value = "SELECT * FROM house_fee_record LEFT JOIN house ON (house_fee_record.houseId = house.id) WHERE userId = ?1"
        + " ORDER BY outTradeNo DESC,year DESC,month DESC"
        ,nativeQuery=true)
    public Page<HouseFeeRecord> findAllUnPayFeesListByUserId(int userId,Pageable pageable);

    @Query(value = "SELECT * FROM house_fee_record LEFT JOIN house ON (house_fee_record.houseId = house.id) WHERE userId = ?1 "
        + "AND (year*100+month) BETWEEN (?2 * 100 + ?3) AND (?4 * 100 + ?5) ORDER BY outTradeNo DESC,year DESC,month DESC",nativeQuery=true)
    public Page<HouseFeeRecord> searchOwnerTimeRangeFeesList(int userId,
        int fromYear, int fromMonth, int toYear, int toMonth, Pageable pageable);

    @Query(value= "SELECT * FROM house_fee_record LEFT JOIN house ON (house_fee_record.houseId = house.id) "
        + "LEFT JOIN user ON (user.id = house.userId) WHERE userId = ?1 AND house_fee_record.buildingId = ?2 "
        + "AND (year*100+month) BETWEEN (?3 * 100 + ?4) AND (?5 * 100 + ?6) ORDER BY outTradeNo DESC,year DESC,month DESC",nativeQuery=true)
    public Page<HouseFeeRecord> searchUserBuildingFeesList(int userId, int buildingId,
        int fromYear, int fromMonth, int toYear, int toMonth, Pageable pageable);

    @Query(value = "SELECT * FROM house_fee_record LEFT JOIN house ON (house_fee_record.houseId = house.id)"
        + "LEFT JOIN user ON (user.id = house.userId) WHERE house_fee_record.buildingId = ?1 "
        + "AND (year*100+month) BETWEEN (?2 * 100 + ?3) AND (?4 * 100 + ?5) ORDER BY outTradeNo DESC,year DESC,month DESC",nativeQuery=true)
    public Page<HouseFeeRecord> searchBuildingFeesList(int buildingId,
        int fromYear, int fromMonth, int toYear, int toMonth, Pageable pageable);

    @Query(value = "SELECT * FROM house_fee_record LEFT JOIN house ON (house_fee_record.houseId = house.id) "
        + "LEFT JOIN user ON (user.id = house.userId) WHERE userId = ?1 "
        + "AND (year*100+month) BETWEEN (?2 * 100 + ?3) AND (?4 * 100 + ?5) ORDER BY outTradeNo DESC,year DESC,month DESC",nativeQuery=true)
    public Page<HouseFeeRecord> searchUserFeesList(int userId,
        int fromYear, int fromMonth, int toYear, int toMonth, Pageable pageable);

    @Query(value = "SELECT * FROM house_fee_record LEFT JOIN house ON (house_fee_record.houseId = house.id) "
        + "LEFT JOIN user ON (user.id = house.userId) WHERE house_fee_record.houseId = ?1 "
        + "AND (year*100+month) BETWEEN (?2 * 100 + ?3) AND (?4 * 100 + ?5) ORDER BY outTradeNo DESC,year DESC,month DESC",nativeQuery=true)
    public Page<HouseFeeRecord> searchHouseFeesList(int houseId, int fromYear,
        int fromMonth, int toYear, int toMonth, Pageable pageable);

    @Query(value = "SELECT * FROM house_fee_record WHERE houseId = ?1 AND isPaid = 0",nativeQuery=true)
    public List<HouseFeeRecord> checkHouseFeeClear(int houseId);

}
