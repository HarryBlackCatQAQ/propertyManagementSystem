package com.bnuz.propertyManagementSystem.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @Author: Hovees
 * @Date: 2019-10-14 16:41
 * @Version 1.0
 * 房屋
 */

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "house")
public class House {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(value = "主键ID", hidden = true)
  private Integer id;

  @ApiModelProperty(value = "房屋门牌", example = "322")
  private Integer number; //房屋门牌

  @ApiModelProperty(value = "房屋面积", example = "40.5")
  private Double area; //房屋面积

  @ApiModelProperty(value = "房屋朝向", example = "北")
  private String direction; //房屋朝向

  @ApiModelProperty(value = "房屋楼层", example = "3")
  private Integer floor; //房屋楼层

  @ApiModelProperty(value = "所属楼栋ID", example = "2")
  private Integer buildingId; //所属楼栋ID

  @ManyToOne
  @JoinColumn(name = "buildingId", insertable = false ,updatable = false)
  @JsonIgnore
  @JsonBackReference
  @ApiModelProperty(value = "所属楼栋", hidden = true)
  private Building building; //所属楼栋

}
