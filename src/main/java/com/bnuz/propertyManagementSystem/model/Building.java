package com.bnuz.propertyManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * building
 * @author hovees
 */

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "building")
public class Building implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name; //楼栋名称

    private String address; //楼栋地址

    private Integer layer; //楼栋层数

    private Integer houseHold; //楼栋户数

    private Long uid; //楼栋编号

    private Long propertyUid; //所属楼盘Uid

//    @ManyToOne
//    @JoinColumn(name = "uid", insertable = false ,updatable = false)
//    @JsonBackReference
//    private Property property; //所属楼盘

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
        Building other = (Building) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getLayer() == null ? other.getLayer() == null : this.getLayer().equals(other.getLayer()))
            && (this.getHouseHold() == null ? other.getHouseHold() == null : this.getHouseHold().equals(other.getHouseHold()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getPropertyUid() == null ? other.getPropertyUid() == null : this.getPropertyUid().equals(other.getPropertyUid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getLayer() == null) ? 0 : getLayer().hashCode());
        result = prime * result + ((getHouseHold() == null) ? 0 : getHouseHold().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getPropertyUid() == null) ? 0 : getPropertyUid().hashCode());
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
        sb.append(", address=").append(address);
        sb.append(", layer=").append(layer);
        sb.append(", houseHold=").append(houseHold);
        sb.append(", uid=").append(uid);
        sb.append(", propertyUid=").append(propertyUid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}