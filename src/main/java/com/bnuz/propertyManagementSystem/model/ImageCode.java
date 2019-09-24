package com.bnuz.propertyManagementSystem.model;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @Author: Harry
 * @Date: 2019-09-20 19:51
 * @Version 1.0
 */
public class ImageCode {
    /**
     * 验证码图片
     */
    private BufferedImage image;

    /**
     * 验证码
     */
    private String code;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    public ImageCode(BufferedImage image, String code,int expireIn) {//超时时间
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }


    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "ImageCode{" +
                "image=" + image +
                ", code='" + code + '\'' +
                ", expireTime=" + expireTime +
                '}';
    }
}