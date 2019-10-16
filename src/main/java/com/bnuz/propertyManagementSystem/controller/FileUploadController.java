package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.service.FileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: Harry
 * @Date: 2019-10-13 23:32
 * @Version 1.0
 */

@RestController
@RequestMapping("/api/fileUpload")
@Api(tags = "文件上传接口")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/uploadComplaintAndSuggestionImage")
    @ApiOperation("上传投诉建议单的图片")
    public Result uploadComplaintAndSuggestionImage(MultipartFile[] files,Integer sheetId) throws IOException {
        return fileUploadService.uploadComplaintAndSuggestionImage(files,sheetId);
    }
}