package com.bnuz.propertyManagementSystem.service.scheduling;

import com.bnuz.propertyManagementSystem.dao.LogFileDao;
import com.bnuz.propertyManagementSystem.model.LogFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Harry
 * @Date: 2019-10-19 13:33
 * @Version 1.0
 */
@Component
public class LogFileScheduling {

    private static final String path = "./logs";

    private static final String rootFileName = "root";

    @Autowired
    private LogFileDao logFileDao;

    @Scheduled(cron = "0 20 0 * * ?")
    public void schedulingInsertLogFile(){

        List<LogFile> nowList = new ArrayList<>();

        dfsLocalLogFile(path,0,nowList,rootFileName);

        List<LogFile> dataBaseList = logFileDao.getAllLogFile();

        dfsJudge(nowList,dataBaseList);
    }

    private void dfsJudge(List<LogFile> list,List<LogFile> dataBaseList){
        for(LogFile logFile:list){
            boolean flag = false;
            for(LogFile db:dataBaseList){
                if(equalsWithOutId(logFile,db)){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                logFileDao.insert(logFile);
            }

            if(logFile.getLogFileList() != null){
                dfsJudge(logFile.getLogFileList(),dataBaseList);
            }
        }
    }

    private boolean equalsWithOutId(LogFile a,LogFile b){
        return a.getFileName().equals(b.getFileName()) &&
                a.getIsDir().equals(b.getIsDir()) &&
                a.getPath().equals(b.getPath()) &&
                a.getLevel().equals(b.getLevel()) &&
                a.getPreLevelName().equals(b.getPreLevelName());
    }


    private void dfsLocalLogFile(String path, int level, List<LogFile> list, String preFileName){
        File file = new File(path);
        File[] files = file.listFiles();


        for(File f: files){
            LogFile logFile = new LogFile();
            logFile.setFileName(f.getName());
            logFile.setPath(f.getAbsolutePath());
            logFile.setLevel(level);
            logFile.setPreLevelName(preFileName);

            if(f.isDirectory()){
                logFile.setIsDir(1);
                List<LogFile> tp = new ArrayList<>();
                logFile.setLogFileList(tp);
                list.add(logFile);
//                logFileDao.insert(logFile);
                dfsLocalLogFile(f.getAbsolutePath(),level + 1,tp,f.getName());
            }
            else{
                logFile.setIsDir(0);
                list.add(logFile);
//                logFileDao.insert(logFile);
            }
        }
    }
}