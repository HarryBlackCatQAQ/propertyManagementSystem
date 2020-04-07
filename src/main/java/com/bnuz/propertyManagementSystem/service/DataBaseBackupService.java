package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.DbFile;
import com.bnuz.propertyManagementSystem.model.Result;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface DataBaseBackupService {

    /**
     * 保存数据库备份文件
     * @return
     */
    public Result saveDbFile();

    /**
     * 下载数据库备份文件
     * @param list 数据库文件列表
     * @param response
     * @return
     */
    public Result downLoadDBfile(List<DbFile> list, HttpServletResponse response);

    /**
     * 获取数据库备份文件列表
     * @return
     */
    public Result getDbFileList();
}
