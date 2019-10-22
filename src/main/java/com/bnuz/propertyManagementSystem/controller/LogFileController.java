package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.LogFile;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.service.LogFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: Harry
 * @Date: 2019-10-18 12:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "日志管理相关接口")
public class LogFileController {

    @Autowired
    private LogFileService logFileService;

    @GetMapping("/getLogFileListByFileName")
    @ApiOperation("获取文件列表")
    public Result getLogFileListByFileName(String preLevelName){
        return logFileService.getLogFileList(preLevelName);
    }

    @PostMapping("/downLoadLogFile")
    @ApiOperation("下载日志文件")
    public void downLoadLogFile(@RequestBody List<LogFile> list, HttpServletResponse response){
        logFileService.downLoadLogFile(list,response);
    }

    @GetMapping("/updateLogFile")
    @ApiOperation("手动更新本地日志")
    public Result updateLogFile(){
        return logFileService.updateLogFile();
    }
}