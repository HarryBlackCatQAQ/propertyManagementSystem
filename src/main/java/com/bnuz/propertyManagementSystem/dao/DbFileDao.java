package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.DbFile;
import com.bnuz.propertyManagementSystem.model.DbFileExample;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DbFileDao继承基类
 */
@Repository
public interface DbFileDao extends MyBatisBaseDao<DbFile, Integer, DbFileExample> {

    @Select("SELECT * FROM db_file order by backupTime desc")
    public List<DbFile> getDbFile();
}