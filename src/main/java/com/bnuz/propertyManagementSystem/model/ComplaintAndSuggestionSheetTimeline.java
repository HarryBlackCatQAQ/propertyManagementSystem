package com.bnuz.propertyManagementSystem.model;

import java.io.Serializable;
import java.util.Date;

/**
 * complaint_and_suggestion_sheet_timeline
 * @author 
 */
public class ComplaintAndSuggestionSheetTimeline implements Serializable {
    /**
     * 时间表id
     */
    private Integer id;

    /**
     * 时间表所属单子id
     */
    private Integer sheetId;

    /**
     * 处理时间
     */
    private Date processingTime;

    /**
     * 处理信息
     */
    private String message;

    /**
     * 处理人的昵称
     */
    private String processingUserNickName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSheetId() {
        return sheetId;
    }

    public void setSheetId(Integer sheetId) {
        this.sheetId = sheetId;
    }

    public Date getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(Date processingTime) {
        this.processingTime = processingTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProcessingUserNickName() {
        return processingUserNickName;
    }

    public void setProcessingUserNickName(String processingUserNickName) {
        this.processingUserNickName = processingUserNickName;
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
        ComplaintAndSuggestionSheetTimeline other = (ComplaintAndSuggestionSheetTimeline) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSheetId() == null ? other.getSheetId() == null : this.getSheetId().equals(other.getSheetId()))
            && (this.getProcessingTime() == null ? other.getProcessingTime() == null : this.getProcessingTime().equals(other.getProcessingTime()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
            && (this.getProcessingUserNickName() == null ? other.getProcessingUserNickName() == null : this.getProcessingUserNickName().equals(other.getProcessingUserNickName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSheetId() == null) ? 0 : getSheetId().hashCode());
        result = prime * result + ((getProcessingTime() == null) ? 0 : getProcessingTime().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
        result = prime * result + ((getProcessingUserNickName() == null) ? 0 : getProcessingUserNickName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sheetId=").append(sheetId);
        sb.append(", processingTime=").append(processingTime);
        sb.append(", message=").append(message);
        sb.append(", processingUserNickName=").append(processingUserNickName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}