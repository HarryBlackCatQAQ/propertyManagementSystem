package com.bnuz.propertyManagementSystem.model;

import java.io.Serializable;
import java.util.List;

/**
 * log_file
 * @author
 */
public class LogFile implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 文件目录深度
     */
    private Integer level;

    /**
     * 文件名字
     */
    private String fileName;

    /**
     * 路径
     */
    private String path;

    /**
     * 是否为文件夹
     */
    private Integer isDir;

    /**
     * 上一级名称
     */
    private String preLevelName;

    private List<LogFile> logFileList;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getIsDir() {
        return isDir;
    }

    public void setIsDir(Integer isDir) {
        this.isDir = isDir;
    }

    public String getPreLevelName() {
        return preLevelName;
    }

    public void setPreLevelName(String preLevelName) {
        this.preLevelName = preLevelName;
    }

    public List<LogFile> getLogFileList() {
        return logFileList;
    }

    public void setLogFileList(List<LogFile> logFileList) {
        this.logFileList = logFileList;
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
        LogFile other = (LogFile) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
                && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
                && (this.getPath() == null ? other.getPath() == null : this.getPath().equals(other.getPath()))
                && (this.getIsDir() == null ? other.getIsDir() == null : this.getIsDir().equals(other.getIsDir()))
                && (this.getPreLevelName() == null ? other.getPreLevelName() == null : this.getPreLevelName().equals(other.getPreLevelName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getPath() == null) ? 0 : getPath().hashCode());
        result = prime * result + ((getIsDir() == null) ? 0 : getIsDir().hashCode());
        result = prime * result + ((getPreLevelName() == null) ? 0 : getPreLevelName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", level=").append(level);
        sb.append(", fileName=").append(fileName);
        sb.append(", path=").append(path);
        sb.append(", isDir=").append(isDir);
        sb.append(", preLevelName=").append(preLevelName);
        sb.append(", logFileList=").append(logFileList);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}