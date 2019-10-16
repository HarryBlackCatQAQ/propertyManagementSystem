package com.bnuz.propertyManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * property
 * @author hovees
 * @date 2019-10-07 13:32
 * 楼盘
 */

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "property")
public class Property implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键ID", hidden = true)
    private Integer id;

    @ApiModelProperty(value = "楼盘名称", example = "京师家园")
    private String name; //楼盘名称

    @ApiModelProperty(value = "楼盘位置", example = "广东省珠海市香洲区金凤路18号")
    private String location; //楼盘位置

    @ApiModelProperty(value = "楼盘编号", example = "519087")
    private Long uid; //楼盘编号

    @OneToMany(mappedBy = "property")
    @JsonIgnore
    @ApiModelProperty(value = "楼盘楼栋集合", hidden = true)
    private List<Building> buildings; //楼盘楼栋集合

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Property other = (Property) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", location=").append(location);
        sb.append(", uid=").append(uid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}