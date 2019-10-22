package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.ImageCode;
import com.bnuz.propertyManagementSystem.service.ValidateCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 验证码Controller
 *
 * @Author: Harry
 * @Date: 2019-09-20 19:52
 * @Version 1.0
 */
@RestController
@Api(tags = "验证码相关接口")
public class ValidateCodeController {
    public static final String SESSION_KEY="SESSION_KEY_IMAGE_CODE";

    @Autowired
    ValidateCodeService validateCodeService;

    /**
     * 返回验证码到前端
     * @param response
     * @param request
     * @throws IOException
     */
    @GetMapping("/code/image")
    @ApiOperation("生成验证码接口")
    public void createCode(HttpServletResponse response, HttpServletRequest request) throws IOException {

        ImageCode imageCode = validateCodeService.createImageCode();

        validateCodeService.saveValidateCodeInRedis(imageCode.getCode(),request.getRemoteAddr());

        ImageIO.write(imageCode.getImage(),"JPEG",response.getOutputStream());//写到相应的输出流中 中间是格式
    }
    


}