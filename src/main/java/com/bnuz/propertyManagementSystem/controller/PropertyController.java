package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.Property;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.service.PropertyService;
import io.swagger.annotations.Api;
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
 * @Date: 2019-10-07 13:35
 * @Version 1.0
 */

@RestController
@RequestMapping("property")
@Api(tags = "楼盘模块相关接口")
public class PropertyController {

  @Autowired
  private PropertyService propertyService;

  @PostMapping(value = "insert")
  @ApiOperation("新增楼盘接口")
  public Result insert(@RequestBody Property property) {
    return propertyService.insert(property);
  }

  @PatchMapping(value = "update")
  @ApiOperation("更新楼盘接口")
  public Result update(@RequestBody Property property) {
    return propertyService.update(property);
  }

  @DeleteMapping(value = "delete")
  @ApiOperation("删除楼盘接口")
  public Result delete(@RequestBody Property property) {
    return propertyService.delete(property);
  }


  @GetMapping(value = "findAll")
  @ApiOperation("获取所有楼盘并分页接口")
  public Result findAll(@RequestParam Integer pageNum, Integer pageSize) {
    return propertyService.findAll(pageNum - 1, pageSize);
  }

  @GetMapping("getById")
  @ApiOperation("根据ID获取楼盘接口")
  public Result getById(@RequestParam Integer id) {
    return propertyService.getById(id);
  }

  @GetMapping("getByUid")
  @ApiOperation("根据编码获取楼盘接口")
  public Result getByUid(@RequestParam Integer uid) {
    return propertyService.getByUid(uid);
  }

  @GetMapping("checkPropertyName")
  @ApiOperation("检查楼盘名字是否存在接口")
  public Result checkPropertyName(@RequestParam String propertyName){
    return propertyService.getByName(propertyName);
  }

}
