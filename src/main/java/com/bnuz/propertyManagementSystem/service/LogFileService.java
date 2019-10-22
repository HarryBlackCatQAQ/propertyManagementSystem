package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.LogFile;
import com.bnuz.propertyManagementSystem.model.Result;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface LogFileService {
    public Result getLogFileList(String preLevelName);

    public Result downLoadLogFile(List<LogFile> list, HttpServletResponse response);

    public Result updateLogFile();
}
