package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.Building;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.service.BuildingService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BuildingController {

  @Autowired
  private BuildingService buildingService;

  @PutMapping(value = "insert")
  public Result insert(@RequestBody Building building){
    return buildingService.insert(building);
  }

  @RequestMapping(value = "findAll")
  public Result findAll(@RequestParam Integer pageNum, Integer pageSize) {
    return buildingService.findAll(pageNum - 1, pageSize);
  }

  @RequestMapping(value = "getById")
  public Result getById(@RequestParam Integer id){
    return buildingService.getById(id);
  }

  @RequestMapping(value = "getByUid")
  public Result getByUid(@RequestParam Integer uid) {
    return buildingService.getByUid(uid);
  }

}
