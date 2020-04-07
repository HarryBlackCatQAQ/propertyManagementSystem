package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.DbFile;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.service.DataBaseBackupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: Harry
 * @Date: 2020-04-06 19:03
 * @Version 1.0
 */

@RestController
@RequestMapping("/admin/DataBaseBackup")
@Api(tags = "数据库文件管理相关接口")
public class DataBaseBackupController {

    @Autowired
    private DataBaseBackupService dataBaseBackupService;

    @GetMapping(value = "/save")
    @ApiOperation("备份数据库文件")
    public Result save(){
        return dataBaseBackupService.saveDbFile();
    }

    @PostMapping("/downLoadDbFile")
    @ApiOperation("下载日志文件")
    public void downLoadDbFile(@RequestBody List<DbFile> list, HttpServletResponse response){
        dataBaseBackupService.downLoadDBfile(list,response);
    }

    @GetMapping(value = "/getDbFileList")
    @ApiOperation("获取数据库备份文件列表")
    public Result getDbFileList(){
        return dataBaseBackupService.getDbFileList();
    }
}