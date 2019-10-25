package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.Result;
import com.google.zxing.WriterException;

import java.io.IOException;

public interface QRCodeService {

    public void createQRCode(String content, int width, int height, int margin, String imgPath,String imgName) throws WriterException, IOException;

    public byte[] getQRCodeBytes(String content, int width, int height, int margin) throws Exception;

    public Result getQrCodeBase64String(String content, int width, int height, int margin);
}
