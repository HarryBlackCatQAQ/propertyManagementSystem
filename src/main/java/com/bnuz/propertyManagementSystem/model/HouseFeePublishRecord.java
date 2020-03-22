package com.bnuz.propertyManagementSystem.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "house_fee_publish_record")
public class HouseFeePublishRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(value = "主键ID", hidden = true)
  private Integer id;

  @ApiModelProperty(value = "费用名字", example = "2020年3月份物业费")
  private String paymentName; //费用名字

  @ApiModelProperty(value = "费用价格", example = "10.2")
  private Double price; //费用价格

  @CreatedDate
  @ApiModelProperty(value = "发布时间", hidden = true)
  private Date publishTime; //发布时间

  @ApiModelProperty(value = "发布者Id")
  private Integer publisherId; //发布者Id

  @ApiModelProperty(value = "状态", example = "1", hidden = true)
  private Integer status; //状态

  @ManyToOne
  @JoinColumn(name = "publisherId", insertable = false ,updatable = false)
  @ApiModelProperty(value = "发布者", hidden = true)
  private User user;

}
