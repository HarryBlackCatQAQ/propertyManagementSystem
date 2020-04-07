package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.DbFileDao;
import com.bnuz.propertyManagementSystem.model.DbFile;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.service.DataBaseBackupService;
import com.bnuz.propertyManagementSystem.util.DateUtil;
import com.bnuz.propertyManagementSystem.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zeroturnaround.zip.ZipUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @Author: Harry
 * @Date: 2020-04-06 16:37
 * @Version 1.0
 */

@Slf4j
@Service
@Transactional
public class DataBaseBackupServiceImpl implements DataBaseBackupService {

    @Value("${db.host}")
    private String host;
    @Value("${db.port}")
    private String port;
    @Value("${db.dbname}")
    private String dbName;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;

    private final static String savePath = "/Users/harry/mysqlBackUp";
    private final static String dbFileFormat = "yyyy_MM_dd_HH_mm_ss";
    private final static String dbFileTempDir = "./dbfile";

    @Autowired
    private DateUtil dateUtil;
    @Autowired
    private FileUtil fileUtil;
    @Autowired
    private DbFileDao dbFileDao;


    public Result downLoadDBfile(List<DbFile> list, HttpServletResponse response) {

        synchronized (DataBaseBackupServiceImpl.class){
//            System.err.println(list);
            for(DbFile dbFile :list){
                fileUtil.copyFile(dbFile.getPath(),dbFileTempDir + "/temp/" + dbFile.getFileName(),dbFileTempDir + "/temp/");
            }
            String filename = "数据库文件备份.zip";
            ZipUtil.pack(new File(dbFileTempDir + "/temp"),new File(dbFileTempDir + "/" + filename));

            String filepath = dbFileTempDir + "/" + filename;
            fileUtil.downFile(response,filename,filepath);
            fileUtil.delFolder(dbFileTempDir + "/temp");
            fileUtil.delFile(dbFileTempDir + "/" + filename);
        }
        return new Result();
    }

    @Override
    public Result getDbFileList() {
        List<DbFile> list = dbFileDao.getDbFile();

        return new Result(true,ResultStatusCode.OK,"获取列表成功!",list);
    }

    public Result saveDbFile(){
        synchronized (DataBaseBackupServiceImpl.class){
            Date now = dateUtil.getNow();
            String fileName = dateUtil.formatDate(now,dbFileFormat);
            if(backupDB(fileName)){
                DbFile dbFile = new DbFile();
                dbFile.setBackupTime(now);
                dbFile.setFileName(fileName + ".sql");
                dbFile.setPath(savePath + "/" + fileName + ".sql");
                dbFileDao.insert(dbFile);

                return new Result(true, ResultStatusCode.OK,"备份成功!");
            }
            else{
                return new Result(false, ResultStatusCode.ERROR,"备份失败!");
            }
        }
    }

    private boolean backupDB(String fileName){
        try {

            fileUtil.mkDirs(savePath);

            String str = "mysqldump "+ "-h" + host +" -u" + userName + " -p"+ password+
                    " -P" + port + " "  + dbName + " > "
                    + savePath + "/" + fileName
                    + ".sql";

            System.err.println(str);

            String[] cmd = new String[]{"sh","-c",str};

            Process process = Runtime.getRuntime().exec(cmd);

            int tp = process.waitFor();

            System.err.println(tp);
//            System.err.println("@@@@@@@");
//            return true;
            if(tp == 0){
//                System.err.println("@@@@@@@");
                return true;
//                return new Result(true, ResultStatusCode.OK,"备份成功!");
            }



        } catch (Exception e) {
            log.error("数据库备份失败");
            log.warn("提示:如果是使用windows电脑的话命令需要改变，该系统默认linux下使用的命令行");
            e.printStackTrace();
        }

//        System.err.println(31234124);

//        return true;
        return false;
//        return new Result(false, ResultStatusCode.ERROR,"备份失败!");
    }
}