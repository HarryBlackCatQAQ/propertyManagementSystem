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
@Table(name = "equipment_purchase")
public class EquipmentPurchase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(value = "主键ID", hidden = true)
  private Integer id;

  @ApiModelProperty(value = "申请人Id")
  private Integer applicantId;

  @ApiModelProperty(value = "审核人Id")
  private Integer reviewerId;

  @ApiModelProperty(value = "设备名称")
  private String name;

  @ApiModelProperty(value = "数量")
  private Integer amount;

  @ApiModelProperty(value = "备注")
  private String remark;

  @ApiModelProperty(value = "状态", hidden = true)
  private String status;

  @CreatedDate
  @ApiModelProperty(value = "申请时间", hidden = true)
  private Date createTime;

  @ApiModelProperty(value = "审核时间", hidden = true)
  private Date reviewTime;

  @ApiModelProperty(value = "完成时间", hidden = true)
  private Date completeTime;

  @ManyToOne
  @JoinColumn(name = "applicantId", insertable = false ,updatable = false)
  @ApiModelProperty(value = "申请人", hidden = true)
  private User applicant;

  @ManyToOne
  @JoinColumn(name = "reviewerId", insertable = false ,updatable = false)
  @ApiModelProperty(value = "审核人", hidden = true)
  private User reviewer;

}
