package com.bnuz.propertyManagementSystem.service.scheduling;

import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.service.DataBaseBackupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: Harry
 * @Date: 2020-04-07 01:58
 * @Version 1.0
 */

@Component
@Slf4j
public class DataBaseBackUpScheduling {

    @Autowired
    private DataBaseBackupService dataBaseBackupService;

    @Scheduled(cron = "0 35 0 * * ?")
    public void scheduledDBFile(){
        Result result = dataBaseBackupService.saveDbFile();
        if(result.isFlag()){
            log.info("定时备份数据库文件成功!");
        }
        else{
            log.warn("定时备份数据库文件失败!");
        }
    }
}