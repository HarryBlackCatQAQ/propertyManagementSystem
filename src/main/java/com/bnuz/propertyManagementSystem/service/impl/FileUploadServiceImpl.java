package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.ComplaintAndSuggestionSheetImageDao;
import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheetImage;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.service.FileUploadService;
import com.bnuz.propertyManagementSystem.util.DateUtil;
import com.bnuz.propertyManagementSystem.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

/**
 * @Author: Harry
 * @Date: 2019-10-14 16:42
 * @Version 1.0
 */
@Service("FileUploadServiceImpl")
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private FileUtil fileUtil;

    @Autowired
    private DateUtil dateUtil;

    /**
     * 写入图片路径(暂时)
     */
    private final static String complaintAndSuggestionSheetImagePath = "/Users/harry/logs/image/complaintAndSuggestionSheetImage";

    @Autowired
    private ComplaintAndSuggestionSheetImageDao complaintAndSuggestionSheetImageDao;

    @Override
    public Result uploadComplaintAndSuggestionImage(MultipartFile[] files, Integer sheetId) {

        int counter = 1;
        for(MultipartFile file : files){
            String path = complaintAndSuggestionSheetImagePath;

            try {
                fileUtil.mkDirs(path);
            } catch (IOException e) {
                log.info("创建文件夹:" + path + "失败!");
            }
            path += "/" + complaintAndSuggestionImageNameCreate(file,counter,sheetId);
            File file1 = new File(path);
            OutputStream o = null;
            try {

                o = new FileOutputStream(file1);
                boolean res = fileUtil.writeFile((FileInputStream) file.getInputStream(),o);
                if(res){
                    ComplaintAndSuggestionSheetImage image = new ComplaintAndSuggestionSheetImage();
                    image.setSheetId(sheetId);
                    image.setPath(path);
                    complaintAndSuggestionSheetImageDao.insert(image);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return new Result(true, ResultStatusCode.OK,"上传成功!");
    }

    /**
     * complaintAndSuggestionImageNameCreate命名规则
     * @param file
     * @param counter
     * @param sheetId
     * @return
     */
    private String complaintAndSuggestionImageNameCreate(MultipartFile file,int counter,int sheetId){
        Date now = dateUtil.getNow();
        String date = dateUtil.formatLDateTime(now);
        String[] str = fileUtil.getFileNameSplitSuffix(file.getOriginalFilename());
        String oldImageName = str[0];
        String imageType = str[1];

        return date + "-" + oldImageName + "-" + "sId" + sheetId + "c" + counter + imageType;
    }
}