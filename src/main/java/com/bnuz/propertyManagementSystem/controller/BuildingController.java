package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.Building;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.service.BuildingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Hovees
 * @Date: 2019-10-07 16:16
 * @Version 1.0
 */

@RestController
@RequestMapping("building")
@Api(tags = "楼栋模块相关接口")
public class BuildingController {

  @Autowired
  private BuildingService buildingService;

  @PutMapping(value = "insert")
  @ApiOperation("新增楼栋接口")
  public Result insert(@RequestBody Building building){
    return buildingService.insert(building);
  }

  @GetMapping(value = "findAll")
  @ApiOperation("获取所有楼栋并分页接口")
  public Result findAll(@RequestParam Integer pageNum, Integer pageSize) {
    return buildingService.findAll(pageNum - 1, pageSize);
  }

  @GetMapping(value = "getById")
  @ApiOperation("根据ID获取楼栋接口")
  public Result getById(@RequestParam Integer id){
    return buildingService.getById(id);
  }

  @GetMapping(value = "getByUid")
  @ApiOperation("根据编码获取楼栋接口")
  public Result getByUid(@RequestParam Integer uid) {
    return buildingService.getByUid(uid);
  }

}
