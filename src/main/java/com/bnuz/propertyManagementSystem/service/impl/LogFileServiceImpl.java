package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.LogFileDao;
import com.bnuz.propertyManagementSystem.model.LogFile;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.service.LogFileService;
import com.bnuz.propertyManagementSystem.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zeroturnaround.zip.ZipUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * @Author: Harry
 * @Date: 2019-10-18 12:06
 * @Version 1.0
 */
@Service("LogFileServiceImpl")
public class LogFileServiceImpl implements LogFileService {

    @Autowired
    private LogFileDao logFileDao;

    @Autowired
    private FileUtil fileUtil;

    @Override
    public Result getLogFileList(String preLevelName) {

        List<LogFile> list = logFileDao.getLogFileByPreFileName(preLevelName);

        for(LogFile logFile : list){
            if(logFile.getFileName().equals(".DS_Store")){
                list.remove(logFile);
                break;
            }
        }
        return new Result(true, ResultStatusCode.OK,"查询成功",list);
    }

    @Override
    public Result downLoadLogFile(List<LogFile> list, HttpServletResponse response) {

        synchronized (LogFileServiceImpl.class){
            for(LogFile logFile :list){
                if(logFile.getIsDir() == 1){
                    fileUtil.copyFolder(logFile.getPath(),"./logs/temp/" + logFile.getFileName());
                }
                else{
                    fileUtil.copyFile(logFile.getPath(),"./logs/temp/" + logFile.getFileName(),"./logs/temp/");
                }
            }

//        fileUtil.delFolder("./logs/temp");
            ZipUtil.pack(new File("./logs/temp"),new File("./logs/日志.zip"));
            String filename = "日志.zip";
            String filepath = "./logs/" + filename;
            fileUtil.downFile(response,filename,filepath);
            fileUtil.delFolder("./logs/temp");
            fileUtil.delFile("./logs/日志.zip");
        }
        return new Result();
    }
}