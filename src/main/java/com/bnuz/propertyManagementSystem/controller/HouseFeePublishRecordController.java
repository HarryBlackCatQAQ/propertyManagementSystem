package com.bnuz.propertyManagementSystem.controller;


import com.bnuz.propertyManagementSystem.model.HouseFeePublishRecord;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.service.HouseFeePublishRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/houseFeePublishRecord")
@RestController
@Api(tags = "物业管理费发布相关接口")
public class HouseFeePublishRecordController {

  @Autowired
  private HouseFeePublishRecordService houseFeePublishRecordService;

  @GetMapping("/findAll")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "pageNum", value = "页码", defaultValue = "1"),
      @ApiImplicitParam(name = "pageSize", value = "每页条数", defaultValue = "10")
  })
  public Result findAll(Integer pageNum, Integer pageSize) {
    return houseFeePublishRecordService.findAll(pageNum - 1, pageSize);
  }

  @PostMapping("/publish")
  public Result publish(@RequestBody HouseFeePublishRecord houseFeePublishRecord){
    return houseFeePublishRecordService.publish(houseFeePublishRecord);
  }

}
