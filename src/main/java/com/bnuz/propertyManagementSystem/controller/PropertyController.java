package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.Property;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PropertyController {

  @Autowired
  private PropertyService propertyService;

  @PostMapping(value = "insert")
  public Result insert(@RequestBody Property property){
    return propertyService.insert(property);
  }

  @RequestMapping(value = "/id")
  public Result getById(@RequestParam("id") Integer id){
    return propertyService.getById(id);
  }

}
