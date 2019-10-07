package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
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

  @RequestMapping(value = "/id")
  public Result getById(@RequestParam Integer id){
    return buildingService.getById(id);
  }

}
