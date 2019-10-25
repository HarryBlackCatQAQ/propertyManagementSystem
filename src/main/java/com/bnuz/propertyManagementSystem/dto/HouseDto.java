package com.bnuz.propertyManagementSystem.dto;

import lombok.Data;

@Data
public class HouseDto {

  private Integer id;

  private Integer number; //房屋门牌

  private Double area; //房屋面积

  private String direction; //房屋朝向

  private Integer floor; //房屋楼层

  private Integer buildingId; //所属楼栋ID

  private Integer userId;

  private String nickName; //业主名字

}
