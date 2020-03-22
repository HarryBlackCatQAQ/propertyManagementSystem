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

  private Integer userId; //业主ID

  private String ownerName; //业主名字

  public HouseDto(Integer id, Integer number, Double area, String direction, Integer floor,
      Integer buildingId, Integer userId, String ownerName) {
    this.id = id;
    this.number = number;
    this.area = area;
    this.direction = direction;
    this.floor = floor;
    this.buildingId = buildingId;
    this.userId = userId;
    this.ownerName = ownerName;
  }

}
