package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileUploadService {

    public Result uploadComplaintAndSuggestionImage(MultipartFile[] files, Integer sheetId) throws IOException;
}
