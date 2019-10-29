package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.service.QRCodeService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
/**
 * @Author: Harry
 * @Date: 2019-10-24 17:39
 * @Version 1.0
 */

@RestController
@RequestMapping("/QRcode")
@Api("二维码相关接口")
@Slf4j
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping("/create")
    public Result getQrCode(HttpServletResponse response, String qrCodeUrl){
        return qrCodeService.getQrCodeBase64String(qrCodeUrl,300,300,1);
    }
}