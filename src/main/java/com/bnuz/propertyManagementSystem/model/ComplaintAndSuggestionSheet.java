package com.bnuz.propertyManagementSystem.model;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * complaint_and_suggestion_sheet
 * @author 
 */
public class ComplaintAndSuggestionSheet implements Serializable {
    /**
     * 投诉建议单Id
     */
    private Integer id;

    /**
     * 单子创建用户ID
     */
    private Integer proprietorId;

    /**
     * 单子状态
     */
    private String state;

    /**
     * 提交时间
     */
    private Date submitTime;

    /**
     * 最新处理时间
     */
    private Date processingTime;

    /**
     * 用户昵称
     */
    private String userNickName;

    /**
     * 单子类型
     */
    private String sheetType;

    /**
     * 投书建议单内容(备注)
     */
    private String message;

    /**
     * 主题
     */
    private String title;

    /**
     * 图片List
     */
    private List<ComplaintAndSuggestionSheetImage> imageList;

    /**
     * 时间表List
     */
    private List<ComplaintAndSuggestionSheetTimeline> timelineList;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProprietorId() {
        return proprietorId;
    }

    public void setProprietorId(Integer proprietorId) {
        this.proprietorId = proprietorId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Date getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(Date processingTime) {
        this.processingTime = processingTime;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getSheetType() {
        return sheetType;
    }

    public void setSheetType(String sheetType) {
        this.sheetType = sheetType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ComplaintAndSuggestionSheetImage> getImageList() {
        return imageList;
    }

    public void setImageList(List<ComplaintAndSuggestionSheetImage> imageList) {
        this.imageList = imageList;
    }

    public List<ComplaintAndSuggestionSheetTimeline> getTimelineList() {
        return timelineList;
    }

    public void setTimelineList(List<ComplaintAndSuggestionSheetTimeline> timelineList) {
        this.timelineList = timelineList;
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
            && (this.getProprietorId() == null ? other.getProprietorId() == null : this.getProprietorId().equals(other.getProprietorId()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getSubmitTime() == null ? other.getSubmitTime() == null : this.getSubmitTime().equals(other.getSubmitTime()))
            && (this.getProcessingTime() == null ? other.getProcessingTime() == null : this.getProcessingTime().equals(other.getProcessingTime()))
            && (this.getUserNickName() == null ? other.getUserNickName() == null : this.getUserNickName().equals(other.getUserNickName()))
            && (this.getSheetType() == null ? other.getSheetType() == null : this.getSheetType().equals(other.getSheetType()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProprietorId() == null) ? 0 : getProprietorId().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getSubmitTime() == null) ? 0 : getSubmitTime().hashCode());
        result = prime * result + ((getProcessingTime() == null) ? 0 : getProcessingTime().hashCode());
        result = prime * result + ((getUserNickName() == null) ? 0 : getUserNickName().hashCode());
        result = prime * result + ((getSheetType() == null) ? 0 : getSheetType().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", proprietorId=").append(proprietorId);
        sb.append(", state=").append(state);
        sb.append(", submitTime=").append(submitTime);
        sb.append(", processingTime=").append(processingTime);
        sb.append(", userNickName=").append(userNickName);
        sb.append(", sheetType=").append(sheetType);
        sb.append(", message=").append(message);
        sb.append(", title=").append(title);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}