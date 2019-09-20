package com.bnuz.propertyManagementSystem.model;

import java.io.Serializable;
import java.util.Date;

/**
 * complaint_and_suggestion_sheet
 * @author 
 */
public class ComplaintAndSuggestionSheet implements Serializable {
    private Integer id;

    /**
     * 提交投诉建议单的业主Id
     */
    private Integer proprietorid;

    /**
     * 单子状态
     */
    private String state;

    /**
     * 提交时间
     */
    private Date submittime;

    /**
     * 处理时间
     */
    private Date processingtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProprietorid() {
        return proprietorid;
    }

    public void setProprietorid(Integer proprietorid) {
        this.proprietorid = proprietorid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }

    public Date getProcessingtime() {
        return processingtime;
    }

    public void setProcessingtime(Date processingtime) {
        this.processingtime = processingtime;
    }

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
        ComplaintAndSuggestionSheet other = (ComplaintAndSuggestionSheet) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProprietorid() == null ? other.getProprietorid() == null : this.getProprietorid().equals(other.getProprietorid()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getSubmittime() == null ? other.getSubmittime() == null : this.getSubmittime().equals(other.getSubmittime()))
            && (this.getProcessingtime() == null ? other.getProcessingtime() == null : this.getProcessingtime().equals(other.getProcessingtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProprietorid() == null) ? 0 : getProprietorid().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getSubmittime() == null) ? 0 : getSubmittime().hashCode());
        result = prime * result + ((getProcessingtime() == null) ? 0 : getProcessingtime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", proprietorid=").append(proprietorid);
        sb.append(", state=").append(state);
        sb.append(", submittime=").append(submittime);
        sb.append(", processingtime=").append(processingtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}