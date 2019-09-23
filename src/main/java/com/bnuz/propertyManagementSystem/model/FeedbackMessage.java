package com.bnuz.propertyManagementSystem.model;

import java.io.Serializable;
import java.util.Date;

/**
 * feedback_message
 * @author 
 */
public class FeedbackMessage implements Serializable {
    private Integer id;

    /**
     * 单子的ID
     */
    private Integer sheetid;

    /**
     * 回馈时间
     */
    private Date feedbacktime;

    /**
     * 反馈内容
     */
    private String message;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSheetid() {
        return sheetid;
    }

    public void setSheetid(Integer sheetid) {
        this.sheetid = sheetid;
    }

    public Date getFeedbacktime() {
        return feedbacktime;
    }

    public void setFeedbacktime(Date feedbacktime) {
        this.feedbacktime = feedbacktime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        FeedbackMessage other = (FeedbackMessage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSheetid() == null ? other.getSheetid() == null : this.getSheetid().equals(other.getSheetid()))
            && (this.getFeedbacktime() == null ? other.getFeedbacktime() == null : this.getFeedbacktime().equals(other.getFeedbacktime()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSheetid() == null) ? 0 : getSheetid().hashCode());
        result = prime * result + ((getFeedbacktime() == null) ? 0 : getFeedbacktime().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sheetid=").append(sheetid);
        sb.append(", feedbacktime=").append(feedbacktime);
        sb.append(", message=").append(message);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}