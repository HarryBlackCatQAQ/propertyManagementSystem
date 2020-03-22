package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.Building;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.service.BuildingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

  @PostMapping(value = "insert")
  @ApiOperation("新增楼栋接口")
  public Result insert(@RequestBody Building building) {
    return buildingService.insert(building);
  }

  @DeleteMapping(value = "delete")
  @ApiOperation("删除楼栋接口")
  public Result delete(@RequestBody Building building) {
    return buildingService.delete(building);
  }

  @PatchMapping(value = "update")
  @ApiOperation("更新楼栋接口")
  public Result update(@RequestBody Building building) {
    return buildingService.update(building);
  }

  @GetMapping(value = "findAll")
  @ApiOperation("获取所有楼栋并分页接口")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "pageNum", value = "用户列表页码", defaultValue = "1"),
    @ApiImplicitParam(name = "pageSize", value = "每页条数", defaultValue = "10")
  })
  public Result findAll(@RequestParam Integer pageNum, Integer pageSize) {
    return buildingService.findAll(pageNum - 1, pageSize);
  }

  @GetMapping(value = "findAllByPropertyId")
  @ApiOperation("根据楼盘Id获取所有楼栋并分页接口")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "pageNum", value = "用户列表页码", defaultValue = "1"),
      @ApiImplicitParam(name = "pageSize", value = "每页条数", defaultValue = "10"),
      @ApiImplicitParam(name = "propertyId", value = "楼盘Id", defaultValue = "3")
  })
  public Result findAllByPropertyId(@RequestParam Integer pageNum, Integer pageSize, Integer propertyId) {
    return buildingService.findAllByPropertyIdOrderByName(pageNum - 1, pageSize, propertyId);
  }

  @GetMapping(value = "getAllBuildings")
  @ApiOperation("获取所有楼栋接口")
  public Result getAllBuildings() {
    return buildingService.findAll();
  }

  @GetMapping(value = "getAllBuildingByPropertyId")
  @ApiOperation("根据楼盘Id获取所有楼栋接口")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "propertyId", value = "楼盘Id", defaultValue = "3")
  })
  public Result getAllBuildingByPropertyId(@RequestParam Integer propertyId) {
    return buildingService.findAllByPropertyIdOrderByName(propertyId);
  }

  @GetMapping(value = "getById")
  @ApiOperation("根据ID获取楼栋接口")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "id", value = "楼栋主键ID", defaultValue = "1")
  })
  public Result getById(@RequestParam Integer id){
    return buildingService.getById(id);
  }

  @GetMapping(value = "getFirstByPropertyId")
  @ApiOperation("根据楼盘id查询第一个楼栋接口")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "propertyId", value = "楼盘ID", defaultValue = "1"),
  })
  public Result getFirstByPropertyId(@RequestParam Integer propertyId) {
    return buildingService.getFirstByPropertyId(propertyId);
  }


  @GetMapping(value = "checkPropertyBuildingName")
  @ApiOperation("查询当前楼盘楼栋名字是否可用接口")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "propertyId", value = "楼盘ID", defaultValue = "1"),
    @ApiImplicitParam(name = "buildingName", value = "楼栋名称", defaultValue = "京华5栋")
  })
  public Result checkPropertyBuildingName(@RequestParam Integer propertyId, String buildingName) {
    return buildingService.checkPropertyBuildingName(propertyId, buildingName);
  }

}
