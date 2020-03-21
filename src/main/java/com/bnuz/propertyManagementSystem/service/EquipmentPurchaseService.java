package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.EquipmentPurchase;
import com.bnuz.propertyManagementSystem.model.Result;

public interface EquipmentPurchaseService {

  public Result getById(Integer id);

  public Result insert(EquipmentPurchase equipmentPurchase);

  public Result deleteById(Integer id);

  public Result findAll(Integer pageNum, Integer pageSize);

  public Result findAllByApplicantId(Integer applicantId, Integer pageNum, Integer pageSize);

  public Result updateStatusPass(Integer id, Integer reviewerId);

  public Result updateStatusNotPass(Integer id, Integer reviewerId);

  public Result updateStatusComplete(Integer id, Integer reviewerId);

}
