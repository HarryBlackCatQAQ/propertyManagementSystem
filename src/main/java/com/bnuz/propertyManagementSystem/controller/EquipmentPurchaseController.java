package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.EquipmentPurchase;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.service.EquipmentPurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/equipmentPurchase")
@RestController
@Api(tags = "设备采购相关接口")
public class EquipmentPurchaseController {

  @Autowired
  private EquipmentPurchaseService equipmentPurchaseService;

  @GetMapping("/getById")
  @ApiOperation("根据id查询接口")
  public Result getById(Integer id) {
    return equipmentPurchaseService.getById(id);
  }

  @PostMapping("/insert")
  @ApiOperation("新增申请接口")
  public Result insert(@RequestBody EquipmentPurchase equipmentPurchase) {
    return equipmentPurchaseService.insert(equipmentPurchase);
  }

  @GetMapping("/deleteById")
  @ApiOperation("根据Id删除申请接口")
  public Result deleteById(Integer id) {
    return equipmentPurchaseService.deleteById(id);
  }

  @GetMapping("/findAll")
  @ApiOperation("查找所有申请接口")
  public Result findAll(Integer pageNum, Integer pageSize) {
    return equipmentPurchaseService.findAll(pageNum - 1, pageSize);
  }

  @GetMapping("/findAllByApplicantId")
  @ApiOperation("查找用户所有申请接口")
  public Result findAllByApplicantId(Integer applicantId, Integer pageNum, Integer pageSize) {
    return equipmentPurchaseService.findAllByApplicantId(applicantId,pageNum - 1, pageSize);
  }

  @GetMapping(value = "/updateStatusPass")
  @ApiOperation("更新申请状态为审核通过接口")
  public Result updateStatusPass(Integer id, Integer reviewerId) {
    return equipmentPurchaseService.updateStatusPass(id, reviewerId);
  }

  @GetMapping(value = "/updateStatusNotPass")
  @ApiOperation("更新申请状态为审核不通过接口")
  public Result updateStatusNotPass(Integer id, Integer reviewerId) {
    return equipmentPurchaseService.updateStatusNotPass(id, reviewerId);
  }

  @GetMapping(value = "/updateStatusComplete")
  @ApiOperation("更新申请状态为已完成接口")
  public Result updateStatusComplete(Integer id, Integer reviewerId) {
    return equipmentPurchaseService.updateStatusComplete(id, reviewerId);
  }

}
