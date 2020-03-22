package com.bnuz.propertyManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * building
 * @author hovees
 * @date 2019-10-07 13:32
 * 楼栋
 */

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "building")
public class Building implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键ID", hidden = true)
    private Integer id;

    @ApiModelProperty(value = "楼栋名称", example = "京华五栋")
    private String name; //楼栋名称

    @ApiModelProperty(value = "楼栋地址", example = "广东省珠海市香洲区金凤路18号")
    private String address; //楼栋地址

    @ApiModelProperty(value = "楼栋层数", example = "9")
    private Integer layer; //楼栋层数

    @ApiModelProperty(value = "楼栋户数", example = "651")
    private Integer houseHold; //楼栋户数

    @ApiModelProperty(value = "所属楼盘Id", example = "3")
    private Integer propertyId; //所属楼盘Id

    @ApiModelProperty(value = "楼栋备注")
    private String remark; //楼栋备注

    @ManyToOne
    @JoinColumn(name = "propertyId", insertable = false ,updatable = false)
    @JsonIgnore
    @JsonBackReference
    @ApiModelProperty(value = "所属楼盘", hidden = true)
    private Property property; //所属楼盘

    @OneToMany(mappedBy = "building")
    @JsonIgnore
    @ApiModelProperty(value = "楼栋房屋集合", hidden = true)
    private List<House> houses; //楼栋房屋集合

    private static final long serialVersionUID = 1L;

}