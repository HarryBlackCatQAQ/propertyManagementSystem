package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.EquipmentPurchaseDao;
import com.bnuz.propertyManagementSystem.model.EquipmentPurchase;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.service.EquipmentPurchaseService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("EquipmentPurchaseServiceImpl")
@Transactional
public class EquipmentPurchaseServiceImpl implements EquipmentPurchaseService {

  @Autowired
  private EquipmentPurchaseDao equipmentPurchaseDao;

  @Override
  public Result getById(Integer id) {
    EquipmentPurchase equipmentPurchase = equipmentPurchaseDao.getById(id);
    return new Result(true, ResultStatusCode.OK, "查询成功", equipmentPurchase);
  }

  @Override
  public Result insert(EquipmentPurchase equipmentPurchase) {
    synchronized (EquipmentPurchaseServiceImpl.class) {
      equipmentPurchase.setStatus("审核中");
      EquipmentPurchase result = equipmentPurchaseDao.saveAndFlush(equipmentPurchase);
      return new Result(true, ResultStatusCode.OK, "插入成功", result);
    }
  }

  @Override
  public Result deleteById(Integer id) {
    synchronized (EquipmentPurchaseServiceImpl.class) {
      EquipmentPurchase equipmentPurchase = equipmentPurchaseDao.getById(id);
      equipmentPurchaseDao.delete(equipmentPurchase);
      return new Result(true, ResultStatusCode.OK, "删除成功");
    }
  }

  @Override
  public Result findAll(Integer pageNum, Integer pageSize) {
    Sort sort = new Sort(Direction.DESC,"createTime");
    Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
    Page page = equipmentPurchaseDao.findAll(pageable);
    return new Result(true, ResultStatusCode.OK, "查询成功", page);
  }

  @Override
  public Result findAllByApplicantId(Integer applicantId, Integer pageNum, Integer pageSize) {
    Sort sort = new Sort(Direction.DESC,"createTime");
    Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
    Page page = equipmentPurchaseDao.findAllByApplicantId(applicantId, pageable);
    return new Result(true, ResultStatusCode.OK, "查询成功", page);
  }

  @Override
  public Result updateStatusPass(Integer id, Integer reviewerId) {
    synchronized (EquipmentPurchaseServiceImpl.class) {
      EquipmentPurchase equipmentPurchase = equipmentPurchaseDao.getById(id);
      equipmentPurchase.setReviewerId(reviewerId);
      equipmentPurchase.setStatus("审核通过");
      equipmentPurchase.setReviewTime(new Date());
      EquipmentPurchase result = equipmentPurchaseDao.saveAndFlush(equipmentPurchase);
      return new Result(true, ResultStatusCode.OK, "更新成功", result);
    }
  }

  @Override
  public Result updateStatusNotPass(Integer id, Integer reviewerId) {
    synchronized (EquipmentPurchaseServiceImpl.class) {
      EquipmentPurchase equipmentPurchase = equipmentPurchaseDao.getById(id);
      equipmentPurchase.setReviewerId(reviewerId);
      equipmentPurchase.setStatus("审核不通过");
      equipmentPurchase.setReviewTime(new Date());
      equipmentPurchase.setCompleteTime(new Date());
      EquipmentPurchase result = equipmentPurchaseDao.saveAndFlush(equipmentPurchase);
      return new Result(true, ResultStatusCode.OK, "更新成功", result);
    }
  }

  @Override
  public Result updateStatusComplete(Integer id, Integer reviewerId) {
    synchronized (EquipmentPurchaseServiceImpl.class) {
      EquipmentPurchase equipmentPurchase = equipmentPurchaseDao.getById(id);
      equipmentPurchase.setReviewerId(reviewerId);
      equipmentPurchase.setStatus("已完成");
      equipmentPurchase.setCompleteTime(new Date());
      EquipmentPurchase result = equipmentPurchaseDao.saveAndFlush(equipmentPurchase);
      return new Result(true, ResultStatusCode.OK, "更新成功", result);
    }
  }
}
