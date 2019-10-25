package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.House;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.service.HouseService;
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
 * @Date: 2019-10-14 17:07
 * @Version 1.0
 */

@RestController
@RequestMapping("house")
@Api(tags = "房屋模块相关接口")
public class HouseController {

  @Autowired
  private HouseService houseService;

  @PostMapping(value = "insert")
  @ApiOperation("新增房屋接口")
  public Result insert(@RequestBody House house){
    return houseService.insert(house);
  }

  @PatchMapping(value = "update")
  @ApiOperation("更新房屋接口")
  public Result update(@RequestBody House house) {
    return houseService.update(house);
  }

  @DeleteMapping(value = "delete")
  @ApiOperation("删除房屋接口")
  public Result delete(@RequestBody House house) {
    return houseService.delete(house);
  }

  @GetMapping(value = "findAll")
  @ApiOperation("获取所有房屋并分页接口")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "pageNum", value = "用户列表页码", defaultValue = "1"),
    @ApiImplicitParam(name = "pageSize", value = "每页条数", defaultValue = "10")
  })
  public Result findAll(@RequestParam Integer pageNum, Integer pageSize) {
    return houseService.findAll(pageNum - 1, pageSize);
  }

  @GetMapping(value = "findAllByBuildingId")
  @ApiOperation("根据楼栋Id获取所有房屋并分页接口")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "pageNum", value = "用户列表页码", defaultValue = "1"),
    @ApiImplicitParam(name = "pageSize", value = "每页条数", defaultValue = "10"),
    @ApiImplicitParam(name = "buildingId", value = "楼栋Id", defaultValue = "2")
  })
  public Result findAllByBuildingId(@RequestParam Integer pageNum, Integer pageSize, Integer buildingId) {
    return houseService.findAllByBuildingId(pageNum - 1, pageSize, buildingId);
  }

  @GetMapping(value = "getById")
  @ApiOperation("根据主键ID获取房屋接口")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "id", value = "房屋主键ID", defaultValue = "1")
  })
  public Result getById(@RequestParam Integer id) {
    return houseService.getById(id);
  }

  @GetMapping(value = "checkBuildingHouseNumber")
  @ApiOperation("查询当前楼栋房屋门牌号是否可用接口")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "buildingId", value = "楼栋Id", defaultValue = "2"),
      @ApiImplicitParam(name = "number", value = "房屋门牌号", defaultValue = "322")
  })
  public Result checkBuildingHouseNumber(@RequestParam Integer buildingId, Integer number) {
    return houseService.checkBuildingHouseNumber(buildingId, number);
  }

}
