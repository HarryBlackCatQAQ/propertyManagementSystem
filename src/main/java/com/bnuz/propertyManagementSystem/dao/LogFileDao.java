package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.LogFile;
import com.bnuz.propertyManagementSystem.model.LogFileExample;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * LogFileDao继承基类
 */
@Repository
public interface LogFileDao extends MyBatisBaseDao<LogFile, Integer, LogFileExample> {

    @Select("SELECT * FROM log_file WHERE preLevelName = #{preLevelName} ")
    public List<LogFile> getLogFileByPreFileName(String preLevelName);
}