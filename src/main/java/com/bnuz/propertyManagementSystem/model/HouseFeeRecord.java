package com.bnuz.propertyManagementSystem.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @Author: Hovees
 * @Date: 2019-10-15 08:49
 * @Version 1.0
 * 房屋物业费
 */

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "house_fee_record")
public class  HouseFeeRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(value = "主键ID", hidden = true)
  private Integer id;

  @ApiModelProperty(value = "所属楼盘Id", example = "1")
  private Integer propertyId; //所属楼盘Id

  @ApiModelProperty(value = "所属楼栋Id", example = "1")
  private Integer buildingId; //所属楼栋Id

  @ApiModelProperty(value = "房屋ID", example = "8")
  private Integer houseId; //房屋ID

  @ApiModelProperty(value = "年份", example = "2019")
  private Integer year; //年份

  @ApiModelProperty(value = "月份", example = "10")
  private Integer month; //月份

  @ApiModelProperty(value = "费用", example = "87.5")
  private Double fee; //费用

  @ApiModelProperty(value = "是否已缴费", example = "0")
  private Boolean isPaid; //是否已缴费

  @ApiModelProperty(value = "支付单号")
  private String outTradeNo;

  @ApiModelProperty(value = "支付方式")
  private String payType;

  @ApiModelProperty(value = "支付时间")
  private Date payTime;

  @Transient
  @ApiModelProperty(value = "费用名称")
  private String paymentName;

  @ManyToOne
  @JoinColumn(name = "houseId", insertable = false ,updatable = false)
  @JsonIgnore
  @JsonBackReference
  @ApiModelProperty(value = "所属房屋", hidden = true)
  private House house;

  public String getPaymentName() {
    String name = "";
    if(this.getHouse() != null){
      Property property = this.getHouse().getBuilding().getProperty();
      Building building = this.getHouse().getBuilding();
      House house = this.getHouse();
      name += property.getLocation() + property.getName();
      name += building.getName();
      name += house.getNumber();
      name += "物业费";
    }
    return name;
  }

}
