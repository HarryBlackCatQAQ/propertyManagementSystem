package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.ImageCode;

public interface ValidateCodeService {
    /**
     * 随机生成验证码 默认过期时间1分钟
     * @return
     */
    public ImageCode createImageCode();

    /**
     * 随机生成验证码 可以设置过期时间 单位为秒
     * @param seconds
     * @return
     */
    public ImageCode createImageCode(int seconds);
}
